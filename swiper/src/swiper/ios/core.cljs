(ns swiper.ios.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [swiper.handlers]
            [swiper.subs]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))

(def logo-img (js/require "./images/cljs.png"))

;;;; Added these lines
(def Swiper (js/require "react-native-swiper"))
(def swiper (r/adapt-react-class Swiper))

(defn alert [title]
      (.alert (.-Alert ReactNative) title))

(defn swiper-view []
  [swiper {:style {} :shows-buttons true}
   [view {:style {:flex 1 :justify-content "center" :align-items "center" :background-color "skyblue"}}
    [text {:style {:font-size 30 :font-weight "200" :color "black"}} "hello"]]
   [view {:style {:flex 1 :justify-content "center" :align-items "center" :background-color "steelblue"}}
    [text {:style {:font-size 30 :font-weight "200"}} "How are you?"]]
   [view {:style {:flex 1 :justify-content "center" :align-items "center" :background-color "aquamarine"}}
    [image {:source logo-img
            :style  {:width 80 :height 80 :margin-bottom 30}}]    
    [text {:style {:font-size 30 :font-weight "200"}} "Simple and beautiful"]]])


(defn app-root []
  ;; Replacing the default app-root body for demonstration purposes
  [swiper-view])

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent app-registry "swiper" #(r/reactify-component app-root)))
