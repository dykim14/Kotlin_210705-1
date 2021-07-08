// 23_범위지정함수2.kt
package ex23_2


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
        with (view) {
            emailTextView.text = user.email
            nameTextView.text = user.name
            loginButton.onClickListener = OnClickListener {
                println("Button clicked")
            }
        }

    }
}

fun main() {
    val viewHolder = ViewHolder()
    viewHolder.bind(User("Tom", "tom42@gmail.com"))
}




