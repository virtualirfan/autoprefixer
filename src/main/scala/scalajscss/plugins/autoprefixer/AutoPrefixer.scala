package scalajscss.plugins.autoprefixer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scalajscss.{CSSStyleSheet, ScalaJSCSSPlugin}
case class AutoPrefixer(prefixSelectorsAndRules: Boolean = false,
                        enableLocalStorageCache: Boolean = false)
    extends ScalaJSCSSPlugin {

  override def process(sheet: CSSStyleSheet): String = {
    PrefixFree.prefixCSS(sheet.css, prefixSelectorsAndRules)
  }

}
@js.native
@JSGlobal
object PrefixFree extends js.Object {
  def prefixCSS(css: String, raw: Boolean = ???): String = js.native
}
