(ns web.primitives.lab.core
  (:require
   ["@mui/material/index" :refer [Autocomplete
                                  Alert AlertTitle
                                  Skeleton
                                  ToggleButtonGroup ToggleButton]]

   ["@mui/lab/TimelineDot" :default TimelineDot]
   ["@mui/lab/TreeView" :default TreeView]
   ["@mui/lab/TreeItem" :default TreeItem]

   [reagent.core :as r]

   [web.primitives.lab.utils :refer [autocomplete-text-field]]))

(defn RawAutocomplete [{:keys [options getOptionSelected] :as props}]
  [:> Autocomplete (merge
                    {:options              (if options options [])
                     :renderInput          (fn [input-params] (r/as-element [autocomplete-text-field input-params props]))
                     :isOptionEqualToValue (fn [_option _value]
                                             (let [item (js->clj _option :keywordize-keys true)
                                                   value (js->clj _value :keywordize-keys true)]
                                               (= item value)))}
                    (-> props
                        (dissoc :error)
                        (dissoc :options)
                        (dissoc :FormHelperTextProps)
                        (dissoc :getOptionSelected)
                        (dissoc :helper-text))
                    (when (some? getOptionSelected)
                      {:isOptionEqualToValue getOptionSelected}))])

(defn RawAlert [{:keys [id severity title title-props] :as props} content]
  [:> Alert (merge {:severity severity
                    :color    severity}
                   (when (some? id)
                     {:id id}
                     (dissoc props :title-props)))
   (when (some? title)
     [:> AlertTitle (if (some? title-props) title-props {}) title])
   (r/as-element content)])

(defn RawSkeleton [props]
  [:> Skeleton props])

(defn RawToggleButtonGroup [props & children]
  (into
   [:> ToggleButtonGroup props]
   (for [child children]
     (r/as-element child))))

(defn RawToggleButton [props content]
  [:> ToggleButton props content])

(defn RawTimelineDot [{:keys [variant] :as props} & children]
  (into
   [:> TimelineDot (merge
                    props
                    (when (= "default" variant)
                      {:variant "filled"}))]
   (for [child children]
     (r/as-element child))))

(defn RawTreeView [props & children]
  (into
   [:> TreeView props]
   (for [child children]
     child)))

(defn RawTreeItem [props & children]
  (into
   [:> TreeItem props]
   (for [child children]
     child)))