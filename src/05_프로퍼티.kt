// 05_프로퍼티.kt
package ex5

// 프로퍼티(property)
// : 접근자 메소드(Accessor Method)
//   를 자동으로 생성하는 문법

// class User(var name: String, var age: Int)

class User {
    // 프로퍼티
    //  getter + setter: var
    //           getter: val
    var name: String
    val age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}

fun main() {
    val user = User("Tom", 42)

    val name = user.name  // getName
    var age = user.age    // getAge

    user.name = "Bob"    // setName
    // user.age = 10        // setAge
}









