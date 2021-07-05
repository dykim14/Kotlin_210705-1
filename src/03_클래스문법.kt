// 03_클래스문법.kt
package ex3

/*
// User.java
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
*/

// 1. Kotlin은 기본이 public 입니다.
//    Java는 기본이 패키지 접근 레벨입니다.
// 2. public 클래스를 별도의 파일로 분리할 필요가 없습니다.
// 3. 하나의 파일에 여러개의 public 클래스를 작성할 수 있습니다.

// public class Person {
class Person {
}

// 4. 생성자는 constructor 함수를 통해 만들 수 있습니다.
/*
class User {
    private var name: String
    private var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}
*/
// 5. constructor의 역활이 필드를 초기화하는 역활만 수행한다면,
//    아래와 같이 작성할 수 있습니다.
/*
class User constructor(
    private var name: String,
    private var age: Int
)
*/

// 6. constructor가 아무런 지정자가 존재하지 않으면,
//    생략 가능합니다.

// 7. 동등성 비교
//  Java
//    user1 == user2     : 참조 동등성
//    user1.equals(user2): 객체 동등성
//  Kotlin
//    user1 === user2 : 참조 동등성
//    user1 == user2  : 객체 동등성(equals)

class User(
    private var name: String,
    private var age: Int
) {

    // 객체 동등성을 위해서 equals에 대한 정의가 필요합니다.
    // 차이점
    // @Override -> override
    // Object    -> Any?(Nullable)
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other === null) {
            return false
        }
        // Any? -> Any
        /*
        // Smart Cast: Any -> User
        if (other !is User) {
            return false
        }
        */
        // 스마트 캐스트가 동작하지 않습니다.
        if (other.javaClass != User::class.java) {
            return false
        }

        // 명시적인 캐스트가 필요합니다.
        other as User


        return name == other.name && age == other.age
        // Kotlin - Smart Cast
        // : 컴파일러가 코드를 분석해서, 타입을 자동으로 추론합니다.
    }
}

fun main() {
    // Java: User user = new User("Tom", 42);

    // Kotlin
    // : new 키워드를 사용하지 않습니다.
    // var user: User = User("Tom", 42)
    var user1: User? = User("Tom", 42)
    var user2: User? = User("Tom", 42)

    if (user1 === user2) {
        println("참조 동등")
    } else {
        println("참조 동등 X")
    }

    if (user1 == user2) {
        println("객체 동등")
    } else {
        println("객체 동등 X")
    }
}





