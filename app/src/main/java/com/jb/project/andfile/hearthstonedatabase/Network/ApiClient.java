package com.jb.project.andfile.hearthstonedatabase.Network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alexander on 04.08.2017.
 */

public class ApiClient {

    public static final String BASE_URL = "https://omgvamp-hearthstone-v1.p.mashape.com";
    public static Retrofit sRetrofit = null;

    public static Retrofit getApiClient() {


        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
        if (sRetrofit == null) {
        sRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build(); }
        return sRetrofit;
    }
}
