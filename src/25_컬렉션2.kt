// 25_컬렉션2.kt
package ex25_2

fun main() {
    val list = listOf(
        "Seoul 서울", "Suwon 수원", "Busan 부산", "Yongin 용인", "Daegu 대구"
    )

    // 1. forEach - 순회
    // list.forEach { println(it) }
    // list.forEach(::println)

    // 2. map
    //   : transform
    //   List<T>   ->  map  -> List<U>
    list.map(String::lowercase)   // List<String> -> map -> List<String>
    // .forEach(::println)

    list.map(String::length)      // List<String> -> map -> List<Int>
    // .forEach(::println)

    // 3. filter
    //   : 조건이 만족되지 않는 요소를 제거한다.
    /*
    val result = list
        .map {
            if (it.startsWith("S"))  // List<String> -> map -> List<String?>
                it.lowercase()
            else
                null
        }
        .filter {                          // List<String?> -> filter -> List<String?>
            it != null
        }
        .map {                             // List<String?> -> map    -> List<String>
            it!!
        }

    println(result)
    */

    /*
    val result = list
        .map {
            if (it.startsWith("S"))  // List<String> -> map -> List<String?>
                it.lowercase()
            else
                null
        }
        .filterNotNull()

    println(result)
    */

    /*
    val result = list
        .mapNotNull {
            if (it.startsWith("S"))  // List<String> -> map : Nullable -> List<String>
                it.lowercase()
            else
                null
        }

    println(result)
    */

    // 4. flatMap
    val result = list
        .map {                          // List<String> -> map -> List<List<Int>>
            it.split(" ").map(String::length)
        }
    println(result)

    val result2 = list
        .flatMap {                      // List<String> -> flatMap -> List<Int>
            it.split(" ").map(String::length)
        }
    println(result2)
}