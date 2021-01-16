#!/bin/bash

clojure -Sdeps '{:deps {cljfmt/cljfmt {:mvn/version "0.7.0"}}}' -m cljfmt.main "${1:-fix}" src/main/ src/test
