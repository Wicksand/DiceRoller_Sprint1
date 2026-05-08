class Die (
// values and variables
    val sides: Int,
    val label: String,
    var roll: Int = 0
){
    // generates random number and returns value between 1 and the number of sides on the dice
    fun rollit(): Int {
        roll = (1..sides).random()
        return roll
    }

    val currLabel: String
        get() = if (roll > 0){
            roll.toString()
        }else{
            "-"
        }
}