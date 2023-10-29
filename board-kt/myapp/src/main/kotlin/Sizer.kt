import java.awt.Color
import java.awt.Graphics
import java.awt.Rectangle
import java.awt.Toolkit
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.util.logging.Logger
import javax.swing.JFrame
import javax.swing.JPanel


interface Sizer {
    fun size(): Rectangle

    class SizerUsecase(
        private val frame: JFrame = JFrame("Target Selector"),
    ) : Sizer {
        private val logger = Logger.getLogger("SIZRE BOARD")

        private var startX: Int = 0
        private var startY: Int = 0
        private var endX: Int = 800
        private var endY: Int = 600

        override fun size(): Rectangle {
            frame.isUndecorated = true
//            frame.opacity = 0.0f
//            frame.size = Toolkit.getDefaultToolkit().screenSize;
//            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            frame.setSize(800, 600)
            logger.info("[SIZER BOARD] START :: $startX, $startY")

            val panel: JPanel = setUpPanel()
//            panel.setBackground(Color(0, 0, 0, 0))
            panel.addMouseListener(mouseCapture())
            logger.info("[SIZER BOARD] END :: $endX, $endY")

            frame.add(panel)
            frame.isVisible = true

            logger.info("[SIZER BOARD] RETURN :: $startX, $startY, $endX, $endY")
            return Rectangle(startX, startY, endX, endY)
        }

        private fun setUpPanel() = object : JPanel() {
            override fun paintComponent(g: Graphics) {
                super.paintComponent(g)
                g.color = Color(0, 0, 255, 50)
                g.fillRect(startX, startY, endX, endY)
                g.color = Color.BLUE
                g.drawRect(startX, startY, endX, endY)
            }
        }

        private fun mouseCapture() = object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent) {
                startX = e.point.x
                startY = e.point.y
            }

            override fun mouseReleased(e: MouseEvent) {
                endX = e.x - startX
                endY = e.y - startY
                frame.isVisible = true
                frame.dispose()
            }
        }
    }


}