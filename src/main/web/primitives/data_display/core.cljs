(ns web.primitives.data-display.core
  (:require ["@material-ui/core" :refer [Badge]]))

(defn RawBadge [props]
  [:> Badge (merge
             props
             {:color "primary"}
             (if (= 0 (:badge-content props))
               {:badge-content "0"}))
   (:content props)])

(defn RawIcon [props]
  [:img (merge {:src (str "../icons/" (:name props) ".svg")} (dissoc props [:name]))])
