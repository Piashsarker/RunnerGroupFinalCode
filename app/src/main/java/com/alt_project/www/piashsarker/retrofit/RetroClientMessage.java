package com.alt_project.www.piashsarker.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pt on 9/23/16.
 */
public class RetroClientMessage {

    /********
     * URLS
     *******/
    private static final String ROOT_URL = "http://power.itsolutionbd.net/api/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {

        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiServiceMessage getApiService() {
        return getRetrofitInstance().create(ApiServiceMessage.class);
    }
}
