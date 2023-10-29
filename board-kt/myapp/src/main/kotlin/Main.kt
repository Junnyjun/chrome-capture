import java.awt.Image
import java.awt.Rectangle
import java.awt.Robot
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    System.setProperty("sun.java2d.uiScale.enabled", "false")
    System.setProperty("sun.java2d.uiScale", "1.0")

    val target = File("${System.currentTimeMillis()}.png")
    val robot = Robot()

    val sizer = Rectangle(0, 0, 2000, 1000);
    val createScreenCapture = robot.createScreenCapture(sizer)

    val createGraphics = createScreenCapture.createGraphics()
    createGraphics.drawImage(createScreenCapture, 0, 0, null)
    createGraphics.dispose()

    ImageIO.setUseCache(false)
    ImageIO.setCacheDirectory(null)

    val write = ImageIO.write(createScreenCapture, "png", target)
    println("robot = ${robot}")

}