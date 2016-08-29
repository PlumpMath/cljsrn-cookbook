### Installing a Swiper component
(tested for iOS only)

Here is how to install a Swiper component, and use it. If you start
a new project, you will need to use npm to install it again (it
isn't installed everywhere on your development machine, just in
that folder).

To get the component into your React Native project, run:  
`npm i react-native-swiper --save`

To tell re-natal about it, run:    
`re-natal use-component react-native-swiper`  
Then run `re-natal use-figwheel`.

Then, shut down the terminal which runs your packager, and your Simulator. Re-start it with `react-native run-ios`.

Next, get the Swiper into this particular app by putting this up at the top with the other component defs:  
`(def Swiper (js/require "react-native-swiper"))`

(To be clear, we follow similar steps in JavaScript. You install it with `npm` like above, and then `require` it like we just did with `js/require`.)

Get it ready for use by adapting the Swiper into a ClojureScript Reagent class: 
`(def swiper (r/adapt-react-class Swiper))`

You are now able to use your swiper in a scene.
```
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

(def app-root []
  [swiper-view])
```

### Getting Other Components
For other components, follow the sequence above.  

If the component package which you `require` has more than one component in it, you will need to be specific about which component you are adapting for Reagent. The `swiper` package just has the swiper, so we wrote:  
`(def swiper (r/adapt-react-class Swiper))`.

But when we adapt the image component from ReactNative, we have to be specific because ReactNative has lots of components.
We would write `(def image (r/adapt-react-class (.-Image ReactNative)))`, and similar things for other components.
