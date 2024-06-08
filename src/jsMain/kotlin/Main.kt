import csstype.*
import kotlinx.coroutines.async
import react.dom.*
import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinext.js.require
import kotlinx.browser.document
import react.*
import emotion.react.css
import emotion.react.useTheme
import kotlinx.html.attributesMapOf
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.img
import react.dom.client.createRoot
import kotlinx.serialization.Serializable
import react.dom.aria.*
import react.dom.html.ButtonType
import react.dom.html.HTMLAttributes
import react.dom.svg.ReactSVG.circle
import react.dom.svg.ReactSVG.path
import react.dom.svg.ReactSVG.rect
import react.dom.svg.ReactSVG.svg
import react.dom.svg.ReactSVG.symbol
import react.dom.svg.ReactSVG.text
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.em
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.span
import react.dom.html.ReactHTML.ul
import react.dom.svg.ReactSVG.use
import react.dom.svg.SVGAttributes
import kotlin.js.Console

external val console: Console


fun main() {
    /*
    val container = document.getElementById("root") ?: error("Couldn't find root container!")
    createRoot(container).render(App.create())
       GlobalScope.launch(Dispatchers.Main) {
         delay(1000)
           document.getElementById("svg1")?.apply {

               console.log("svg1:${getAttribute("width")}")
             //  setAttribute("width","1em")
             //  setAttribute("height","1em")
           }
      }

     */
    MainScope().launch {
        window.onload = {
           // Layout.init()
            val router = Router()
            router.start()
        }
    }

}


