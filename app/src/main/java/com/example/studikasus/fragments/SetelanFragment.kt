package com.example.studikasus.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.studikasus.LoginActivity
import com.example.studikasus.ProfileActivity
import com.example.studikasus.R
import com.google.firebase.auth.FirebaseAuth

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
        val view = inflater.inflate(R.layout.fragment_setelan, container, false)
        val btnLogout = view.findViewById(R.id.btnLogout) as TextView
        val btnProfile = view.findViewById(R.id.btnProfile) as TextView

        btnLogout.setOnClickListener{
            auth.signOut()
            val i = Intent(activity, LoginActivity::class.java)
            startActivity(i)
        }
        btnProfile.setOnClickListener{
            val i = Intent(activity, ProfileActivity::class.java)
            startActivity(i)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser

        //layoutPassword.visibility = View.VISIBLE
        //layoutNewPassword.visibility = View.GONE

    }

}