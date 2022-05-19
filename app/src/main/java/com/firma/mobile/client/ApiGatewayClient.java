package com.firma.mobile.client;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.firma.mobile.UserQuery;

import okhttp3.OkHttpClient;

public class ApiGatewayClient {

    private static  final String APIGATEWAYURL = "http://localhost:4000/graphql";
    // Create a client

    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    ApolloClient apolloClient = ApolloClient.builder()
            .serverUrl(APIGATEWAYURL)
            .okHttpClient(okHttpClient)
            .build();

    UserQuery userQuery = UserQuery.builder().id(2).build();

    //apolloClient.query query(new UserQuery(1)).enqueue(new ApolloCall.Callback<UserQuery.Data>(){

    //});




}
