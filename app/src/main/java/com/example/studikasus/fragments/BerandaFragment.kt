package com.example.studikasus.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.Toast
import com.example.studikasus.DialogActivity
import com.example.studikasus.LoginActivity
import com.example.studikasus.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_beranda.*

/**
 * A simple [Fragment] subclass.
 */
class BerandaFragment : Fragment() {





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beranda, container, false)

        val option_pemasukan = view.findViewById(R.id.option_pemasukan) as ImageButton
        option_pemasukan.setOnClickListener {
            val i = Intent(activity, DialogActivity::class.java)
            startActivity(i)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }


}