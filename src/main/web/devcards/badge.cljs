(ns web.devcards.badge
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [devcards.core :refer-macros (defcard-rg)]

   [web.primitives.data-display.core :refer [RawBadge]]
   [web.devcards.utils :refer [apply-stiles]]))

(defcard-rg badge
  "## Badge"
  (apply-stiles [RawBadge
                 {:id "badge"
                  :content "Amount of something"
                  :badge-content 15}]))
