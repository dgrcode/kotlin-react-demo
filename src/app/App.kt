package app

import counter.*
import react.*
import react.dom.div
import react.dom.p


class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div {
            p{+"counter 1"}
            counter()
        }

        div {
            p {+"counter 2"}
            counter()
        }
    }
}

fun RBuilder.app() = child(App::class) {}
