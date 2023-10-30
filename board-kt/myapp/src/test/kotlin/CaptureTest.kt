import io.git.capture.Capture
import io.git.capture.Capture.CaptureSizer
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.awt.Rectangle

class CaptureTest{
    private val capture = Capture.CaptureUsecase()

    @Test
    fun task()= assertTrue {
            val request = CaptureSizer("1", 34, Rectangle(0, 0, 800, 600));
            val result = capture.capture(request)
            result.exists()
    }
}