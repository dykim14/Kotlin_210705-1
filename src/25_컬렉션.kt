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