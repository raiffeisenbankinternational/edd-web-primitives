(ns web.devcards.text-field
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [web.primitives.inputs.core :refer [RawTextField]]
   [devcards.core :refer-macros (defcard-rg)]
   [web.devcards.utils :refer [apply-stiles]]))

(defcard-rg text-field
  "## Text field"
  (apply-stiles [RawTextField {}]))

(defcard-rg text-field-disabled
  "## Text field disabled"
  (apply-stiles [RawTextField {:disabled true}]))
