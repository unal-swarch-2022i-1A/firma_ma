package com.firma.mobile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.firma.mobile.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    //private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_profile)
        Log.d("ProfileActivity","Vista del perfil de usuario")
        val nameProfile = findViewById<TextView>(R.id.nameProfile)
        val emailProfile = findViewById<TextView>(R.id.emailProfile)
        //val imageProfile = findViewById<TextView>(R.id.imageView) as ImageView
        val mainActivity = MainActivity()
        val user = mainActivity.userMobile
        nameProfile.text = intent.getStringExtra("name")
        emailProfile.text = intent.getStringExtra("email")
        //imageProfile.setImageResource(R.drawable."mipmap/ic_launcher_round")
        val btnLog = findViewById<Button>(R.id.buttonProfile)
        btnLog.setOnClickListener {
            startActivity(Intent(this@ProfileActivity, MainActivity::class.java))
        }



        /*binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
    }

    /*override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_profile)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}