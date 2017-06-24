package scalajscss.plugins.autoprefixer

import org.scalajs.dom

import scala.scalajs.js.JSON
import scala.scalajs.{LinkingInfo, js}
import scala.scalajs.js.annotation.{JSGlobal, JSImport, ScalaJSDefined}
import scalajscss.{CSSStyleSheet, ScalaJSCSSPlugin}
import scalajs.concurrent.JSExecutionContext.Implicits.queue
case class AutoPrefixer(prefixSelectorsAndRules: Boolean = false,
                        enableLocalStorageCache: Boolean = false)
    extends ScalaJSCSSPlugin {

  override def process(sheet: CSSStyleSheet): String = {
//    if (!enableLocalStorageCache) {
    PrefixFree.prefixCSS(sheet.css, prefixSelectorsAndRules)
  }
//  else {
//      val item = AutoPrefixer.cachedItem(sheet.name)
//      if (item == null || item.hash != sheet.rawCSS.hashCode) {
//        val result =
//          PrefixFree.prefixCSS(sheet.rawCSS, prefixSelectorsAndRules)
//        AutoPrefixer.setItem(sheet, result)
//        result
//      } else item.css.toString
//    }
//  }

}

@ScalaJSDefined
trait LocalItem extends js.Object {
  val hash: Int
  val css: String
}

object AutoPrefixer {

  @inline
  def cachedItem(key: String) = {
    JSON.parse(dom.window.localStorage.getItem(key)).asInstanceOf[LocalItem]
  }

  @inline
  def setItem(sheet: CSSStyleSheet, data: String) = {
    dom.window.localStorage.setItem(sheet.name, JSON.stringify(new LocalItem {
      override val css: String = data
      override val hash: Int = sheet.css.hashCode
    }))
  }
}

@js.native
@JSGlobal
object PrefixFree extends js.Object {
  def prefixCSS(css: String, raw: Boolean = ???): String = js.native
}
//
//@js.native
//@JSImport("postcss", JSImport.Default)
//object PostCSS extends js.Object {
//
//  def apply(input: js.Array[js.Any]): PostCSSInstance = js.native
//
//}
//
//@js.native
//trait PostCSSInstance extends js.Object {
//  def process(input: String): PostCSSResult = js.native
//  val css: String = js.native
//}
//
//@js.native
//trait PostCSSResult extends js.Object {
//  def warnings(): js.Array[js.Dynamic] = js.native
//  val css: String = js.native
//}
//
//@js.native
//@JSImport("autoprefixer", JSImport.Default)
//object PostCSSAutoPrefixer extends js.Object
