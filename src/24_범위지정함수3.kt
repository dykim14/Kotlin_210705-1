package ex23

import java.io.FileInputStream

data class User(val name: String, val age: Int)

class SQLBuilder {
    fun append(query: String) {}
}

class Database {
    fun create(query: SQLBuilder) {}
}

fun main() {
    val database = Database()
    val user = User("Tom", 42)
    val query = SQLBuilder()
    query.append("INSERT INTO user (name, age) VALUES")
    query.append("(${user.name}, ${user.age})")

    database.create(query)

    SQLBuilder().apply {
        append("INSERT INTO user (name, age) VALUES")
        append("(${user.name}, ${user.age})")
    }.also {
        println("Query logging...")
    }.run {
        database.create(this)
    }
}
