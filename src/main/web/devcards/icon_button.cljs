(ns web.devcards.icon-button
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [devcards.core :refer-macros (defcard-rg)]

   [web.primitives.inputs.core :refer [RawIconButton]]
   [web.devcards.utils :refer [apply-stiles]]
   ["@material-ui/icons" :refer [Add Close Delete]]))

(defcard-rg iconbutton-add
  "## IconButton Add"
  (apply-stiles [RawIconButton
                 {:id "button-add"
                  :on-click (fn [] (print "on-click"))}
                 [:> Add]]))

(defcard-rg iconbutton-close
  "## IconButton Close"
  (apply-stiles [RawIconButton
                 {:id "button-close"
                  :on-click (fn [] (print "on-click"))}
                 [:> Close]]))

(defcard-rg iconbutton-delete
  "## IconButton Delete"
  (apply-stiles [RawIconButton
                 {:id "button-delete"
                  :on-click (fn [] (print "on-click"))}
                 [:> Delete]]))
