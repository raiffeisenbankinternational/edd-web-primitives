(ns web.devcards.text-field
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [web.primitives.inputs.core :refer [RawTextField]]

   [devcards.core :refer-macros (defcard-rg)]
   [web.devcards.utils :refer [apply-stiles]]

   ["@material-ui/icons" :refer [Chat]]))

(defcard-rg text-field
  "## Text field"
  (apply-stiles [RawTextField {}]))

(defcard-rg text-field-disabled
  "## Text field disabled"
  (apply-stiles [RawTextField {:disabled true}]))

(defcard-rg text-field-with-prefix
  "## Text field with prefix"
  (apply-stiles [RawTextField {:label "Label" :prefix "Prefix" :default-value "value"}]))

(defcard-rg text-field-with-postfix
  "## Text field with postfix"
  (apply-stiles [RawTextField {:label "Label" :suffix "Suffix" :default-value "value"}]))

(defcard-rg text-field-with-postfix
  "## Text field with postfix"
  (apply-stiles [RawTextField {:label "Label" :prefix [:> Chat] :default-value "value" :helperText "help text"}]))
