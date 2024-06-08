
import kotlinx.browser.document
import kotlinx.browser.sessionStorage
import kotlinx.browser.window
import kotlinx.coroutines.*
import org.w3c.dom.get
import org.w3c.dom.set
import react.create
import react.dom.client.createRoot


@JsModule("navigo")
@JsNonModule
external class Navigo(root: String, resolveOptions: ResolveOptions = definedExternally) {
    fun on(route: String, handler: () -> Unit)
    fun resolve()
    fun navigate(s: String)
}

external interface ResolveOptions {
    var strategy: String? // ONE or ALL
    var hash: Boolean?
    var noMatchWarning: Boolean?
}


class Router(root: String = "/") {

    private val resolveOptions = object : ResolveOptions {
        override var strategy: String? = "ONE"
        override var hash: Boolean? = true
        override var noMatchWarning: Boolean? = true
    }
    private val navigo: Navigo = Navigo(root, resolveOptions)
    init {
        configureRoutes()
        navigo.resolve()
    }
    private fun configureRoutes() {

        navigo.on("/") {
            val container = document.getElementById("root") ?: error("Couldn't find root container!")

            createRoot(container).render(App.create())
        }




    }
    fun start() {
        // Start listening for changes
        navigo.resolve()
    }
}
