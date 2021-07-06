// 13_확장프로퍼티.kt
package ex13

// 프로퍼티
// 1. Backing field 있는 프로퍼티 - 확장 프로퍼티를 만들 수 없습니다.
// 2. Backing field 없는 프로퍼티
//   - 객체의 크기에 영향을 주지 않는 프로퍼티에 대해서만 확장 프로퍼티를 만들 수 있습니다.

fun String.lastChar(): Char = this[length - 1]

// val: getter
//  - "String"은 불변 객체이기 때문에 수정이 불가능합니다.
//  - 확장 함수는 외부 함수이기 때문에, 클래스가 공개하는 메소드나 프로퍼티에 대한 접근만 가능합니다.
val String.lastChar: Char
    get() = this[length - 1]

// var: getter + setter


fun main() {
    // val result = "hello".lastChar()

    val result = "hello".lastChar
    println(result)
}