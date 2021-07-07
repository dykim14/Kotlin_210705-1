// 15_고차함수3.kt
package ex15_3

// 고차 함수의 용도
// => 인자를 함수로 전달하는 경우
//    다양한 시나리오에서 동작하는 함수의 코드 중복을 없앨 수 있다.
// => 함수의 재사용성을 높일 수 있다.

fun filter(data: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    val result = mutableListOf<Int>()

    for (e in data) {
        if (predicate(e)) {
            result.add(e)
        }
    }

    return result
}

fun isOdd(e: Int) = e % 2 == 1
fun isEven(e: Int) = e % 2 == 0

// (Int) -> Boolean

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val result1 = filter(list, ::isOdd)
    val result2 = filter(list, ::isEven)

    println(result1)
    println(result2)

    // 1. 익명 함수
    var result = filter(list, fun(e: Int): Boolean {
        return e % 2 == 0
    })
    println(result)

    // 2. 익명 함수 - 단일 표현식
    result = filter(list, fun(e: Int) = e % 2 == 0)
    println(result)

    // 3. 람다 표현식(Lambda Expression)
    //  : 실행 가능한 코드 블록
    // => 블록의 마지막 라인의 결과가 블록의 최종 결과가 됩니다.

    result = filter(list, { e: Int ->
        e % 2 == 0
    })
    println(result)

    // 4. 람다 표현식은 인자 타입 추론이 가능합니다.
    result = filter(list, { e ->
        e % 2 == 0
    })
    println(result)

    // 5. 함수(filter)의 마지막 인자가 람다 표현식으로 전달될 경우,
    //    람다 표현식의 블록을 함수의 호출 괄호 밖에 위치할 수 있습니다.
    //   => Trailing Lambda
    result = filter(list) { e ->
        e % 2 == 0
    }

    fun foo(block: (Int) -> Boolean) {}
    // 함수 인자만 존재하는 경우
    foo { e ->
        e % 2 == 0
    }

    // 6. 람다 표현식의 인자가 1개인 경우,
    //    it 키워드를 통해 참조할 수 있습니다.
    //    (인자를 명시하지 않는 경우, -> 생략 가능합니다.)
    result = filter(list) {
        it % 2 == 0
    }



}