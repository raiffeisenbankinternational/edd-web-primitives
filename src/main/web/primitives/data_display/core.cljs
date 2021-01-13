(ns web.primitives.data-display.core
  (:require ["@material-ui/core" :refer [Badge Tooltip Grid Typography
                                         List ListItem ListItemText ListItemIcon ListSubheader Divider]]))

(defn RawBadge [props]
  [:> Badge (merge
             props
             {:color "primary"}
             (if (= 0 (:badge-content props))
               {:badge-content "0"}))
   (:content props)])

(defn RawTooltip [props content]
  [:> Tooltip  (merge {:arrow true} props)
   [:> Grid {:item true :style {:width "fit-content"}}
    content]])

(defn RawTypography [props content]
  [:> Typography props content])

(defn RawList [props & children]
  (into [:> List (merge {:component "nav"} props)]
        (for [child children]
          child)))

(defn RawListItem [props content]
  [:> ListItem props content])

(defn RawListItemText [props content]
  [:> ListItemText props content])

(defn RawListItemIcon [props content]
  [:> ListItemIcon props content])

(defn RawListSubheader [props content]
  [:> ListSubheader props content])

(defn RawDivider [props]
  [:> Divider props])