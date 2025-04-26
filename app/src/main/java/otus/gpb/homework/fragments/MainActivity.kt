package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_open_fragment_a).setOnClickListener {
            supportFragmentManager.popBackStackImmediate("fragmentA", FragmentManager.POP_BACK_STACK_INCLUSIVE)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_view_container, FragmentA())
                .addToBackStack("fragmentA")
                .commit()
        }

        findViewById<Button>(R.id.btn_open_fragment_b).setOnClickListener {
            supportFragmentManager.popBackStackImmediate("fragmentB", FragmentManager.POP_BACK_STACK_INCLUSIVE)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_view_container, FragmentB())
                .addToBackStack("fragmentB")
                .commit()
        }
    }

}