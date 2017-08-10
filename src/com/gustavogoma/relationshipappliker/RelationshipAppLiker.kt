package com.gustavogoma.relationshipappliker

val DELAY = 1000L
val Y_POSITION_ON_SCREEN = 800

enum class Direction(val begin: Int, val end: Int) {
    right(100, 600), left(600, 100)
}

fun main(args: Array<String>) {
    while (true)
        swipeRight()
}

fun swipeRight() {
    print("swiping right...")
    swipe(Direction.right)
}

fun swipe(direction: Direction) {
    val cmd = String.format(
            "adb shell input swipe %d %d %d %d",
            direction.begin,
            Y_POSITION_ON_SCREEN,
            direction.end,
            Y_POSITION_ON_SCREEN)

    print("sending command...")
    Runtime.getRuntime().exec(cmd)

    print("done. waiting the delay...")
    Thread.sleep(DELAY)

    println("done.")
}

