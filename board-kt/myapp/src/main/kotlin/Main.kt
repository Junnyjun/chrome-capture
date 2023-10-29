import java.util.logging.Logger

fun main() {
    System.setProperty("sun.java2d.uiScale.enabled", "false")
    System.setProperty("sun.java2d.uiScale", "1.0")
    val logger = Logger.getLogger("CAPTURE BOARD")
    ClearPath.ClearPathUsecase().clear()

    val capture = Capture.CaptureUsecase()

    val page = 364;
    val nextPageKey:Int = 34
    val fileName:String = "그림으로 공부하는 IT 인프라 구조"


    logger.info("[CAPTURE BOARD] 시작 3초전")
    logger.info("캡쳐할 대상( APP, 페이지)를 클릭(활성) 상태로 놔주세요")
    Thread.sleep(2000)

    val sizer = Sizer.SizerUsecase().size()

    repeat(page){ index ->
        Thread.sleep(200)
        val request = Capture.CaptureSizer("$index", nextPageKey, sizer)
        capture.capture(request)
    }

    Parser.ParserUsecase().convert(Parser.ParserSizer(fileName, sizer))
//    ClearPath.ClearPathUsecase().clear()
}