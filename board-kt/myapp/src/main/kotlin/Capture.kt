import java.awt.Rectangle
import java.awt.Robot
import java.io.File
import java.util.logging.Logger
import javax.imageio.ImageIO

fun interface Capture {
    fun capture(window: CaptureSizer): File

    class CaptureUsecase(
        private val robot:Robot = Robot()

    ):Capture{
        private val logger = Logger.getLogger("CAPTURE BOARD")

        override fun capture(window: CaptureSizer): File {
            logger.info("[CAPTURE BOARD] REQUEST :: $window")
            val createScreenCapture = robot.createScreenCapture( window.target)
                .also {
                    val createGraphics = it.createGraphics()
                    createGraphics.drawImage(it, 0, 0, null)
                    createGraphics.dispose()
                }

            ImageIO.setUseCache(false)
            ImageIO.setCacheDirectory(null)
            logger.info("[CAPTURE BOARD] WRITE -> ${window.index}")
            val target = File("./target/${window.index}.png")
            target.parentFile.mkdirs()

            ImageIO.write(createScreenCapture, "png", target)
            robot.keyPress(window.nextKey)
            logger.info("[CAPTURE BOARD] KEY PRESS :: ${window.nextKey}")
            return target
        }
    }
    data class CaptureSizer(
        val index:String,
        val nextKey:Int,
        val target:Rectangle,
    )
}