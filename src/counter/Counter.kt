package counter

import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.button

interface CounterState: RState {
    var count: Int
}

class Counter : RComponent<RProps, CounterState>() {
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
        addAndRemoveButtons(increment = ::increment, decrement = ::decrement)

    }
}

fun RBuilder.addAndRemoveButtons (increment: (Event) -> Unit, decrement: (Event) -> Unit) {
    button {
        attrs.onClickFunction = increment
        +"Add"
    }
    button {
        attrs.onClickFunction = decrement
        +"Remove"
    }
}

fun RBuilder.counter() = child(Counter::class) {}
