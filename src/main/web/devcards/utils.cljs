(ns web.devcards.utils
  (:require
   [web.primitives.styles :as styles]
   ["@material-ui/core/styles" :refer [withStyles createMuiTheme MuiThemeProvider]]))

(defn- raw-theme
  "Convert styles into javascript map"
  []
  (clj->js
   (styles/theme)))

(defn- with-custom-styles
  [component]
  ((withStyles raw-theme) component))

(defn apply-stiles [component]
  [:> MuiThemeProvider {:theme (createMuiTheme (clj->js styles/theme))}
   (with-custom-styles
     component)])
