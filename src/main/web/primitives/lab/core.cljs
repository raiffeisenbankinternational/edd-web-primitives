(ns web.primitives.lab.core
  (:require
   ["@material-ui/lab" :refer [Autocomplete
                               Alert AlertTitle
                               Skeleton
                               ToggleButtonGroup ToggleButton]]
   [reagent.core :as r]

   [web.primitives.lab.utils :refer [autocomplete-text-field]]))

(defn RawAutocomplete [props]
  [:> Autocomplete (merge
                    {:options           (if (:options props) (:options props) [])
                     :renderInput       (fn [params] (r/as-element [autocomplete-text-field params props]))
                     :getOptionSelected (fn [option, value] (= (:id option) (:id value)))}
                    (dissoc props :options))])

(defn RawAlert [{:keys [id severity title title-props] :as props} content]
  [:> Alert (merge {:severity severity}
                   (when (some? id)
                     {:id id}
                     props))
   (when (some? title)
     [:> AlertTitle (if (some? title-props) title-props {}) title])
   content])

(defn RawSkeleton [props]
  [:> Skeleton props])

(defn RawToggleButtonGroup [props & children]
  (into
   [:> ToggleButtonGroup props]
   (for [child children]
     (r/as-element child))))

(defn RawToggleButton [props content]
  [:> ToggleButton props content])
