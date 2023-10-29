import java.io.File
import java.util.logging.Logger

interface ClearPath {
    fun clear()

    class ClearPathUsecase: ClearPath {
        private val logger = Logger.getLogger("CLEAR PATH")
        override fun clear(): Unit {
            logger.info("[CLEAR PATH] START")
            val targets = File("./target")
            val files = targets.listFiles()!!
            files.forEach {
                it.delete()
            }
            logger.info("[CLEAR PATH] END")
        }
    }
}