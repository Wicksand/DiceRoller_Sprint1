import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TerminalSize


class Visualizer (
    private val screen: Screen,
    private val g: TextGraphics
) {
    // draw the whole screen of stuff
    fun drawBackdrop(diceList: DiceList, state: Controller){
        screen.clear()
        drawTitle()
        diceList.dice.forEachIndexed{i,die ->
            drawDie(die, i, i == state.currVal)
        }
        drawTotal(diceList.total)
        drawControls()
        screen.refresh()
    }
    // creates the title
    private fun drawTitle(){
        g.putString(2,1,"D&D Dice Roller")
    }

    // creates the dice visuals
    private fun drawDie (die: Die, index: Int, selected: Boolean){
        val column = 2 + index * 10
        val row = 3

        //shows what die is selected by adding a hilight around current selection
        if (selected){
            g.setForegroundColor(TextColor.RGB(0,255,150))
        }else{
            g.setForegroundColor(TextColor.ANSI.WHITE)
        }

        g.putString(column,row,die.label)
        g.putString(column,row + 1,die.currLabel)
        g.setForegroundColor(TextColor.ANSI.DEFAULT)

    }

    private fun drawControls(){
        g.putString(2,9," (↑↓) select a die     (Enter) roll     (q) will quit.")
    }

    private fun drawTotal(total: Int){
        g.putString(2,7, "Total: $total")
        }

}