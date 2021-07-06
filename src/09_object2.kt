// 09_object2.kt
// 2. Companion Object(동반 객체)
//    Java: static field / static method
//  Kotlin: static 키워드가 제공되지 않습니다.
//        => 동반 객체
/*
class User {
    private static final String NAME = "Tom";
    public static String getUserName() {
        return NAME;
    }

    public static void printName() {
        System.out.println(NAME);
    }
}
*/
/*
class User {
    companion object {
        val NAME = "Tom"

        fun printName() {
            println(NAME)
        }
    }
}

fun main() {
    println(User.NAME)
    User.printName()
}
*/

// 활용 1. 정적 팩토리 메소드
//      => 생성자를 직접 사용하는 것이 아니라,
//         정적 팩토리 메소드를 제공하면 좋습니다.
//       - 생성자의 한계
//        : 생성자의 이름은 클래스의 이름으로 고정되어 있습니다.

/*
class User {
    val nickname: String

    private constructor(nickname: String) {
        this.nickname = nickname
    }
}
*/
class User private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String): User {
            return User(email.substringBefore("@"))
        }

        fun newFacebookUser(accountId: String): User {
            return User("facebook@$accountId")
        }
    }

    override fun toString(): String {
        return "User(nickname='$nickname')"
    }
}

fun main() {
    val user1 = User.newSubscribingUser("hello@gmail.com") // hello
    val user2 = User.newFacebookUser("a122344556")  // facebook@a122344556

    println(user1.nickname)
    println(user2.nickname)
}












