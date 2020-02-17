package com.pack.anurak.loyaltypoint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.pack.anurak.loyaltypoint.signin.SigninAcitvity
import kotlinx.android.synthetic.main.nav_header.*
import org.jetbrains.anko.toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_profile -> {
                toast("You are click at profile.")
                return true
            }
            R.id.nav_messages ->{
                toast("You are click at massages.")
                return true
            }
            R.id.nav_profile ->{
                toast("You are click at profile.")
                return true
            }
            R.id.nav_update ->{
                toast("You are click at update")
                return true
            }
            R.id.nav_logout ->{
                mAuth!!.signOut()
                startActivity(Intent(this,SigninAcitvity::class.java))
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    lateinit var textView: TextView
    var mAuth: FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView = findViewById<NavigationView>(R.id.nav_view_drawer)
        val headerView = navigationView.getHeaderView(0)
        val tvTitle = headerView.findViewById<TextView>(R.id.tv_title)
        val tvDetail = headerView.findViewById<TextView>(R.id.tv_detail)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth!!.currentUser
        tvTitle.text = user!!.email
        tvDetail.text = user!!.uid

        mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user == null){
                startActivity(Intent(this,SigninAcitvity::class.java))
                finish()
            }
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        textView = findViewById(R.id.text_tool_bar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

        // Set bottom View
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
       /* val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController,appBarConfiguration)*/
        navView.setupWithNavController(navController)

    }
    fun setActionBarTitle(txt: String){
        textView.setText(txt)
    }

    override fun onStart() {
        super.onStart()
        mAuth!!.addAuthStateListener { mAuthListener }
    }

    override fun onStop() {
        super.onStop()
        if (mAuthListener != null){
            mAuth!!.removeAuthStateListener { mAuthListener }
        }
    }
}
