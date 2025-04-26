package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class FragmentAA : Fragment() {
    private val SAVED_COLOR = "saved_color"
    private var savedBackgroundColor: Int = ColorGenerator.generateColor()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        savedBackgroundColor = savedInstanceState?.getInt(SAVED_COLOR) ?: savedBackgroundColor
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(savedBackgroundColor)

        view.findViewById<Button>(R.id.btn_open_fragment_ab).setOnClickListener {
            val backgroundColor = ColorGenerator.generateColor()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_view_container_a, FragmentAB())
                .addToBackStack("fragmentAB")
                .commit()

            parentFragmentManager.setFragmentResult(
                RESULT_KEY_A_A,
                bundleOf(RESULT_BUNDLE to backgroundColor)
            )
        }

        setFragmentResultListener(RESULT_KEY_A) { _, bundle ->
            savedBackgroundColor = bundle.getInt(RESULT_BUNDLE)
            view.setBackgroundColor(savedBackgroundColor)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SAVED_COLOR, savedBackgroundColor)
    }
}