package com.example.studikasus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNav: ChipNavigationBar
    private lateinit var setelanNav: SetelanFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        bottomNav = findViewById<ChipNavigationBar>(R.id.bottom_nav)

        bottomNav.setItemSelected(R.id.nav_beranda, isSelected = true)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, BerandaFragment()).commit()

        bottomMenu()

    }

    private fun bottomMenu() {
        bottomNav.setOnItemSelectedListener(object :
            ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(i: Int) {
                var fragment: Fragment? = null
                when (i) {
                    R.id.nav_beranda -> fragment = BerandaFragment()
                    R.id.nav_laporan -> fragment = LaporanFragment()
                    R.id.nav_setelan -> fragment = SetelanFragment()
                }
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragment_container,
                        fragment!!
                    ).commit()
            }
        })
    }


}