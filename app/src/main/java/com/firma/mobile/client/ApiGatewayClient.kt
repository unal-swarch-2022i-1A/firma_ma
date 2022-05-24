package com.firma.mobile.client

import com.apollographql.apollo3.ApolloClient
import com.firma.mobile.UserQuery
import okhttp3.internal.userAgent

class ApiGatewayClient  {

    //GlobalScope.launch (Dispatchers.Main) { callGetApi() }
    // Create a client
    //val okHttpClient = OkHttpClient.Builder().build()
    public suspend fun consumeUserAPI(): String {
        val apolloClient = ApolloClient.builder()
                .serverUrl(APIGATEWAYURL)
                .build()

        val response = apolloClient.query(UserQuery(3)).execute()
        val userFName = response.data?.getUser?.firstName + " " + response.data?.getUser?.lastName
        println("User first name = ${response.data?.getUser?.firstName}")
        println("User last name = ${response.data?.getUser?.lastName}")
        println("User email = ${response.data?.getUser?.email}")
        return userFName.toString()
    }

    companion object {
        private const val APIGATEWAYURL = "http://url:port/graphql"
    }
}
