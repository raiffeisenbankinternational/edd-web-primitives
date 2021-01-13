(ns web.primitives.layout.core
  (:require ["@material-ui/core" :refer [Grid]]
            [reagent.core :as r]))

(defn RawGrid [props & children]
  (into
   [:> Grid props]
   (for [child children]
     child)))
