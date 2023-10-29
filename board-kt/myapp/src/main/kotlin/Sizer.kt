import java.awt.MouseInfo
import java.awt.Rectangle
import java.util.logging.Logger


interface Sizer {
    fun size(): Rectangle

    class SizerUsecase(
    ) : Sizer {
        private val logger = Logger.getLogger("SIZRE BOARD")

        override fun size(): Rectangle {

            // A ,B C , D 구하기
            println("왼쪽위, 오른쪽 아래를 지정하여 사이즈를 측정합니다.")
            println("왼쪽 위 지정 3초전")
            Thread.sleep(1000)
            println("왼쪽 위 지정 2초전")
            Thread.sleep(1000)
            println("왼쪽 위 지정 1초전")
            Thread.sleep(1000)

            println("[왼쪽위 모서리 지정중 (클릭)...]")
            Thread.sleep(500)
            val locationA = MouseInfo.getPointerInfo().location
            println("[왼쪽위 모서리 지정완료 $locationA]")
            Thread.sleep(500)

            println("오른쪽 아래 지정 3초전")
            Thread.sleep(1000)
            println("오른쪽 아래 지정 2초전")
            Thread.sleep(1000)
            println("오른쪽 아래 지정 1초전")
            Thread.sleep(1000)

            print("[오른쪽아래 모서리 지정중 (클릭)...]")
            Thread.sleep(500)
            val locationD = MouseInfo.getPointerInfo().location
            print("[오른쪽아래 지정완료 $locationD]")
            print("")

            return Rectangle(
                locationA.x, locationA.y,
                locationD.x - locationA.x, locationD.y - locationA.y
            )

        }

    }

}