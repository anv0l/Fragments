package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResultListener

class FragmentA : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    @Suppress("DEPRECATION")
                    requireActivity().onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_open_fragment_aa).setOnClickListener {
            val backgroundColor = ColorGenerator.generateColor()

            childFragmentManager.setFragmentResult(
                RESULT_KEY_A_A,
                bundleOf(RESUlT_BUNDLE to backgroundColor)
            )
            childFragmentManager.popBackStackImmediate(
                "fragmentA",
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )

            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_view_container_a, FragmentAA())
                .addToBackStack("fragmentA")
                .commit()
        }

        setFragmentResultListener(RESULT_KEY_A) { _, bundle ->
            view.setBackgroundColor(bundle.getInt(RESUlT_BUNDLE))
        }


    }


}