package com.lge.sampleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lge.sampleapp.databinding.ListFragmentBinding
import com.lge.sampleapp.databinding.MainFragmentBinding
import com.lge.sampleapp.databinding.UserListItemBinding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // 액티비티가 최초 실행되었을 때
        //  : savedInstanceState == null

        if (savedInstanceState == null) {
            // val fragment = MainFragment()
            val fragment = ListFragment()

            /*
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
           */

            // Kotlin 에서 안드로이드를 사용할 때
            // 편리하게 사용할 수 있는 Kotlin Android Extension 라이브러리가 있습니다.
            //    Jetpack Android KTX
            //  > 의존성 추가
            //    androidx.fragment:fragment-ktx:1.3.5

            supportFragmentManager.commit {
                replace(R.id.fragmentContainer, fragment)
            }


        }
    }
}

// fragment.MainFragment.kt
/*
class MainFragment : Fragment(R.layout.main_fragment) {

    lateinit var helloButton: Button
    lateinit var nameTextView: TextView

    /*
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.main_fragment,
        container, false
    )
    */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        helloButton = view.findViewById(R.id.helloButton)
        nameTextView = view.findViewById(R.id.nameTextView)
    }

    override fun onStart() {
        super.onStart()

        helloButton.setOnClickListener {
            nameTextView.text = "Hello, Kotlin"
        }
    }
}
*/

// View Binding - Fragment
/*
class MainFragment : Fragment() {

    // layout/main_fragment.xml
    private var _binding: MainFragmentBinding? = null

    private val binding: MainFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onStart() {
        super.onStart()

        binding.helloButton.setOnClickListener {
            binding.nameTextView.text = "Hello, Kotlin"
        }
    }

    // 주의사항: 프래그먼트에서 View binding을 사용할 때
    //         메모리 누수의 위험성이 있습니다.
    //  - .addToBackStack()
    //   => 프래그먼트는 유효하지만, 뷰는 유효하지 않을 수 있습니다.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
*/


class MainFragment : Fragment(R.layout.main_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 프로퍼티로 바인딩 객체를 사용하지 않는다면,
        // 메모리 관리에 대한 부분을 처리하지 않아도 됩니다.
        val binding = MainFragmentBinding.bind(view)
        binding.helloButton.setOnClickListener {
            binding.nameTextView.text = "Hello, Kotlin2"
        }
    }
}


// RecyclerView의 ViewHolder에서도 View Binding을 사용할 수 있습니다.
// RecyclerView는 각 아이템에 대한 레이아웃을 추가해야 합니다.
//   - layout/user_list_item.xml
class ListFragment : Fragment(R.layout.list_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val users = listOf("Tom", "Bob", "Alice")

        val binding = ListFragmentBinding.bind(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = ListAdapter(users)

    }
}

// RecyclerView
// 1) ViewHolder
// 2) ListAdapter
/*
private class ListAdapter(var items: List<String> = emptyList()) :
    RecyclerView.Adapter<ListAdapter.Holder>() {

    class Holder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)
    )


    override fun onBindViewHolder(holder: Holder, position: Int) {

        with(holder.itemView) {
            val loginTextView: TextView = findViewById(R.id.loginTextView)
            val typeTextView: TextView = findViewById(R.id.typeTextView)
            val avatarImageView: ImageView = findViewById(R.id.avatarImageView)

            val login = items[position]
            loginTextView.text = login
            typeTextView.text = "User"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(parent)
    override fun getItemCount(): Int = items.count()
}
*/

private class ListAdapter(var items: List<String> = emptyList()) :
    RecyclerView.Adapter<ListAdapter.Holder>() {

    class Holder(val binding: UserListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val login = items[position]
        holder.binding.loginTextView.text = login
        holder.binding.typeTextView.text = "User"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = UserListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return Holder(binding)
    }


    override fun getItemCount(): Int = items.count()
}













