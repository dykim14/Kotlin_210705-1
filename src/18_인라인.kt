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

    override fun run() {
        for (i in 1..1_000_000) {
            //--------
            lock.lock()
            n += 1
            lock.unlock()
            //--------
        }
    }
}

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