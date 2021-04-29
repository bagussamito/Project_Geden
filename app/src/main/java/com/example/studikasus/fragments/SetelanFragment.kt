package com.example.studikasus.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.studikasus.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_setelan.*

/**
 * A simple [Fragment] subclass.
 */
class SetelanFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setelan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser

        layoutPassword.visibility = View.VISIBLE
        layoutNewPassword.visibility = View.GONE


    }
}