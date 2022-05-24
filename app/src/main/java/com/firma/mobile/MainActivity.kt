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
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.ApolloClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//import com.firma.mobile.SigningActivity
//import com.firma.mobile.MainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myTextView = findViewById<TextView>(R.id.textView)
        lifecycleScope.launch {
            val apiGatewayClient = ApiGatewayClient()
            var userFName = apiGatewayClient.consumeUserAPI()
            myTextView.text = userFName
            Log.d("MainActivity",userFName)
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

    companion object {
        const val EXTRA_MESSAGE = "com.firma.mobile.app_name"
    }
}