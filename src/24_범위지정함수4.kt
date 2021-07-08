package ex24

import java.io.Closeable
import java.io.FileInputStream

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

fun main() {
    val resource = MyResource()

    resource.use {
        resource.process()
    }
}


/*
fun main() {
    val fis = FileInputStream("a.txt")
    val n = fis.read()
    println(n)

    fis.close()
}
*/