package com.felixsoares.animatedbottomtab.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.felixsoares.animatedbottomtab.R
import kotlinx.android.synthetic.main.fragment_blank.*

class BlankFragment : Fragment() {

    companion object {
        const val NUMBER_OF_PAGE = "NUMBER_OF_PAGE"

        fun newInstance(numberOfPage: Int): Fragment {
            return BlankFragment().apply {
                arguments = Bundle().apply {
                    putInt(NUMBER_OF_PAGE, numberOfPage)
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtMessage.text = "Fragment ${arguments?.getInt(NUMBER_OF_PAGE) ?: "ops! wrong!"}"
    }


}
