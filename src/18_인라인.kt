// 18_인라인
package ex18

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

// 1. 코틀린은 자바의 synchronized 블록을 제공하지 않습니다.
//  => 동기화 관련 코드를 직접 작성해야 합니다.

/*
class IncThread : Thread() {
    companion object {
        var n: Int = 0
    }

    override fun run() {
        for (i in 1..1_000_000) {
            n += 1
        }
    }
}
*/
class IncThread(private val lock: Lock) : Thread() {
    companion object {
        var n: Int = 0
    }

    // 문제점: 임계 영역 안에서 예외가 발생할 경우, unlock이 호출되지 않습니다.
    //     => 데드락의 위험성이 있습니다.
    /*
    override fun run() {
        for (i in 1..1_000_000) {
            //--------
            lock.lock()
            n += 1
            lock.unlock()
            //--------
        }
    }
    */

    // 동기화를 안전하게 처리할 수 있는 함수를 만들어봅시다.
    /*
    override fun run() {
        for (i in 1..1_000_000) {
            //--------
            lock.lock()
            try {
                n += 1
            } finally {
                lock.unlock()
            }
            //--------
        }
    }
    */

    override fun run() {
        for (i in 1..1_000_000) {
            // withLock(lock) {
            lock.withLock {
                n += 1
            }
        }
    }
}

// 코틀린은 Extension Function 을 통해 기능을 제공하고 있습니다.
// => 함수를 인자로 받는 함수에 대해서, 함수 호출의 오버헤드를 없앨 수 있습니다.
//    inline: 함수를 호출하는 것이 아니라 바이트 코드로 치환합니다.
//      1) 함수를 인자로 받는 고차 함수에서 오버헤드를 없애기 위해 사용할 수 있습니다.

inline fun <T> Lock.withLock(action: () -> T): T {
    lock()
    try {
        return action()
    } finally {
        unlock()
    }
}

/*
fun <T> withLock(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }
}
*/


fun main() {
    val lock = ReentrantLock()


    val t1 = IncThread(lock)
    val t2 = IncThread(lock)

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    println(IncThread.n)
}