package com.example.studikasus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.studikasus.CustomDialogFragment
import com.example.studikasus.R
import kotlinx.android.synthetic.main.fragment_beranda.*

/**
 * A simple [Fragment] subclass.
 */
class BerandaFragment : Fragment() {

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.fab_rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.fab_rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.fab_from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.fab_to_bottom_anim) }

    private var clicked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fab_add.setOnClickListener {
            onButtonClicked()
        }
        fab_pemasukan.setOnClickListener {
            var dialog = CustomDialogFragment()

        }
        fab_pengeluaran.setOnClickListener {
            Toast.makeText(context, "Pengeluaran", Toast.LENGTH_SHORT).show()
        }

    }

    private fun onButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            fab_pemasukan.visibility = View.VISIBLE
            fab_pengeluaran.visibility = View.VISIBLE
        } else {
            fab_pemasukan.visibility = View.INVISIBLE
            fab_pengeluaran.visibility = View.INVISIBLE
        }
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            fab_pemasukan.startAnimation(fromBottom)
            fab_pengeluaran.startAnimation(fromBottom)
            fab_add.startAnimation(rotateOpen)
        } else {
            fab_pemasukan.startAnimation(toBottom)
            fab_pengeluaran.startAnimation(toBottom)
            fab_add.startAnimation(rotateClose)
        }
    }
    private fun setClickable(clicked: Boolean) {
        if (!clicked) {
            fab_pemasukan.isClickable = false
            fab_pengeluaran.isClickable = false
        } else {
            fab_pemasukan.isClickable = true
            fab_pengeluaran.isClickable = true
        }
    }
}