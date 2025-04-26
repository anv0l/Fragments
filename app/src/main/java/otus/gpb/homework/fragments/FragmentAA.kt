package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class FragmentAA: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.setBackgroundColor(ColorGenerator.generateColor())
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(RESULT_KEY_A_A) {_,bundle ->
            view.setBackgroundColor(bundle.getInt(RESUlT_BUNDLE))
        }
    }
}