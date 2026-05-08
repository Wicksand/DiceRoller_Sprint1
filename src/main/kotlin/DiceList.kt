class DiceList {

        val dice = listOf(
            Die(4,"d4"),
            Die(6,"d6"),
            Die(8,"d8"),
            Die(10,"d10"),
            Die(12,"d12"),
            Die(20,"d20"),
            Die(100,"d100")
        )

    val total: Int
        get() = dice.filter { it.roll > 0 }.sumOf { it.roll }

}