// 09_object.kt
// 1. object 선언
//  => 싱글톤(Singleton)
//   : 오직 한개의 객체를 생성하고,
//     언제 어디서든 동일한 방법을 통해 접근할 수 있는 객체

// Kotlin Singleton
object Cursor {
    var name: String

    // Constructors are not allowed for objects
    // constructor() {}

    // 초기화 블록
    init {
        println("Cursor 객체 초기화 블록")
        name = "Cursor"
    }

    fun move(x: Int, y: Int) {
        println("Cursor Move - ($x,$y)")
    }
}
/*
fun main() {
    println("Main 함수 시작")
    Cursor.move(10, 20)
}
*/

// 정책 클래스를 사용할 때, 매번 새로운 객체를 생성해야합니다.
// > 정책 클래스를 싱글톤을 통해서 만드는 것이 가능합니다.
//   object 선언
/*
class PersonComparator : Comparator<Person> {
    override fun compare(o1: Person, o2: Person): Int {
        return o1.name.compareTo(o2.name)
    }
}
*/
object PersonComparator : Comparator<Person> {
    override fun compare(o1: Person, o2: Person): Int {
        return o1.name.compareTo(o2.name)
    }
}

data class Person(val name: String) {
    // 중첩 클래스로 object 선언을 이용할 수 있습니다.
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

fun main() {
    val people = listOf(Person("Bob"), Person("Alice"))
    // sort
    //  => Comparator 인터페이스를 만족해야 합니다.

    // val result = people.sortedWith(PersonComparator())
    val result = people.sortedWith(PersonComparator)
    val result2 = people.sortedWith(Person.NameComparator)
    println(result)
}




















