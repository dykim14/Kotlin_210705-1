// 18_인라인
package ex18

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

fun main() {
    val t1 = IncThread()
    val t2 = IncThread()

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    println(IncThread.n)
}