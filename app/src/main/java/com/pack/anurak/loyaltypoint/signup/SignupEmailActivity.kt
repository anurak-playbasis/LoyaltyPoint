package com.pack.anurak.loyaltypoint.signup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.pack.anurak.loyaltypoint.MainActivity
import com.pack.anurak.loyaltypoint.R
import kotlinx.android.synthetic.main.activity_signup_email.*
import org.jetbrains.anko.toast

class SignupEmailActivity: AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_email)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
//        toolbar.setBackgroundColor(Color.WHITE)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        mAuth = FirebaseAuth.getInstance()
        if (mAuth!!.currentUser != null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        btn_register.setOnClickListener {
            val email = et_register_email.text.toString().trim()
            val password = et_register_password.text.toString().trim()
            if (email.isEmpty()){
                toast("Please enter your email address.")
                return@setOnClickListener
            }
            if (password.isEmpty()){
                toast("Please enter your password.")
                return@setOnClickListener
            }
            mAuth!!.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if (!task.isSuccessful){
                    if (password.length < 6){
                        et_register_password.error = "Please check your password. Password must have minimum 6 characters."
                    }else{
                        toast("Create account is fail: "+task.exception)
                    }
                }else{
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}