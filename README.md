# AutoPrefixer

css vendor prefix plugin for scalajs-css.

# Usage 

1) Add `"scalajs-css" %%% "autoprefixer" % "replaceThisWithLatestVersionNumberFromReleaseTags"` to your build.sbt

2) Copy `prefixfree.js` to your project 

3) Include it in index.html or require it in entry file(index.js)

4) `CSSStyleSheetRegistry.setPlugins(AutoPrefixer())`

# Options 

`prefixSelectorsAndRules` (Boolean; Default = false) - If true, it also prefixes selectors and @-rules 

 

