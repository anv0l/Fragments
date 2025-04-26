package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels


class FragmentB : Fragment() {
    private val viewModel: ColorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_b,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.currentColor.observe(viewLifecycleOwner) { color ->
            updateFragments(color)
        }
        if (resources.getBoolean(R.bool.isLandscape)) {
            showLandscape()
        } else {
            showPortrait()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun showLandscape() {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_view_container_ba, FragmentBA())
            .replace(R.id.fragment_view_container_bb, FragmentBB())
            .commit()
    }

    private fun showPortrait() {
        childFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_view_container_ba, FragmentBA())
            .commit()
    }

    private fun updateFragments(color: Int) {
        val fragmentBA = childFragmentManager.findFragmentById(R.id.fragment_view_container_ba)
        if (fragmentBA is FragmentBA) {
            fragmentBA.updateColor(color)
        }
    }

}
