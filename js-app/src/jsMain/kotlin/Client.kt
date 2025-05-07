import kotlinx.browser.document
import react.dom.client.createRoot

fun main() {
    val container = document.createElement("div")
    document.body!!.appendChild(container)
    createRoot(container)
}
