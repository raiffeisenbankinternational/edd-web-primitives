(ns web.devcards.menu
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [reagent.core :as r]
   [devcards.core :refer-macros (defcard-rg)]
   [web.primitives.data-display.core :refer [RawMenu RawMenuList RawMenuItem]]
   [web.primitives.inputs.core :refer [RawButton]]
   [web.primitives.layout.core :refer [RawGrid]]
   [web.devcards.utils :refer [apply-stiles]]))

(defcard-rg menu
  "## Menu"
  (fn [data-atom _]
    (apply-stiles
     [RawGrid {:container true :item true}
      [RawButton {:on-click #(swap! data-atom assoc :open (. % -target))}
       "Menu"]
      [RawMenu {:id "menu"
                :anchor-el (:open @data-atom)
                :open (:open @data-atom)
                :on-close #(swap! data-atom assoc :open nil)}
       [RawMenuItem {:on-click #(swap! data-atom assoc :open nil)} "MenuItem1"]
       [RawMenuItem {:on-click #(swap! data-atom assoc :open nil)} "MenuItem2"]
       [RawMenuItem {:on-click #(swap! data-atom assoc :open nil)} "MenuItem3"]]]))
  (r/atom {:open nil}))
