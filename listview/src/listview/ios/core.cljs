(ns listview.ios.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [listview.handlers]
            [listview.subs]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))

(def logo-img (js/require "./images/cljs.png"))

;;;; These two lines added to include the component.
(def list-view (r/adapt-react-class (.-ListView ReactNative)))
(def data-source (r/adapt-react-class (.-DataSource (.-ListView ReactNative))))

(defn alert [title]
      (.alert (.-Alert ReactNative) title))


(defn list-item-view [row]
  ;;;; In our let statement, we convert our row back to ClojureScript.
  (let [row (js->clj row :keywordize-keys true)
  ;;;; We pull the picture and description out and use them below.
        picture (:picture row)
        description (:text row)]
        
    [view {:flex 1 :flex-direction "row"}
      [image {:source picture
              :style  {:width 80
                       :height 80
                       :margin-bottom 30}
              :resize-mode "cover"}]
     [text description]]))

;;;; This function allows the ListView to test if a row has updated itself.
;;;; Notice we convert back to ClojureScript in this implementation.
(defn row-has-changed [x y]
  (let [row-1 (js->clj x :keywordize-keys true) row-2 (js->clj y :keywordize-keys true)]
       (not= row-1 row-2)))


(set! js/React (js/require "react-native"))

;;;; Here we change our map with the row-has-changed function to a JS object.
(def ds (js/React.ListView.DataSource. (clj->js {:rowHasChanged row-has-changed})))

;;;; An array containing an arbitrary number of maps.
;;;; This will need to be adapted to work with an external data source or with our app-db.
(def rows (clj->js
           (take 100 (repeat
                      {:picture logo-img
             :text "OMG guys it's a ListView, how awesome!"}))))

;;;; This is a helper function to wrap each row in our list-item-view.
(def row-comp (r/reactify-component
               (fn[props]
                 (let [row (props :row)]
                   [list-item-view row]))))

(defn demo-list-view []
  [view  {:style {:flex-direction "column"
                  :flex 1
                  :margin-bottom 35 
                  }}

   [list-view {:dataSource (.cloneWithRows ds rows)
               :render-row (fn[row] (r/create-element row-comp #js{:row row}))
               :render-section-header (fn [] (r/as-element [text {:style {:font-size 14 :text-align "center" :background-color "#4A4A4A"}} "Our Amazing ListView"]))}]])

(defn app-root []
  [demo-list-view])

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent app-registry "listview" #(r/reactify-component app-root)))
