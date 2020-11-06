(ns web.devcards.start-ui
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [devcards.core :as dc]
   [web.devcards.date-picker]
   [web.devcards.text-editor]
   [web.devcards.text-field]
   [web.devcards.accordion]
   [web.devcards.autocomplete]
   [web.devcards.badge]
   [web.devcards.icon]
   [web.devcards.alert]
   [web.devcards.button]
   [web.devcards.skeleton]
   [web.devcards.switch]
   [web.devcards.checkbox]
   [web.devcards.toggle-button]))

(defn ^:export init []
  (dc/start-devcard-ui!))
