// 04_접근지정자.kt
package ex4

// Java
//   private - package - protected - public
//  문제점
//   1. protected: 같은 패키지에서 "protected"에 대한
//              접근이 가능합니다.
//   2. package
//        A(module)
//           com.lge.Sample
//             package: getName(), name
//        B(module)
//           com.lge.Foo
//             : Sample 클래스의 패키지 레벨에
//               접근이 가능합니다.
//
// Kotlin
//   private - internal - protected - public
//  protected: 자식 클래스를 통해서 접근이 가능합니다.
//   internal: 같은 모듈에서만 접근이 가능합니다.
//             다른 모듈에서 동일한 이름의 패키지를 사용하더라도
//             접근이 불가능합니다.

// class, interface, enum
// fun, var, val 에 대해서도 접근지정자를 사용할 수 있습니다.

//   public: 다른 모듈에서 접근할 수 있다.
// internal: 같은 모듈에서 접근할 수 있다.
//  private: 같은 파일에서만 접근이 가능합니다.

internal class User {
    protected var name: String = ""
    internal var age: Int = 0
}

private var globalVariable = 100
public fun add(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    val user = User()
    // user.name = "Tom"
    // Cannot access 'name': it is protected in 'User'
    user.age = 10
}











