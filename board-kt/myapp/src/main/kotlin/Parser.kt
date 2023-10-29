import com.itextpdf.text.Document
import com.itextpdf.text.Image
import com.itextpdf.text.pdf.PdfWriter
import java.awt.Rectangle
import java.io.File
import java.nio.file.Paths
import java.util.logging.Logger

fun interface Parser {
    fun convert(request:ParserSizer): Unit

    class ParserUsecase(
    ) : Parser {
        private val logger = Logger.getLogger("TO PDF...")

        override fun convert(request:ParserSizer): Unit {
            logger.info("[CONVERT] START")

            val targets = Paths.get("./target")
            // v파일 목록 불러오기
            val files = targets.toFile().listFiles()!!
                .sortedBy { it.nameWithoutExtension.toInt() }
            val pdfFile = File("./document/${request.fileName}.pdf")
            logger.info("[CONVERT] WRITE PDF")
            val document = Document(com.itextpdf.text.Rectangle(request.target.width.toFloat(), request.target.height.toFloat()))
            PdfWriter.getInstance(document, pdfFile.outputStream())
            document.open()
            files.forEachIndexed { index, file ->
                logger.info("[CONVERT] Processing ... $index/${files.size}")
                val images = Image.getInstance(file.absolutePath)
                document.add(images)
            }
            logger.info("[CONVERT] WRITE PDF :: ${pdfFile.absolutePath}")
            document.close()

            logger.info("[CONVERT] END")
        }

    }

    data class ParserSizer(
        val fileName:String,
        val target: Rectangle,
    )
}
