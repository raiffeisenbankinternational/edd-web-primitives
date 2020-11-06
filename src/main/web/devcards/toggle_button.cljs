(ns web.devcards.toggle-button
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [devcards.core :refer-macros (defcard-rg)]

   [web.primitives.lab.core :refer [RawToggleButtonGroup RawToggleButton]]
   [web.devcards.utils :refer [apply-stiles]]
   [reagent.core :as r]))

(defcard-rg toggle-buttons
  "## Toggle Button"
  (fn [data-atom _]
    (apply-stiles [RawToggleButtonGroup
                   {:id        "button"
                    :on-change (fn [] (print "on-click"))}
                   [RawToggleButton {:value :one :selected (= :one (:selected @data-atom))} "One"]
                   [RawToggleButton {:value :two :selected (= :two (:selected @data-atom))} "Two"]
                   [RawToggleButton {:value :three :selected (= :three (:selected @data-atom))} "Three"]]))

  (r/atom {:selected :one}))
