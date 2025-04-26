package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FragmentBB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_send_color_to_ba).setOnClickListener {
            val backgroundColor = ColorGenerator.generateColor()

            parentFragmentManager.setFragmentResult(
                RESULT_KEY_B,
                bundleOf(RESULT_BUNDLE to backgroundColor)
            )

            if (!requireContext().isLandscape()) {
                parentFragmentManager.popBackStack()
            }
        }
    }
}