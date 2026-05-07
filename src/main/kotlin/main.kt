import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TerminalSize


fun main(){
    val screen   = DefaultTerminalFactory().createScreen()

    screen.startScreen()


    screen.refresh()
    Thread.sleep(2000)
    screen.stopScreen()


}