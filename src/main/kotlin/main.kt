import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.input.KeyType

fun main(){
    //create instances of classes
    val screen   = DefaultTerminalFactory().createScreen()
    val diceList  = DiceList()
    val state = Controller(diceList.dice.size)
    val visualizer = Visualizer(screen, screen.newTextGraphics())

    // open screen
    screen.startScreen()


    // runs with expectation to eventualy fail
    try{
        // the fact that it is  a state lets me change in loop
        while(state.running){

            visualizer.drawBackdrop(diceList, state)

            val key = screen.readInput()
            when (key.keyType){
                KeyType.Character -> {
                    val check = key.character

                    when (check) {
                        'q' -> state.running = false
                    }
                }
                KeyType.ArrowDown -> state.Down()
                KeyType.ArrowUp -> state.Up()
                KeyType.Enter -> diceList.dice[state.currVal].rollit()

                else -> {
                    //kotlin is being mean so i added this to cover all basis
                }
            }
        }
    }finally {
        screen.stopScreen()

    }

}