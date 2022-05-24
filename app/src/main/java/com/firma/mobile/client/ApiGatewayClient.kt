package com.firma.mobile.client

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Query
import com.firma.mobile.UserQuery
import okhttp3.internal.userAgent

class ApiGatewayClient  {

    //GlobalScope.launch (Dispatchers.Main) { callGetApi() }
    // Create a client
    //val okHttpClient = OkHttpClient.Builder().build()
    public suspend fun consumeUserAPI(email: String): UserQuery.GetUserByEmail {
        val apolloClient = ApolloClient.builder()
                .serverUrl(APIGATEWAYURL)
                .build()

        val response = apolloClient.query(UserQuery(email)).execute()
        val id = response.data?.getUserByEmail?.userId
        val firstName = response.data?.getUserByEmail?.firstName
        val lastName = response.data?.getUserByEmail?.lastName
        val email = response.data?.getUserByEmail?.email
        val password = response.data?.getUserByEmail?.password
        val user = UserQuery.GetUserByEmail(id, firstName, lastName, email, password)
        Log.d("Client","User first name = ${response.data?.getUserByEmail?.firstName}")
        Log.d("Client","User last name = ${response.data?.getUserByEmail?.lastName}")
        Log.d("Client","User email = ${response.data?.getUserByEmail?.email}")
        //return userFName.toString()
        return user
    }

    public fun validatePassword(user: UserQuery.GetUserByEmail, passwordView: String): Boolean{
        if (user.password.equals(passwordView))
            return true
        else
            return false
    }

    companion object {
        private const val APIGATEWAYURL = "http://192.168.1.8:4000/graphql"
    }
}
