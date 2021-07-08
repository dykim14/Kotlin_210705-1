package ex24

import java.io.*

// 코틀린은 Try-with-resources 문법이 존재하지 않습니다.
// => use

// > 비메모리 자원(파일 등)에 대해서는 명시적인 종료 메소드를 호출해야 합니다.
// 사용자가 작성한 클래스가 비메모리 자원을 이용하고 있다면,
// 명시적인 종료 메소드를 제공해야 한다.
class MyResource : Closeable {
    override fun close() {
        println("자원 해지")
    }

    fun process() {
        println("자원 사용")
    }

    init {
        println("자원 할당")
    }
}

/*
fun main() {
    val resource = MyResource()

    resource.use {
        resource.process()
    }
}
*/

// use를 사용할 때, 여러개의 자원이 close 호출이 보장되어야 한다면
// 중첩이 발생할 수 밖에 없습니다.
// https://appmattus.medium.com/effective-kotlin-item-9-prefer-try-with-resources-to-try-finally-aec8c202c30a
/*
fun main() {
    try {
        FileOutputStream("a.txt").use { fos ->
            BufferedOutputStream(fos).use { bos ->
                DataOutputStream(bos).use { dos ->
                    dos.writeInt(42)
                    dos.writeUTF("Hello")
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}
*/


fun main() {
    try {
        val fos = FileOutputStream("a.txt")
        val bos = BufferedOutputStream(fos)
        val dos = DataOutputStream(bos)

        arrayOf(fos, bos, dos).use {
            dos.writeInt(42)
            dos.writeUTF("Hello")
        }

    } catch (e: IOException) {
        e.printStackTrace()
    }
}


// 주의사항: use는 예외를 처리하지 않습니다.
//        비메모리 자원(Closeable)에 대해서 예외 안전하게
//        close 호출을 보장해주는 역활만 담당합니다.
/*
fun main() {
    val fis = FileInputStream("a.txt")

    try {
        fis.use {
            val n = it.read()
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}
*/

private inline fun <T : Closeable?> Array<T>.use(block: () -> Unit) {
    var exception: Throwable? = null
    try {
        return block()
    } catch (e: Throwable) {
        exception = e
        throw e
    } finally {
        when {
            exception == null -> forEach { it?.close() }
            else -> forEach {
                try {
                    it?.close()
                } catch (closeException: Throwable) {
                    // exception.addSuppressed(closeException)
                }
            }
        }
    }
}