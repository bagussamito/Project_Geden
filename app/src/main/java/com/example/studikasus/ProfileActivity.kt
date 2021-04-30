package com.example.studikasus

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studikasus.data.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class ProfileActivity : AppCompatActivity() {
    
    private lateinit var user: FirebaseUser
    private lateinit var ref: DatabaseReference
    private lateinit var userID: String
    private lateinit var usernametext: TextView
    private lateinit var emailtext: TextView
    private lateinit var passwordtext: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        usernametext = findViewById(R.id.username_text)
        emailtext = findViewById(R.id.email_text)
        passwordtext = findViewById(R.id.password_text)

        user = FirebaseAuth.getInstance().currentUser
        ref = FirebaseDatabase.getInstance().getReference("Users")
        userID = user.uid

        ref.child(userID).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userProfile = snapshot.getValue(Users::class.java)
                if (userProfile != null){
                    val username: String? = userProfile.username
                    val email: String? = userProfile.email
                    val password: String? = userProfile.password

                    usernametext.setText(username)
                    emailtext.setText(email)
                    passwordtext.setText(password)
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

    }
}