<div id="table-of-contents">
<h2>Table of Contents</h2>
<div id="text-table-of-contents">
<ul>
<li><a href="#orgheadline1">1. How to Cook</a></li>
<li><a href="#orgheadline2">2. Purpose</a></li>
<li><a href="#orgheadline3">3. Never Before Have So Few Programmers Written So Little Code for So Many Platforms</a></li>
<li><a href="#orgheadline4">4. Contributions</a></li>
<li><a href="#orgheadline5">5. License</a></li>
</ul>
</div>
</div>

## How to Cook<a id="orgheadline1"></a>

This cookbook contains React Native components in ClojureScript, as well as
patterns of use.

That is, you'll find basic examples of React Native components, along with
explanations/tutorials where possible, and you may find more than one example of
the same component with different or more advanced usage.

To use any component, go ahead and check out the Facebook documents. They will
tell you what properties the component should take, which lets you know how to
use the component.

These recipes (so far) assume that you are using [re-natal](https://github.com/drapanjanas/re-natal).

## Components
- [ListView](https://github.com/coyotespike/cljsrn-cookbook/tree/master/listview)
- [react-native-swiper](https://github.com/coyotespike/cljsrn-cookbook/tree/master/swiper)

## General Resources

- [cljsrn](http://cljsrn.org/)
- [slack](https://clojurians.slack.com/messages/cljsrn/)
- [facebook](https://facebook.github.io/react-native/)
- [re-natal](https://github.com/drapanjanas/re-natal)
- [re-natal-tutorial](https://github.com/rockiger/re-natal-tutorial)


## Purpose<a id="orgheadline2"></a>

[Programming to Be Officially Renamed Googling Stackoverflow](http://www.theallium.com/engineering/computer-programming-to-be-officially-renamed-googling-stackoverflow/) 

And if we're not googling for solutions, we might be running an advanced search
on GitHub to find solid examples of usage!

A lot of developers new to React Native, to ClojureScript, or to both have to
figure out how to install the components in a project and then how to adapt them
to ClojureScript. 

There's no need for everyone to figure all this out every time. In addition,
uncertainty over whether a bug is due to syntactical translation, semantic
usage, or packaging can be a real bear to figure out.

Wouldn't it be a beautiful thing if someone could begin and end their
educational journey into React Native, entirely within ClojureScript?

Thus, the purpose is to help first-timers get started, and to collect (and
solicit!) component examples. The repository can lessen the thinking needed to
understand concepts and components, help avoid gotchas in getting components
into ClojureScript (small differences can be annoying), and serve as a re-usable
library.

Just as CLSJS eased the transition between JS and CLJS by taking care of
externs, component examples can ease the transition into React Native.

We gratefully acknowledge the example and influence of the [Reagent Cookbook](https://github.com/reagent-project/reagent-cookbook).

## Never Before Have So Few Programmers Written So Little Code for So Many Platforms<a id="orgheadline3"></a>

Native mobile development has always utilized its own ecosystem of languages,
builds, and tools. Facebook helped change that with React Native. Fortuitously,
the ClojureScript community had already leveraged JavaScript into a nicer and in
some cases (devcards, Figwheel) more powerful set of tools.

The paradigms and patterns implemented in Redux in JS and re-frame in CLJS, and
even specific frameworks and tools like Figwheel, can now come to mobile
development. Functional Reactive Programming concepts find a wider reach, and we
bone-lazy developers can even use the same frameworks and tools.

## Contributions<a id="orgheadline4"></a>

Recipes are welcomed! Please fork, branch, and submit a pull request.

Any component you've used in ClojureScript, or an example you've found and
adapted, is more than welcome. If you feel able, a mini-tutorial for
installation, for semantics, or both, would be great. If you're able to respond
to tickets for that component, please let me know.

Components and patterns without an example yet:

- Audio-player
- Navigation (coming soon)
- Scrolling

This project aspires to follow [this advice](https://medium.com/code-zen/how-to-maintain-a-successful-open-source-project-aaa2a5437d3a#.z28fzb861).

## License<a id="orgheadline5"></a>

[WTFPL](http://www.wtfpl.net)
