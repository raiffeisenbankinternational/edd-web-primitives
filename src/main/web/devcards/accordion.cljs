(ns web.devcards.accordion
  (:require
   [cljsjs.react]
   [cljsjs.react.dom]
   [devcards.core :refer-macros (defcard-rg)]

   [web.primitives.layout.core :refer [RawGrid]]
   [web.primitives.surfaces.core :refer [EddAccordion RawCard]]
   [web.primitives.inputs.core :refer [RawTextField]]
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

(def header-first-row
  [RawGrid {:container true :spacing 1}
   [RawGrid {:item true :xs 2} "Export Finance"]
   [RawGrid {:item true :xs 2} "EUR 20 000 000"]
   [RawGrid {:item true :xs 2} "Facility"]])

(def header-second-row
  [RawGrid {:container true :spacing 1 :style {:margin-top "1rem"}}
   [RawGrid {:item true}
    [RawTextField {:label "Customer"
                   :default-value "Customer name"
                   :InputProps {:disableUnderline true
                                :readOnly true}}]]
   [RawGrid {:item true}
    [RawTextField {:label "Product Group"
                   :default-value "Product group name"
                   :InputProps {:disableUnderline true
                                :readOnly true}}]]
   [RawGrid {:item true}
    [RawTextField {:label "Start Date"
                   :default-value "2020-03-21"
                   :InputProps {:disableUnderline true
                                :readOnly true}}]]
   [RawGrid {:item true}
    [RawTextField {:label "End Date"
                   :default-value "2025-03-21"
                   :InputProps {:disableUnderline true
                                :readOnly true}}]]])

(defcard-rg accordion-with-multiline-header
  "## Accordion with multiline header"
  (apply-stiles [EddAccordion {:id "accordion-multiline-header"
                               :header     [RawGrid {:container true}
                                            header-first-row
                                            header-second-row]
                               :header-expanded [RawGrid {:container true}
                                                 header-first-row]
                               :init-expanded? true}
                 [RawCard {}  [RawGrid {:container true :style {:margin-top "-1rem"}}
                               header-second-row
                               [RawGrid {:container true :spacing 1}
                                [RawGrid {:item true :xs 12} "Content..."]]]]]))
