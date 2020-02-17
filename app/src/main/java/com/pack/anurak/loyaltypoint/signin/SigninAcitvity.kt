package com.pack.anurak.loyaltypoint.signin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.pack.anurak.loyaltypoint.MainActivity
import com.pack.anurak.loyaltypoint.R
import kotlinx.android.synthetic.main.activity_signin.*
import org.jetbrains.anko.toast

class SigninAcitvity: AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        mAuth = FirebaseAuth.getInstance()
        if (mAuth!!.currentUser != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        btn_sign_email.setOnClickListener {
            startActivity(Intent(this,SigninEmailActivity::class.java))
            finish()
        }
        btn_sign_facebook.setOnClickListener {
            toast("Now, you can't login by facebook account.")
        }
        btn_sign_google.setOnClickListener {
            toast("Now, you can't login by google account.")
        }

    }

}