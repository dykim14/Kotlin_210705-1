package ex17

import java.lang.Appendable
import java.time.LocalDateTime

// 커링(Currying)
// : 다중 인수를 갖는 함수를 단일 인수를 갖는 함수들의 함수열로 바꾸는 작업

// sum(10, 20, 30) => 커링 => sum(10)(20)(30)

// 일반 버전
// fun sum(a: Int, b: Int, c: Int): Int = a + b + c

// Scala - 커링
// fun sum(a: Int)(b: Int)(c: Int) = a + b + c
// => 코틀린은 커링 버전을 자동으로 생성하는 기능을 제공하지 않습니다.

// 용도
// - 인자를 고정합니다.

// fun sum2(a: Int, b: Int): Int = a + b

//fun sum2(a: Int): (b: Int) -> Int = { b ->
//    a + b
//}

// fun sum3(a: Int, b: Int, c: Int): Int = a + b + c

//fun sum3(a: Int): (b: Int) -> (c: Int) -> Int = { b ->
//    { c ->
//        a + b + c
//    }
//}

// (b: Int) -> (c: Int) -> Int
//  => -> 연산자는 오른쪽에서 왼쪽으로 결합을 합니다.
/*
fun main() {
    val plus10 = sum2(10)

    println(plus10(20))
    println(plus10(40))

    val plus_10_20 = sum3(10)(20)
    println(plus_10_20(30))
    println(plus_10_20(50))

    val result3 = sum3(10, 20, 30)
    val result4 = sum3(10)(20)(30)

    println(result3)
    println(result4)

    val result1 = sum2(10)(20)
    println(result1)

    val result2 = sum2(10, 20)
    println(result2)
}
*/
fun sum3(a: Int, b: Int, c: Int): Int = a + b + c
// 기존 함수에 대해서 커링된 버전을 자동으로 생성하는 함수

fun sum2(a: Int, b: Int): Int = a + b
/*
fun sum2(a: Int): (b: Int) -> Int = { b ->
    a + b
}
// (Int) -> (Int) -> Int
*/

fun <P1, P2, R> ((P1, P2) -> R).curried(): (P1) -> (P2) -> R = { p1 ->
    { p2 ->
        this(p1, p2)
    }
}

fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried(): (P1) -> (P2) -> (P3) -> R = { p1 ->
    { p2 ->
        { p3 ->
            this(p1, p2, p3)
        }
    }
}

/*
fun main() {
    val sum = { a: Int, b: Int ->
        a + b
    }.curried()
    println(sum(10)(20))

    val csum3 = ::sum3.curried()
    val result2 = csum3(10)(20)(30)
    println(result2)

    val csum2 = ::sum2.curried()
    val result = csum2(10)(20)

    println(result)
}
*/

//-------------------------
// 써드파티 로깅 라이브러리
enum class Level {
    INFO, WARN
}

// 함수를 설계할 때, 인자의 순서는 변동성이 낮은 순서로 지정해야 합니다.
// => 커링 고려
// => 인자를 고정하는 기술
// => 기존 함수를 재사용하기 위한 기술
fun log(level: Level, appendable: Appendable, message: String) {
    appendable.appendLine(
        "[${level.name}][${LocalDateTime.now()}]: $message"
    )
}

// 써드파티 라이브러리
fun loadImage(logger: (String) -> Unit) {
    logger("이미지 로드 시작")
    logger("이미지 로드 완료")

    logger("이미지 비트맵 변환 완료")
}


fun main() {
    log(Level.INFO, System.out, "프로그램 시작")

    // 1. 람다 표현식을 이용하는 방법.
    loadImage { message ->
        log(Level.INFO, System.out, message)
    }

    // 2. 커링을 통해 인자를 고정합니다.
    val logger = ::log.curried()(Level.INFO)(System.out)
    loadImage(logger)

    log(Level.INFO, System.out, "프로그램 종료")
}





























