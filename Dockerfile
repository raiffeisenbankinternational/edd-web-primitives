FROM alphaprosoft/web-base-img:b139
ENV PROJECT_NAME edd-web-primitives

# Custom build from here on

USER root
RUN npm install -g shadow-cljs@2.9.0 karma karma-cljs-test karma-chrome-launcher karma-junit-reporter
USER build

COPY --chown=build:build shadow-cljs.edn shadow-cljs.edn
COPY --chown=build:build deps.edn deps.edn
COPY --chown=build:build tests.edn tests.edn

RUN ls -la


RUN mkdir -p /dist/s3
RUN ls -la /dist
RUN npx shadow-cljs classpath

COPY --chown=build:build resources resources
COPY --chown=build:build src src


COPY --chown=build:build format.sh format.sh
RUN set -e &&\
    ./format.sh check

RUN set -e && npx shadow-cljs -A:dev compile

RUN ls -la /dist
RUN set -e && npx shadow-cljs release devcards

RUN set -e && clojure -A:test:runner
RUN set -e && npx shadow-cljs -A:dev compile

RUN ls -la /dist
RUN cp -r resources/public/* /dist/s3/

ARG BUILD_ID
RUN sed -i 's/version=1/version='${BUILD_ID}'/g' /dist/s3/index.html
RUN ls -la /dist


ARG DOCKER_ORG

RUN set -e && clj -Sdeps '{:deps {luchiniatwork/cambada {:mvn/version "1.0.5"}}}' \
                      -m cambada.jar \
                      --app-group-id "${DOCKER_ORG}" \
                      --app-version "1.0.b${BUILD_ID}" \
                      --app-artifact-id "${PROJECT_NAME}" \
                      --copy-source \
                      -o /dist/release-libs/ &&\
                    ls -la /dist/release-libs/ &&\
                    cat pom.xml &&\
                    cp pom.xml "/dist/release-libs/${PROJECT_NAME}-1.0.b${BUILD_ID}.jar.pom.xml"
