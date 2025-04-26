package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class FragmentBA : Fragment() {
    private val parentViewModel: ColorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentViewModel.currentColor.observe(viewLifecycleOwner) { color ->
            view.setBackgroundColor(color)
        }

        if (!requireContext().isLandscape()) {
            view.findViewById<Button>(R.id.btn_open_fragment_bb).setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_view_container_ba, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    fun updateColor(color: Int) {
        view?.setBackgroundColor(color)
    }
}