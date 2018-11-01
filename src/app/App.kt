package app

import kotlin.js.*
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.*

class App : RComponent<RProps, RState>() {
    var count = 0

    fun increment (evt: Event) {
        count++
        console.log("count: $count")
    }

    fun decrement (evt: Event) {
        count--
        console.log("count: $count")
    }

    override fun RBuilder.render() {
        +"${count}"
        button () {
            attrs.onClickFunction = ::increment
            +"Add"
        }
        button () {
            attrs.onClickFunction = ::decrement
            +"Remove"
        }
    }
}

fun RBuilder.app() = child(App::class) {}
