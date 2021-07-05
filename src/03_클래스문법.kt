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
class User {
    private var name: String
    private var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}



