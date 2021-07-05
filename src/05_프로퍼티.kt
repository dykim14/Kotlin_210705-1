// 05_프로퍼티.kt
package ex5
import javasample.ex5.User as JUser
// 이름 충돌이 발생할 경우, aliasing을 통해 해결할 수 있습니다.

// 프로퍼티(property)
// : 접근자 메소드(Accessor Method)
//   를 자동으로 생성하는 문법

// class User(var name: String, var age: Int)

class User {
    // 프로퍼티
    //  getter + setter: var
    //           getter: val
    var name: String
        private set

    var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}

fun main() {
    val user = JUser("Tom", 42)

    val name = user.name  // getName
    var age = user.age    // getAge

    // user.name = "Bob"    // setName
    // user.age = 10        // setAge
}









