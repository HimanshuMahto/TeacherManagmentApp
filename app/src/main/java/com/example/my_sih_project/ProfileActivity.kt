package com.example.my_sih_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class ProfileActivity : AppCompatActivity() {

    lateinit var  toogle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val drawerLayout : DrawerLayout=findViewById(R.id.drawerLayout);
        val navView : NavigationView=findViewById(R.id.navigate);
        toogle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.navigate_home -> startActivity(Intent(this,ProfileActivity::class.java));
                R.id.navigate_setting -> startActivity(Intent(this,feedback::class.java));
                R.id.navigate_feedback -> startActivity(Intent(this,feedback::class.java));
                R.id.navigate_sync -> startActivity(Intent(this,ProfileActivity::class.java));
                R.id.logout -> startActivity(Intent(this,LoginActivity::class.java));
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}