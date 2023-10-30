package io.git.capture

import java.util.*
import java.util.logging.Logger

private val scanner = Scanner(System.`in`)
fun main() {
    System.setProperty("sun.java2d.uiScale.enabled", "false")
    System.setProperty("sun.java2d.uiScale", "1.0")
    val logger = Logger.getLogger("CAPTURE BOARD")
    ClearPath.ClearPathUsecase().clear()

    val capture = Capture.CaptureUsecase()
    logger.info("[CAPTURE BOARD] 시작")
    print("캡쳐할 페이지 수를 입력해주세요 : ")
    val page = scanner.nextInt()

    println("""
         [KEY CODE]
         숫자     알파벳                                         기능키             방향 키
         0 = 48  A = 65 B = 66 C = 67 a = 97  b = 98 c = 99    Backspace = 8    ← = 37
         1 = 49  D = 68 E = 69 F = 70 d = 100 e = 101 f = 102  Tab = 9          ↑ = 38
         2 = 50  G = 71 H = 72 I = 73 g = 103 h = 104 i = 105  Enter = 13, 10   → = 39
         3 = 51  J = 74 K = 75 L = 65 j = 106 k = 107 l = 108  Shift = 16       ↓ = 40
         4 = 52  M = 77 N = 78 O = 79 m = 109 n = 110 o = 111  Ctrl = 17
         5 = 53  P = 80 Q = 81 R = 82 p = 112 q = 113 r = 114  Alt = 18        Esc = 27
         6 = 54  S = 83 T = 84 U = 85 s = 115 t = 116 u = 117  ESC = 27        Home = 36
         7 = 55  V = 86 W = 87 X = 88 v = 118 w = 119 x = 120  Space = 32      End = 35
         8 = 56  Y = 89 Z = 90        y = 121 z = 122          Pageup = 33     Insert = 45
         9 = 57                                                Pagedown = 34   Delete = 46
    """.trimIndent())
    print("다음 페이지로 넘어가는 키를 입력해주세요 : ")
    val nextPageKey = scanner.nextInt()
    print("파일명을 입력해주세요 : ")
    val fileName:String = scanner.next()
    print("한장당 작업 시간(ms)을 입력해 주세요 최소값 (200) : ")
    val delay:Long = scanner.nextLong()
    print("")


    println("[CAPTURE BOARD] 다음 페이지 키 : $nextPageKey")
    println("[CAPTURE BOARD] 페이지 수 : $page")
    println("[CAPTURE BOARD] 파일명 : $fileName")
    println("[CAPTURE BOARD] 한장당 작업 시간 : $delay")
    println("------------------------------------------")

    println("[CAPTURE BOARD] SETTING 완료")
    println("[CAPTURE BOARD] Page Setting 3초전")
    println("캡쳐할 대상( APP, 페이지)를 클릭(활성) 상태로 놔주세요")
    Thread.sleep(1000)
    println("[CAPTURE BOARD] Page Setting 2초전")
    Thread.sleep(1000)
    println("[CAPTURE BOARD] Page Setting 1초전")
    val sizer = Sizer.SizerUsecase().size()

    repeat(page){ index ->
        Thread.sleep(delay)
        val request = Capture.CaptureSizer("$index", nextPageKey, sizer)
        capture.capture(request)
    }

    Parser.ParserUsecase().convert(Parser.ParserSizer(fileName, sizer))
    ClearPath.ClearPathUsecase().clear()
}