package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class FragmentBB : Fragment() {
    private val parentViewModel: ColorViewModel by activityViewModels()

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
            parentViewModel.setColor(backgroundColor)

            if (!requireContext().isLandscape()) {
                parentFragmentManager.popBackStack()
            }
        }
    }
}