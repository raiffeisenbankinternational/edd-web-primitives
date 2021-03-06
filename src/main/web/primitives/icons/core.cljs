(ns web.primitives.icons.core
  (:require
   ["@material-ui/icons" :refer [Add Save Delete Clear Search Refresh Share Menu Tune Close Remove UnfoldMore UnfoldLess
                                 ExpandMore ExpandLess MoreHoriz MoreVert Forward SubdirectoryArrowRight CallMade
                                 Dialpad Event ChatBubbleOutline AccountBalance AccountBalanceWallet Exposure
                                 AccountCircle HomeOutlined NoteOutlined FormatAlignLeftOutlined StarBorder Person
                                 Info CheckCircleOutlineOutlined EmojiPeople DirectionsRun]]
   [web.primitives.icons.utils :refer [handle-props]]))

(defn AddIcon [props]
  [:> Add props])

(defn SaveIcon [props]
  [:> Save props])

(defn DeleteIcon [props]
  [:> Delete props])

(defn ClearIcon [props]
  [:> Clear props])

(defn SearchIcon [props]
  [:> Search props])

(defn RefreshIcon [props]
  [:> Refresh props])

(defn ShareIcon [props]
  [:> Share props])

(defn MenuIcon [props]
  [:> Menu props])

(defn TuneIcon [props]
  [:> Tune props])

(defn CloseIcon [props]
  [:> Close props])

(defn RemoveIcon [props]
  [:> Remove props])

(defn UnfoldMoreIcon [props]
  [:> UnfoldMore props])

(defn UnfoldLessIcon [props]
  [:> UnfoldLess props])

(defn ExpandMoreIcon [props]
  [:> ExpandMore props])

(defn ExpandLessIcon [props]
  [:> ExpandLess props])

(defn MoreHorizIcon [props]
  [:> MoreHoriz props])

(defn MoreVertIcon [props]
  [:> MoreVert props])

(defn ForwardIcon [props]
  [:> Forward props])

(defn SubdirectoryArrowRightIcon [props]
  [:> SubdirectoryArrowRight props])

(defn CallMadeIcon [props]
  [:> CallMade props])

(defn DialpadIcon [props]
  [:> Dialpad props])

(defn EventIcon [props]
  [:> Event props])

(defn ChatBubbleOutlineIcon [props]
  [:> ChatBubbleOutline props])

(defn AccountBalanceIcon [props]
  [:> AccountBalance props])

(defn AccountBalanceWalletIcon [props]
  [:> AccountBalanceWallet props])

(defn ExposureIcon [props]
  [:> Exposure props])

(defn AccountCircleIcon [props]
  [:> AccountCircle props])

(defn HomeOutlinedIcon [props]
  [:> HomeOutlined props])

(defn NoteOutlinedIcon [props]
  [:> NoteOutlined props])

(defn FormatAlignLeftOutlinedIcon [props]
  [:> FormatAlignLeftOutlined props])

(defn StarBorderIcon [props]
  [:> StarBorder props])

(defn CheckCircleOutlineOutlinedIcon [props]
  [:> CheckCircleOutlineOutlined props])

(defn EmojiPeopleIcon [props]
  [:> EmojiPeople props])

(defn DirectionsRunIcon [props]
  [:> DirectionsRun props])

(defn PersonIcon [props]
  [:> Person props])

(defn InfoIcon [props]
  [:> Info props])

(defn SettingsIcon [props]
  [:svg (handle-props props)
   [:rect {:id "bounding-box-24" :fill "#FFFFFF" :opacity "0" :x "0" :y "0" :width "24" :height "24"}]
   [:path {:d "M17,13 C19.209139,13 21,14.790861 21,17 C21,19.209139 19.209139,21 17,21 C15.1364348,21 13.570521,19.7256022 13.1262135,18.0007613 L3,18 L3,16 L13.1259548,16.0002435 C13.5699129,14.2748927 15.1360729,13 17,13 Z M17,15 C15.8954305,15 15,15.8954305 15,17 C15,18.1045695 15.8954305,19 17,19 C18.1045695,19 19,18.1045695 19,17 C19,15.8954305 18.1045695,15 17,15 Z M7,3 C8.86392711,3 10.4300871,4.27489272 10.8740452,6.00024347 L21,6 L21,8 L10.8737865,8.00076134 C10.429479,9.72560224 8.86356525,11 7,11 C4.790861,11 3,9.209139 3,7 C3,4.790861 4.790861,3 7,3 Z M7,5 C5.8954305,5 5,5.8954305 5,7 C5,8.1045695 5.8954305,9 7,9 C8.1045695,9 9,8.1045695 9,7 C9,5.8954305 8.1045695,5 7,5 Z"
           :id "settings"
           :fill "#2B2D33"
           :fill-rule "nonzero"}]])

(defn EditIcon [props]
  [:svg (handle-props props)
   [:rect {:id "bounding-box-24" :fill "#FFFFFF" :opacity "0" :x "0" :y "0" :width "24" :height "24"}]
   [:path {:d "M16.7071068,3.29289322 L20.7071068,7.29289322 C21.0976311,7.68341751 21.0976311,8.31658249 20.7071068,8.70710678 L9.70710678,19.7071068 C9.56750624,19.8467073 9.38970726,19.9418625 9.19611614,19.9805807 L4.19611614,20.9805807 C3.496395,21.1205249 2.8794751,20.503605 3.01941932,19.8038839 L4.01941932,14.8038839 C4.05813755,14.6102927 4.15329267,14.4324938 4.29289322,14.2928932 L15.2928932,3.29289322 C15.6834175,2.90236893 16.3165825,2.90236893 16.7071068,3.29289322 Z M13.499444,7.914 L5.92120149,15.4930121 L5.27475488,18.7252451 L8.50698793,18.0787985 L16.085444,10.5 L13.499444,7.914 Z M16,5.41421356 L14.914444,6.5 L17.499444,9.085 L18.5857864,8 L16,5.41421356 Z"
           :id "edit"
           :fill "#2B2D33"
           :fill-rule "nonzero"}]])

(defn ArrowRightIcon [props]
  [:svg (handle-props props)
   [:rect {:id "bounding-box-24" :fill "#FFFFFF" :opacity "0" :x "0" :y "0" :width "24" :height "24"}]
   [:path {:d "M12,9.41421356 L4.70710678,16.7071068 L3.29289322,15.2928932 L11.2928932,7.29289322 C11.6834175,6.90236893 12.3165825,6.90236893 12.7071068,7.29289322 L20.7071068,15.2928932 L19.2928932,16.7071068 L12,9.41421356 Z"
           :id "arrow-right"
           :fill "#2B2D33"
           :fill-rule "nonzero"
           :transform "translate(12.000000, 11.853553) rotate(-270.000000) translate(-12.000000, -11.853553) "}]])

(defn AllColapseIcon [props]
  [:svg (handle-props props)
   [:path {:d "M11.59 18.83L14.76 22 16.17 20.59 11.59 16 7 20.59 8.42 22zM11.59 5.17L8.42 2 7.01 3.41 11.59 8 16.18 3.41 14.76 2z"
           :fill-rule "nonzero"}]
   [:path {:d "M4 11H20V13H4z"
           :stroke "#979797"
           :stroke-width ".68"}]])

(defn AllExpandIcon [props]
  [:svg (handle-props props)
   [:path {:d "M11.59 4.83L14.76 8 16.17 6.59 11.59 2 7 6.59 8.42 8zM11.59 19.17L8.42 16 7.01 17.41 11.59 22 16.18 17.41 14.76 16z"
           :fill-rule "nonzero"}]
   [:path {:d "M4 11H20V13H4z"
           :stroke "#979797"
           :stroke-width ".68"}]])

(defn LogoIcon [props]
  [:svg (merge {:style {:width "36px"
                        :height "34px"
                        :viewbox "0 0 36 34"
                        :version "1.1"
                        :xlmns "http://www.w3.org/2000/svg"}} props)
   [:path {:d "M6.78433054,0.600418777 C5.63610913,0.615852373 4.3496967,1.05886756 3.06370843,2.30362121 C0.236864005,5.03973958 0,8.53618948 0,9.54926002 L1.5460119,7.97534313 L7.49221121,13.8831517 L9.14582085,12.2417815 L9.14582085,8.36320095 L10.8447347,10.0439189 L10.8390824,14.731943 L13.2118987,17.0815755 L1.14960884,29.0489638 L5.91223136,33.7650933 L17.9688587,21.8426739 L30.1444093,33.9 L34.9070323,29.1726282 L22.7201545,17.0815755 L25.098635,14.7488063 L25.098635,10.0439189 L26.7918859,8.36320095 L26.7918859,12.2586448 L28.4511585,13.8831517 L34.3916946,7.97534313 L36,9.54926002 C36,8.531595 35.6951798,5.03973958 32.8683357,2.30362121 C29.7009738,-0.760389773 26.5339931,1.0306571 25.4384178,2.11812456 L19.7074137,7.81232974 L21.1231763,9.22885553 L17.9688587,12.3598248 L14.8032151,9.22885553 L16.2359667,7.81232974 L10.4936366,2.11812456 C9.84698403,1.47244057 8.46251123,0.57784829 6.78434123,0.600418777 L6.78433054,0.600418777 Z"
           :id "Logo"
           :fill "#2B2D33"
           :fill-rule "nonzero"}]])

(defn Level1Icon [props]
  [:svg (merge {:style {:width "8px"
                        :height "8px"
                        :viewbox "0 0 8 8"
                        :version "1.1"
                        :xlmns "http://www.w3.org/2000/svg"}} props)
   [:circle {:stroke "none" :stroke-width "1" :fill-rule "evenodd" :id "Badge" :fill "#808185" :cx "4" :cy "4" :r "4"}]])

(defn Level2Icon [props]
  [:svg (merge {:style {:width "8px"
                        :height "8px"
                        :viewbox "0 0 8 8"
                        :version "1.1"
                        :xlmns "http://www.w3.org/2000/svg"}} props)
   [:circle {:stroke "none" :stroke-width "1" :fill-rule "evenodd" :id "Badge" :fill "#AAABAD" :cx "4" :cy "4" :r "4"}]])
