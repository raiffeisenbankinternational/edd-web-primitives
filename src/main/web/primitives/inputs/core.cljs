(ns web.primitives.inputs.core
  (:require [re-frame.core :as rf]
            [reagent.core :as r]
            ["@material-ui/core" :refer [Badge FormControl FormLabel CircularProgress InputLabel Select Switch
                                         TextField Button Fab IconButton Checkbox FormControlLabel InputAdornment Zoom
                                         RadioGroup Radio]]
            ["@material-ui/pickers" :refer [DesktopDatePicker LocalizationProvider]]
            ["@date-io/luxon/build/index.esm.js" :default luxon]

            [web.primitives.layout.core :refer [RawGrid]]
            [web.primitives.inputs.utils :refer [handle-input-change adapted-text-field jsx->clj
                                                 handle-date-picker-date-change invalid-date?
                                                 clean-switch-props handle-switcher-change]]
            [web.primitives.inputs.model :as model]))

(defn RawTextField [{:keys [prefix suffix] :as props}]
  [adapted-text-field
   (merge {:full-width true :color "secondary"}
          (dissoc props :transform-func)
          (when
           (some? (or prefix suffix))
            {:InputProps
             (merge
              (when (some? prefix)
                {:startAdornment (r/as-element
                                  [:> InputAdornment {:position "start"} prefix])})

              (when (some? suffix)
                {:endAdornment   (r/as-element
                                  [:> InputAdornment {:position "end"} suffix])}))})

          {:on-change (fn [event] (handle-input-change event
                                                       (get props :on-change
                                                            (fn [] (println "BLL")))
                                                       (get props :transform-func (fn [val] val))))})])

(defn RawSwitch [{:keys [label label-placement disabled left-label left-value right-label right-value value]
                  :or {label-placement "end" disabled false} :as props}]
  (if (and (some? left-label) (some? right-label))
    (if (and (some? left-value) (some? right-value) (some? value))
      [:> FormControlLabel
       {:control
        (r/as-element
         [:> FormControlLabel
          {:control
           (r/as-element
            [:> Switch (merge
                        (clean-switch-props props)
                        {:color "secondary"
                         :class-name :selector
                         :checked (= right-value value)
                         :on-change #(handle-switcher-change
                                      {:left-value left-value
                                       :right-value right-value
                                       :value value
                                       :callback (get props :on-change
                                                      (fn [] (println "BLL")))})})])
           :label           left-label
           :style           {:margin-right -4}
           :disabled        disabled
           :label-placement "start"}])
        :label           right-label
        :disabled        disabled
        :label-placement label-placement}]
      (throw
       (js/Error. "If you want to use switcher with two labels you should provide :left-value :right-value and :value")))

    [:> FormControlLabel
     {:control (r/as-element [:> Switch (merge {:color "primary"} (clean-switch-props props))])
      :label label
      :style {:margin-right -4}
      :disabled disabled
      :label-placement label-placement}]))

(defn RawFormSelect
  [props]
  (let [id-pre (:id props)
        input-label (:input-label props)]
    [:> FormControl (merge
                     {:id          (str id-pre "-form-control")
                      :no-validate true}
                     (dissoc props :id :input-label :on-change :value :children))
     [:> InputLabel input-label]
     (into
      [:> Select (merge
                  {:id        (str id-pre "-select")
                   :inputProps {:hidden true}}
                  (dissoc props :id :input-label :full-width :required :disabled))])]))

;; ChoiceButton will be replaced with material Chip.
(defn RawChoiceButton
  [props]
  [:> Button
   (merge
    {:style {:font-size "14px"
             :width "112px"
             :height "32px"
             :border-radius "16px"
             :text-transform "none"
             :box-shadow "none"}
     :variant "contained"}
    props)
   (:label props)])

(defn RawDatePicker [{:keys [invalid? set-focused set-touched invalid-date-message]
                      :or {invalid-date-message "Invalid date"}
                      :as props}]
  [:> LocalizationProvider
   {:dateAdapter luxon}
   [:> DesktopDatePicker
    (merge props
           {:auto-ok true
            :show-today-button true
            :input-format      "dd.MM.yyyy"
            :views             ["year", "month", "date"]
            :mask              "__.__.____"
            :render-input
            (fn [p]
              (let [pp (jsx->clj p)]
                (r/as-element
                 [:> TextField
                  (merge (-> pp
                             (assoc
                              :helper-text (:helper-text props))
                             (assoc :id (:id props))
                             (assoc :required (get props :required false))
                             (assoc :full-width true)
                             (assoc :on-blur #(comp (set-touched) (set-focused false))))
                         (if invalid?
                           {:helper-text invalid-date-message
                            :error true}))])))
            :on-change #(handle-date-picker-date-change
                         (partial (get props :on-change (fn [x] (println "BLL"))))
                         set-focused
                         %)})]])

(defn EddDatePicker [props]
  (r/with-let [date-picker-state-id (keyword (str "date-picker-state-" (str (random-uuid))))]
    (let [focused? @(rf/subscribe [::model/date-picker-focused? date-picker-state-id])
          touched? @(rf/subscribe [::model/date-picker-touched? date-picker-state-id])
          set-focused (fn [focused?] (rf/dispatch [::model/set-date-picker-focused date-picker-state-id focused?]))
          set-touched (fn [] (rf/dispatch [::model/set-date-picker-touched date-picker-state-id]))]

      [RawDatePicker (merge
                      {:invalid? (invalid-date? touched? focused? props)
                       :set-focused set-focused
                       :set-touched set-touched}
                      props)])))

(defn RawButton [props inner-text]
  [:> Button props inner-text])

(defn RawFab
  ([props icon]
   [:> Zoom {:in true :timeout 300}
    [:> Fab (merge {:color "primary"} props) icon]])

  ([props icon inner-text]
   [:> Zoom {:in true :timeout 300}
    [:> Fab (merge
             {:color "primary"
              :variant "extended"}
             props) icon [RawGrid {:style {:margin-left 5}} inner-text]]]))

(defn RawIconButton [props icon]
  [:> IconButton props icon])

(defn RawCheckbox [{:keys [label label-placement disabled]
                    :or {label-placement "end" disabled false} :as props}]
  [:> FormControlLabel
   {:control (r/as-element [:> Checkbox props])
    :label label
    :disabled disabled
    :label-placement label-placement}])

(defn RawRadioGroup [{:keys [label children default-value defaultValue row on-change]
                      :or {row false on-change #(print (-> % .-target .-value))} :as props}]
  [:> FormControl {:on-change on-change}
   [:> FormLabel {} label]
   (into
    [:> RadioGroup {:row row :defaultValue (or default-value defaultValue)}]

    (for [item children]
      [:> FormControlLabel
       (merge
        {:control (r/as-element [:> Radio (merge {:color "secondary"})])}
        item)]))])
