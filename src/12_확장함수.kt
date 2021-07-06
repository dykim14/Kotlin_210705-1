// 12_확장함수
//  Extension Function
//   : 코틀린에서 많이 사용하는 설계 방법의 핵심 문법

// 기존 라이브러리를 확장하는 방법
//  1) 상속(수직 확장)
//    : 기반 클래스를 상속 받아서, 자식 클래스를 통해 새로운 기능을 제공한다.
//    한계 - 기반 클래스가 상속을 목적으로 반드시 설계되어야 한다.
//          경직된 설계이기 때문에, 수정이 어렵다.

//  2) 확장 함수(수평 확장)
//     : 사용자가 정의한 함수가 기존 클래스의 '메소드'처럼 보이게 하는 기술
//     => 기존 클래스의 구조에 상관없이 다양한 기능을 추가할 수 있습니다.
//     C#: Extension Function
//  Swift: Extension
//   ObjC: Category
//    ....

package ex12

/*
fun lastChar(text: String): Char {
    return text[text.length - 1]
}
*/

fun String.lastChar(): Char {
    return this[this.length - 1]
}


fun main() {
    // val result = lastChar("hello")

    val result = "hello".lastChar()
    println(result)
}









