package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class FragmentB : Fragment() {
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
        if (resources.getBoolean(R.bool.isLandscape)) {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_view_container_ba, FragmentBA())
                .replace(R.id.fragment_view_container_bb, FragmentBB())
                .commit()
        } else {
            childFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_view_container_ba, FragmentBA())
                .commit()
        }
        super.onViewCreated(view, savedInstanceState)
    }
}
