package com.example.studikasus.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.studikasus.R
import kotlinx.android.synthetic.main.fragment_setelan.*

/**
 * A simple [Fragment] subclass.
 */
class SetelanFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setelan, container, false)
    }
}