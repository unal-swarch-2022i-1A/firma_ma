package com.firma.mobile

//import com.firma.mobile.client.ApiGatewayClient.consumeUserAPI
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firma.mobile.R
import com.firma.mobile.client.ApiGatewayClient
import android.widget.TextView
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope

import kotlinx.coroutines.launch

//import com.firma.mobile.SigningActivity
//import com.firma.mobile.MainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val myTextView = findViewById<TextView>(R.id.textView)
        val emailView = findViewById<TextView>(R.id.email)
        val passwordView = findViewById<TextView>(R.id.password)
        val btnLog = findViewById<Button>(R.id.buttonLog)
        btnLog.setOnClickListener {
            lifecycleScope.launch {
                Log.d("MainActivity", "Email ingresado: " + emailView.text.toString())
                Log.d("MainActivity", "Contraseña ingresada: " +passwordView.text.toString())
                val apiGatewayClient = ApiGatewayClient()
                var user = apiGatewayClient.consumeUserAPI(emailView.text.toString())
                val isCorrect = apiGatewayClient.validatePassword(user, passwordView.text.toString())
                    if (isCorrect){
                        userMobile = user
                        Log.d("MainActivity", "User Mobile: " +userMobile.toString())
                        Toast.makeText(this@MainActivity, "Bienvenido.", Toast.LENGTH_SHORT).show()
                        Log.d("MainActivity","Bienvenido")
                        val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                        intent.putExtra("name", user.firstName + " " + user.lastName)
                        intent.putExtra("email", user.email)
                        startActivity(Intent(intent))
                        //setContentView(R.layout.content_profile)
                    }
                    else{
                        Toast.makeText(this@MainActivity, "Contraseña incorrecta.", Toast.LENGTH_SHORT).show()
                        Log.d("MainActivity", "Contraseña incorrecta")
                    }
                Log.d("MainActivity",user.toString())
            }
            //myTextView.text = userFName
        }
        Log.d("MainActivity","This works 2")
//        myTextView.text = name



    }

    /** Called when the user taps the Send button  */
    fun sendMessage(view: View?) {
        val intent = Intent(this, SigningActivity::class.java)
        val message = "messages"
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }
    var userMobile: UserQuery.GetUserByEmail? = null
    companion object {
        const val EXTRA_MESSAGE = "com.firma.mobile.app_name"

    }
}