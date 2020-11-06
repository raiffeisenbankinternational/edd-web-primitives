FROM alphaprosoft/alpha-web:b75
ENV PROJECT_NAME web-primitives

ARG BUILD_ID
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

RUN set -e &&\
    clojure -Sdeps '{:deps {cljfmt {:mvn/version "0.6.7"}}}' \
            -m cljfmt.main check src/main/

RUN set -e && npx shadow-cljs -A:dev compile

RUN ls -la /dist
RUN set -e && npx shadow-cljs release devcards

RUN ls -la /dist
RUN cp -r resources/public/* /dist/s3/
RUN sed -i 's/version=1/version='${BUILD_ID}'/g' /dist/s3/index.html
RUN ls -la /dist

RUN clj -Sdeps '{:deps {luchiniatwork/cambada {:mvn/version "1.0.2"}}}' \
                      -m cambada.jar \
                      --app-version "1.0.b${BUILD_ID}" \
                      --app-artifact-id "${PROJECT_NAME}" \
                      --copy-source \
                      -o /dist/release-libs/; \
                    cp pom.xml "/dist/release-libs/${PROJECT_NAME}-1.0.b${BUILD_ID}.pom.xml"; \
