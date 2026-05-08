class Controller (val diceCount: Int) {

    var currVal: Int = 0
    var running: Boolean = true

    // up and down scrolls through dice
    fun Left () {
        currVal = (currVal - 1).coerceAtLeast(0)
    }

    fun Right () {
        currVal = (currVal + 1).coerceAtMost(diceCount - 1)
    }

    // saves what label is selected
    val currLabel: String
        get() = "d${currVal}"

}