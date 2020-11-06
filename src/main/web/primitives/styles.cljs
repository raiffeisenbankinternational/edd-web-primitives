(ns web.primitives.styles)

(def theme
  {:palette    {:primary   {"main" "rgba(254, 230, 0)"}
                :secondary {"main" "rgba(0, 0, 0, 0.86)"}}
   :typography {:font-family "Verdana,Roboto,Arial,Quicksand"}
   :z-index    {:app-bar 1200
                :drawer  1100}
   :overrides  {:MuiCard
                {:root {:border-radius "0.5rem"}}
                :MuiFormControlLabel
                {:root
                 {:margin-left "-3px"}}
                :MuiGridListTile
                {:tile
                 {:overflow "inherit"}}
                :MuiTypography
                {:h1 {:font-size "22px"
                      :line-height "40px"
                      :font-weight "black"
                      :letter-spacing "0.2px"}
                 :h2 {:font-size "34px"
                      :line-height "40px"
                      :font-weight "normal"
                      :letter-spacing "0.2px"}
                 :h3 {:font-size "22px"
                      :line-height "25px"
                      :font-weight "normal"
                      :letter-spacing "0.13px"}
                 :h4 {:font-size "20px"
                      :line-height "24px"
                      :font-weight "normal"
                      :letter-spacing "0.1px"}
                 :h5 {:font-size "20px"
                      :line-height "24px"
                      :font-weight "bold"
                      :letter-spacing "0.15px"}
                 :h6 {:font-size "18px"
                      :line-height "21px"
                      :font-weight "normal"
                      :letter-spacing "0.1px"}
                 :subtitle1 {:font-size "16px"
                             :line-height "20px"
                             :font-weight "normal"
                             :letter-spacing "0.18px"}
                 :subtitle2 {:font-size "16px"
                             :line-height "19px"
                             :font-weight "bold"
                             :letter-spacing "0.3px"
                             :color "#6d7278"}
                 :body1 {:font-size "14px"
                         :line-height "20px"
                         :font-weight "normal"
                         :letter-spacing "0.16px"}
                 :body2 {:font-size "14px"
                         :line-height "20px"
                         :font-weight "normal"
                         :letter-spacing "0.15px"}
                 :caption {:font-size "12px"
                           :line-height "14px"
                           :font-weight "normal"
                           :letter-spacing "0px"}
                 :overline {:font-size "12px"
                            :line-height "14px"
                            :font-weight "normal"
                            :letter-spacing "0.16px"}
                 :button {:font-size "14px"
                          :line-height "16px"
                          :font-weight "medium"
                          :letter-spacing "0.3px"}}
                :MuiIconButton
                {:root
                 {"&.Mui-disabled" {:opacity 0.5}}}
                :MuiButton
                {:contained
                 {:color               "#2b2d33"
                  :background-color    "#e9eaea"
                  :color-interpolation "none"}
                 :root
                 {:border-radius 8
                  :text-transform "none"
                  :min-width "8rem"}
                 :outlined
                 {:border "solid 1px #e9eaea"}}
                :MuiToolbar
                {:regular
                 {:min-height "100px"
                  :height     "100px"}
                 :gutters {:padding "0 2rem 0 2rem"
                           "@media (min-width: 600px)"
                           {:padding "0 2rem 0 2rem"}}}
                :MuiAppBar
                {:positionFixed
                 {:margin-left "2rem"}}
                :MuiSwitch
                {:root
                 {"& .MuiSwitch-colorSecondary" {:color "#037080"}
                  "& .MuiSwitch-colorSecondary + .MuiSwitch-track"
                  {:background-color  "#b3d4d8"
                   :opacity 1}
                  "& .MuiSwitch-colorSecondary.Mui-checked " {:color "#037080"}
                  "& .MuiSwitch-colorSecondary.Mui-checked + .MuiSwitch-track"
                  {:background-color "#b3d4d8"
                   :opacity 1}}}
                :MuiAccordion
                {:root
                 {"&:before" {:opacity 0}
                  "& .Mui-expanded" {:margin 0}}}
                :MuiAccordionSummary
                {:root
                 {:padding 0
                  "&.Mui-expanded" {:margin 0}}
                 :content {"&.Mui-expanded" {:margin "12px 0"}}}
                :MuiAutocomplete
                {:loading {:display "none"}}
                :MuiGrid
                {:root {"& .sun-editor" {:border-bottom "none"
                                         "& .se-toolbar" {:background-color "#ffffff"}
                                         "& .se-container .se-line-breaker" {:display "none!important"}
                                         "& .se-container .se-line-breaker-component" {:display "none!important"}
                                         "& .se-wrapper .se-wrapper-inner" {:height "auto!important"}}}}
                :MuiDivider
                {:root
                 {:height 1.1}}
                :PrivateTabIndicator
                {:root {:height 4}}
                :MuiTabs
                {:root {:width "100%"}}
                :MuiAlert
                {:message {:width "100%"}
                 :root {:width "100%"}}}})


