(ns web.devcards.accordion
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [devcards.core :refer-macros (defcard-rg)]

   [web.primitives.surfaces.core :refer [EddAccordion]]
   [web.devcards.utils :refer [apply-stiles]]))

(defcard-rg accordion-init-expanded
  "## Initially expanded accordion"
  (apply-stiles [EddAccordion {:id "accordion-init-expanded"
                               :header       "Header"
                               :init-expanded? true}
                 "Content"]))

(defcard-rg accordion-control-position-right
  "## Expansion Panel with right control position"
  (apply-stiles [EddAccordion {:id "accordion-control-position-right"
                               :header                "Header"
                               :control-position :right}
                 "Content"]))

(defcard-rg accordion-with-different-headers
  "## Expansion Panel with right control position"
  (apply-stiles [EddAccordion {:id "accordion-with-different-headers"
                               :header                "Header"
                               :header-expanded "Show different header if Accordion expanded"}
                 "Content"]))
