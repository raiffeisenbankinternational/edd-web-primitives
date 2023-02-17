ARG DOCKER_URL
ARG DOCKER_ORG
ARG BUILD_ID
ARG PROJECT_NAME=edd-web-primitives

FROM ${DOCKER_URL}/${DOCKER_ORG}/web-img:latest

ENV PROJECT_NAME edd-web-primitives

ARG ARTIFACT_ORG
ARG BUILD_ID

# Custom build from here on
COPY --chown=build:build shadow-cljs.edn shadow-cljs.edn
COPY --chown=build:build deps.edn deps.edn
COPY --chown=build:build tests.edn tests.edn
COPY --chown=build:build karma.conf.js karma.conf.js
COPY --chown=build:build resources resources
COPY --chown=build:build src src

RUN ls -la


RUN mkdir -p /dist/s3
RUN ls -la /dist

RUN set -e &&\
    clojure -Sdeps '{:deps {cljfmt {:mvn/version "0.6.7"}}}' \
            -m cljfmt.main check src/main/ src/test

RUN ls -la /dist
RUN cp -r resources/public/* /dist/s3/
RUN sed -i 's/version=1/version='${BUILD_ID}'/g' /dist/s3/index.html
RUN ls -la /dist

ENV CHROME_BIN /usr/bin/chromium-browser

RUN set -e &&\
    npx shadow-cljs classpath &&\
    clojure -A:test:runner &&\
    shadow-cljs -A:test compile test &&\
    shadow-cljs -A:devcards release devcards &&\
    cp -r resources/public/* /dist/s3/ &&\
    npx karma start karma.conf.js  --log-level debug --single-run &&\
    clj -A:test -Sdeps '{:deps {luchiniatwork/cambada {:mvn/version "1.0.5"}}}' \
                      -m cambada.jar \
                      --aot "clojure.java.io" \
                      --app-version "1.0.${BUILD_ID}" \
                      --app-artifact-id "${PROJECT_NAME}" \
                      --app-group-id "${ARTIFACT_ORG}" \
                      --copy-source \
                      -o /dist/release-libs/ &&\
    cp pom.xml "/dist/release-libs/${PROJECT_NAME}-1.0.${BUILD_ID}.jar.pom.xml"


