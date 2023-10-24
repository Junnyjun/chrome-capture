import java.awt.Rectangle
import java.awt.Robot
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    var robot = Robot()
    val createScreenCapture = robot.createScreenCapture(Rectangle(0, 0, 100, 100))
    val createMultiResolutionScreenCapture = robot.createMultiResolutionScreenCapture(Rectangle(0, 0, 100, 100))

    val write = ImageIO.write(createScreenCapture, "jpg", File("test.jpg"))

//    val write2 = ImageIO.write(createMultiResolutionScreenCapture, "jpg", File("test2.jpg"))
    println("robot = ${robot}")

}