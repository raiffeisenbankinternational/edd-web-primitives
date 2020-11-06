(ns web.primitives.surfaces.core
  (:require
   [re-frame.core :as rf]
   [reagent.core :as r]
   ["@material-ui/core" :refer [Grid
                                IconButton
                                Accordion
                                AccordionSummary
                                AccordionDetails]]
   ["@material-ui/icons/ExpandMore" :default ExpandMoreIcon]
   ["@material-ui/icons/ExpandLess" :default ExpandLessIcon]

   [web.primitives.surfaces.model :as model]))

(defn- control-position-right? [props]
  (let [control-position (:control-position props)]
    (and (some? control-position) (= control-position :right))))

(defn RawAccordion [{:keys [expanded? control-position on-click]
                     :or {control-position :left}
                     :as props} content]
  [:> Accordion
   {:expanded expanded?
    :elevation (get-in props [:elevation] 0)
    :style    {:margin-bottom "0.2rem"}}
   [:> AccordionSummary
    [:> Grid {:container true :alignItems "center"}
     [:> Grid {:item true :style
               (merge
                {:position "absolute"}
                (if (= control-position :right) {:right 0}))}
      [:> IconButton
       (merge
        {:on-click on-click
         :style (if (= control-position :right)
                  {:margin-right "-1.1rem"}
                  {:margin-left "-1.1rem"})}
        (if (:id props) {:id (:id props)}))
       (if expanded? [:> ExpandLessIcon] [:> ExpandMoreIcon])]]
     [:> Grid {:container true :style (if (= control-position :right)
                                        {:padding-right "1.5rem"}
                                        {:padding-left "1.5rem"})}
      (if (and expanded? (contains? props :header-expanded))
        (:header-expanded props)
        (:header props))]]]
   (into [:> AccordionDetails
          {:style {:padding 0}}
          content])])

(defn EddAccordion [props content]
  (r/with-let [accordion-state-id (keyword (str "accordion-expanded-state-" (str (random-uuid))))]
    (let [expanded? @(rf/subscribe [::model/get-accordion-expanded-state accordion-state-id props])
          right? (control-position-right? props)
          on-click (fn [] (rf/dispatch [::model/set-accordion-expanded-state accordion-state-id props]))]
      [RawAccordion (merge {:expanded? expanded?
                            :right? right?
                            :on-click on-click} props) content])))
