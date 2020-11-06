(ns web.devcards.icon
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   ["@material-ui/core" :refer [Grid]]
   [devcards.core :refer-macros (defcard-rg)]

   [web.primitives.data-display.core :refer [RawIcon]]))

(defcard-rg icon
  "## Icon"
  [:> Grid {:container true}
   [:> Grid {:container true}
    [:> Grid {:item true :xs 1} "edit"]
    [:> Grid {:item true :xs 1} [RawIcon {:name "edit"}]]]
   [:> Grid {:container true}
    [:> Grid {:item true :xs 1} "wallet"]
    [:> Grid {:item true :xs 1} [RawIcon {:name "wallet"}]]]
   [:> Grid {:container true}
    [:> Grid {:item true :xs 1} "menu"]
    [:> Grid {:item true :xs 1} [RawIcon {:name "menu"}]]]])
