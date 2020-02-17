package com.pack.anurak.loyaltypoint.signin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.pack.anurak.loyaltypoint.MainActivity
import com.pack.anurak.loyaltypoint.R
import com.pack.anurak.loyaltypoint.signup.SignupEmailActivity
import kotlinx.android.synthetic.main.activity_signin_email.*
import kotlinx.android.synthetic.main.activity_signin_email.btn_signin
import kotlinx.android.synthetic.main.activity_signin_email.et_signin_email
import kotlinx.android.synthetic.main.activity_signin_email.et_signin_password
import org.jetbrains.anko.toast

class SigninEmailActivity : AppCompatActivity() {
    var mAuthen: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin_email)

        mAuthen = FirebaseAuth.getInstance()
        if (mAuthen!!.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
        }
        btn_signin.setOnClickListener {
            val email = et_signin_email.text.toString().trim()
            val password = et_signin_password.text.toString().trim()
            if (email.isEmpty()) {
                toast("Please enter your email address.")
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                toast("Please enter your password.")
                return@setOnClickListener
            }
            mAuthen!!.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    if (password.length < 6) {
                        et_signin_password.error =
                            "Please check your password. Password must have minimum 6 characters."
                    } else {
                        toast("Sign in fail: " + task.exception)
                            .show()
                    }
                } else {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }
        tv_register.setOnClickListener {startActivity(Intent(this,SignupEmailActivity::class.java))
        }

    }
}