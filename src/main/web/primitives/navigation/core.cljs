(ns web.primitives.navigation.core
  (:require ["@material-ui/core" :refer [Tabs Tab]]
            [reagent.core :as r]))

(defn RawTabs [props]
  (into
   [:> Tabs (dissoc props :children)]
   (map (fn [item-props] (r/as-element [:> Tab item-props])) (:tabs props))))