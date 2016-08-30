### Installing a ListView component
(tested for iOS only)

Here is how to install a ListView component, and use it. If you start
a new project, you will need to use npm to install it again (it
isn't installed everywhere on your development machine, just in
that folder).

Our solution to create a ListView will look something like this: (1) Take our
ClojureScript data and turn it into JS objects, (2) run it through the
`list-view` props (`:dataSource`, `:render-row`, `:render-section-header`), and
(3) in our `list-item` view turn our data back into ClojureScript.

Getting the component into our app is simple, as it's a core part of ReactNative.
`(def list-view (r/adapt-react-class (.-ListView ReactNative)))`
`(def data-source (r/adapt-react-class (.-DataSource (.-ListView ReactNative))))`

Our ListView will look something lke this.
```clojure
[list-view {:dataSource (.cloneWithRows ds rows)
            :render-row (fn[row] (r/create-element row-comp #js{:row row}))
            :render-section-header (fn [] (r/as-element [text {:style {:font-size 14 :text-align "center" :background-color "#4A4A4A"}} "Our Amazing ListView"]))}]])
```

Let's start with the data, and then look at our ListView.

### Our Data
Let's make some rows that we can use for our data.

We will pass an array of maps to our `DataSource`.

```clojure
(def rows (clj->js [{:picture logo-img
                     :text "OMG guys it's a ListView, how awesome!"}]))
```
Notice that we turn it into JS.

To make an arbitrary number of rows for demonstration purposes, we can tweak this:
```clojure
(def rows (clj->js
           (take 100 (repeat
                      {:picture logo-img
             :text "OMG guys it's a ListView, how awesome!"}))))
```

### DataSource
Our ListView requires a DataSource, in this line:  
`[list-view {:dataSource (.cloneWithRows ds rows)`

We call the `cloneWithRows` method on our DataSource `ds` and the rows we just made.  

This DataSource looks like this:  
`(def ds (js/React.ListView.DataSource. (clj->js {:rowHasChanged row-has-changed})))`

Notice it takes a `row-has-changed` function, which might look like this:  
```clojure
(defn row-has-changed [x y]
  (let [row-1 (js->clj x :keywordize-keys true) row-2 (js->clj y :keywordize-keys true)]
       (not= row-1 row-2)))
```

Notice we turn our map into JS `(clj->js {:rowHasChanged row-has-changed})`, so
it plays well with the DataSource, and then turn it back into ClojureScript so
we can write our function, as in `(let [row-1 (js->clj x :keywordize-keys true) row-2 (js->clj y :keywordize-keys true)]`.

### Rendering Rows

The next line says:  
`:render-row (fn[row] (r/create-element row-comp #js{:row row}))`  

`row-comp` is a helper function, wrapping each row in our `list-item-view`:
```clojure
(def row-comp (r/reactify-component
               (fn[props]
                 (let [row (props :row)]
                   [list-item-view row]))))
```

### List Item View
Our view can now be a normal, boring View component:

```clojure
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
```


### Usage
For demonstration purposes, we can just replace our `app-root` body.
```clojure
(defn app-root []
  [demo-list-view])
```
