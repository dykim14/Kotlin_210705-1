// 23_범위지정함수2.kt
package ex23_2

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.test.assertNotEquals


fun interface OnClickListener {
    fun onClick()
}

class Button(var onClickListener: OnClickListener? = null) {
    fun click() {
        onClickListener?.onClick()
    }
}

class TextView(var text: String = "")

// layout/list_item_user.xml
class View {
    val nameTextView = TextView()
    val emailTextView = TextView()
    val loginButton = Button()
}

class User(val name: String, val email: String)

class ViewHolder {
    val view = View()

    fun bind(user: User) {

        view.emailTextView.text = user.email
        view.nameTextView.text = user.name
        view.loginButton.onClickListener = OnClickListener {
            println("Button clicked")
        }

        // with
        with(view) {
            emailTextView.text = user.email
            nameTextView.text = user.name
            loginButton.onClickListener = OnClickListener {
                println("Button clicked")
            }
        }

    }
}

inline fun <T, R> with1(receiver: T, block: T.() -> R): R {
    return receiver.block()
}

// 3. with
//  : Nullable이 아닌 수신 객체를 참조해서, 수행해야 하는 작업을 정의한다.


// 4. also
//  : 초기화가 아닌 유효성 체크에 많이 사용합니다.
inline fun <T> T.also2(block: (T) -> Unit): T {
    block(this)
    return this
}

// 5. run
//  : 지역 변수의 범위를 제한하거나,
//    코드를 수행하고자 할 때 사용합니다.

inline fun <R> run2(block: () -> R): R {
    return block()
}

fun main() {
    val user = User("Tom", "tom42@gmail.com").also {
//        assertNotEquals("Tom", it.name)
    }

    // 블록을 그냥 사용하면, 람다 표현식이 됩니다.
    val fn = {

    }
    println(fn)

    val result = run {
        42
    }
    println(result)


    val holder = ViewHolder()

    holder.view.emailTextView.text = user.email
    holder.view.nameTextView.text = user.name
    holder.view.loginButton.onClickListener = OnClickListener {
        println("Button clicked")
    }

    with(holder.view) {
        emailTextView.text = user.email
        nameTextView.text = user.name
        loginButton.onClickListener = OnClickListener {
            println("Button clicked")
        }
    }


    // viewHolder.bind(user)
}




