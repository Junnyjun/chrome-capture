import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.util.logging.Logger
import javax.swing.JFrame
import javax.swing.JPanel


interface Sizer {
    fun size(): Rectangle

    class SizerUsecase(
    ) : Sizer {
        private val logger = Logger.getLogger("SIZRE BOARD")

        override fun size(): Rectangle {

            // A ,B C , D 구하기
            logger.info("[왼쪽위 모서리 지정중 ...]")
            Thread.sleep(500)
            val locationA = MouseInfo.getPointerInfo().location
            logger.info("[왼쪽위 모서리 지정완료 $locationA]")
            Thread.sleep(500)

            logger.info("[오른쪽아래 모서리 지정중 ...]")
            Thread.sleep(2000)
            val locationD = MouseInfo.getPointerInfo().location
            logger.info("[오른쪽아래 지정완료 $locationD]")

            // A
            //    D 시작점 A와 마지막점 D로 값 구하기.

            return Rectangle(
                locationA.x,
                locationA.y,
                locationD.x - locationA.x,
                locationD.y - locationA.y
            )

        }

    }


}