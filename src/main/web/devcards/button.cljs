(ns web.devcards.button
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [web.primitives.components :refer [RawButton EddButton]]
   [devcards.core :refer-macros (defcard-rg)]
   [web.devcards.utils :refer [apply-stiles]]))

(defcard-rg :button
  "## Button"
  (apply-stiles
   [RawButton {:id "button"} "Click me"]))

(defcard-rg :button-disabled
  "## Button disabled"
  (apply-stiles
   [RawButton {:id       "button-disabled"
               :disabled true} "Click me"]))

(defcard-rg :contained-button
  "## Contained Button"
  (apply-stiles
   [RawButton
    {:id       "contained-button"
     :variant  "contained"
     :color    "primary"
     :on-click (fn [] (print "on-click"))}
    "Click me"]))

(defcard-rg :contained-button-disabled
  "## Contained Button disabled"
  (apply-stiles
   [RawButton
    {:id       "contained-button-disabled"
     :disabled true
     :variant  "contained"
     :color    "primary"}
    "Click me"]))

(defcard-rg :contained-button-secondary
  "## Contained Button secondary"
  (apply-stiles
   [RawButton
    {:id       "contained-button-secondary"
     :variant  "contained"
     :color    "secondary"
     :on-click (fn [] (print "on-click"))}
    "Click me"]))

(defcard-rg :outlined-button
  "## Outlined Button"
  (apply-stiles
   [RawButton
    {:id       "button"
     :variant  "outlined"
     :on-click (fn [] (print "on-click"))}
    "Click me"]))

(defcard-rg :outlined-button-disabled
  "## Outlined Large Button"
  (apply-stiles
   [RawButton
    {:id       "outlined-button-disabled"
     :variant  "outlined"
     :disabled true}
    "Click me"]))

(defcard-rg :outlined-button-large
  "## Outlined Large Button"
  (apply-stiles
   [RawButton
    {:id       "outlined-button-large"
     :variant  "outlined"
     :size     "large"
     :color    "secondary"
     :on-click (fn [] (print "on-click"))}
    "Click me"]))

(defcard-rg :edd-button
  "## Edd Button"
  (apply-stiles
   [EddButton
    {:id       "edd-button-outlined-button-large"
     :variant  "outlined"
     :size     "large"
     :color    "secondary"
     :on-click (fn [] (print "on-click"))}
    "Click me"]))

(defcard-rg :edd-button-1
  "## Edd Button contained"
  (apply-stiles
   [EddButton
    {:id       "edd-button-contained"
     :variant  "contained"
     :size     "large"
     :color    "error"
     :confirmation {:confirm {:text "Yes, proceed"
                              :props {:color "secondary"
                                      :size     "small"}}
                    :cancel {:text "Cancel"
                             :props {:variant  "outlined"
                                     :color "secondary"
                                     :size     "small"}}}
     :on-click (fn [] (print "on-click"))}
    "Delete"]))
