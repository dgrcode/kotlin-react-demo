package app

import kotlin.js.*
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.*

interface AppState: RState {
    var count: Int
}

class App : RComponent<RProps, AppState>() {
    init {
        state.count = 0
    }

    fun increment (evt: Event) {
        setState { count = state.count + 1 }
        console.log("count: ${state.count}")
    }

    fun decrement (evt: Event) {
        setState { count = state.count - 1 }
        console.log("count: ${state.count}")
    }

    override fun RBuilder.render() {
        +"${state.count}"
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
