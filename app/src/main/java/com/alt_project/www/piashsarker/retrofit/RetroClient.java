package com.alt_project.www.piashsarker.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 08-Sep-16.
 */
public class RetroClient {
    /********
     * URLS
     *******/
    private static final String ROOT_URL = "http://android.winsoft-bd.com/DemoHRM/WebAPI_Final/";

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
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
