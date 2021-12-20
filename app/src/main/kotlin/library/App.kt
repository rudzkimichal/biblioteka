package library

class App {
    val init: String
        get() {
            return "App init OK"
        }
}

fun main() {
    println(App().init)
}
