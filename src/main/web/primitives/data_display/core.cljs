(ns web.primitives.data-display.core
  (:require
   ["@mui/material/index" :refer [Avatar Badge Divider Grid
                                  List ListItem ListItemText ListItemIcon ListSubheader
                                  Menu MenuItem MenuList
                                  Typography Tooltip
                                  Table TableBody TableCell TableContainer TableHead TableRow Chip]]))

(defn RawBadge [{:keys [color]
                 :or   {color "primary"}
                 :as   props}]
  [:> Badge (merge
             props
             {:color color}
             (when (= 0 (:badge-content props))
               {:badge-content "0"}))
   (:content props)])

(defn RawTooltip [props content]
  [:> Tooltip (merge {:arrow true} props)
   [:> Grid {:item true :style {:width "fit-content"}}
    content]])

(defn RawTypography [props content]
  [:> Typography props content])

(defn RawList [props & children]
  (into [:> List (merge {:component "nav"} props)]
        (for [child children]
          child)))

(defn RawListItem [props & children]
  (into [:> ListItem props]
        (for [child children]
          child)))

(defn RawListItemText [props content]
  [:> ListItemText props content])

(defn RawListItemIcon [props content]
  [:> ListItemIcon props content])

(defn RawListSubheader [props content]
  [:> ListSubheader props content])

(defn RawDivider [props]
  [:> Divider props])

(defn RawMenu [{:keys [open] :or {open false} :as props} & children]
  (into [:> Menu (merge props {:open (boolean open)})]
        (for [child children]
          child)))

(defn RawMenuList [props & children]
  (into [:> MenuList props]
        (for [child children]
          child)))

(defn RawMenuItem [props content]
  [:> MenuItem props content])

(defn RawTableContainer [props & children]
  (into
   [:> TableContainer props]
   (for [child children]
     child)))

(defn RawTable [props & children]
  (into
   [:> Table props]
   (for [child children]
     child)))

(defn RawTableBody [props & children]
  (into
   [:> TableBody props]
   (for [child children]
     child)))

(defn RawTableHead [props & children]
  (into
   [:> TableHead props]
   (for [child children]
     child)))

(defn RawTableRow [props & children]
  (into
   [:> TableRow props]
   (for [child children]
     child)))

(defn RawTableCell [props & children]
  (into
   [:> TableCell props]
   (for [child children]
     child)))

(defn RawAvatar
  ([props content]
   [:> Avatar props content])
  ([props]
   [:> Avatar props]))

(defn RawChip [props]
  [:> Chip props])