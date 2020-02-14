package com.pack.anurak.loyaltypoint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        textView = findViewById(R.id.text_tool_bar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
//        val navView = findViewById<NavigationView>(R.id.nav_view_drawer)
        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

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
}
