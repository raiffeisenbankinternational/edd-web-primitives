(ns web.primitives.feedback.core
  (:require ["@material-ui/core" :refer [Dialog DialogTitle DialogContent
                                         DialogContentText DialogActions
                                         Snackbar]]))

(defn RawDialog [{:keys [open title dialog-props]} content]
  [:> Dialog
   (merge {:open open
           :disableEnforceFocus true}
          dialog-props)
   [:> DialogTitle title]
   [:> DialogContent content]])

(defn RawSnackbar [{:keys [anchor-origin open on-close auto-hide-duration message key]}
                   content]
  [:> Snackbar {:anchor-origin      (merge {:vertical   "bottom"
                                            :horizontal "center"}
                                           anchor-origin)
                :open               open
                :on-close           on-close
                :auto-hide-duration (or auto-hide-duration 5000)
                :message            (or message "")
                :key                key}
   content])
