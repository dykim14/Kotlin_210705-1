// 25_컬렉션.kt
package ex25

class SListIterator<E>(
    var current: SList.Node<E>?
) : Iterator<E> {

    override fun hasNext() = current != null

    override fun next(): E {
        // 현재의 값이 존재하지 않을 경우, 종료되어야 합니다.
        val ret = current!!.value
        current = current?.next

        return ret
    }
}

class SList<E> : Iterable<E> {
    class Node<E>(val value: E, val next: Node<E>?)

    private var head: Node<E>? = null

    val front: E?
        get() = head?.value

    fun addFront(value: E) {
        head = Node(value, head)
    }

    override fun iterator() = SListIterator(head)
}

// 코틀린은 클래스의 제네릭 인자를 생성자 / 변수 타입을 통해 추론할 수 있습니다.
fun main() {
    // val list = SList<Int>()
    val list: SList<Int> = SList()
    list.addFront(10)
    list.addFront(20)
    list.addFront(30)

    println(list.front)

    val iterator = list.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    for (e in list)
        println(e)

    // 코틀린에서는 확장 함수를 통해 컬렉션을 다루는 다양한 기능이
    // 제공됩니다.
    //  - forEach, map, flatMap, filter, sorted
    //  - take, drop, distinct, first, last
    //  - groupBy, zip
    // : 위의 연산은 컬렉션을 다루는 표준적인 연산입니다.
    //   "기본적인 사용법을 숙지해야 합니다."

    //  : Sequence API
    //  => 코틀린에서 컬렉션을 다루는 다양한 표준 연산자를 제공합니다.

    //  Java 8 에서는 "Stream API"를 제공하고 있습니다.






}







