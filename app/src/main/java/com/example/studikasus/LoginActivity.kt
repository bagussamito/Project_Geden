package com.example.studikasus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    private lateinit var berandaNav: BerandaFragment
    private lateinit var setelanNav: SetelanFragment
    private lateinit var auth: FirebaseAuth
    private lateinit var btnBlmPnyAkun: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        btnBlmPnyAkun = findViewById(R.id.textView3)

        btnLogin.setOnClickListener() {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Email harus Diisi"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Email Salah"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length < 6) {
                etPassword.error = "Password harus lebih dari 6 karakter"
                etPassword.requestFocus()
                return@setOnClickListener
            }

            loginUser(email, password)
        }

        btnBlmPnyAkun.setOnClickListener() {
            Intent(this@LoginActivity, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Intent(this@LoginActivity, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            } else {
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            Intent (this@LoginActivity, HomeActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}