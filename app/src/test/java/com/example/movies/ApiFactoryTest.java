package com.example.movies;

import org.junit.Test;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactoryTest {
    @Test
    public void testApiFactory() throws Exception {
        Retrofit instance = ApiRetrofitTest.retrofit;
        if ((!instance.baseUrl().url().toString().equals("https://api.kinopoisk.dev/")))
            throw new AssertionError();
    }
}

class ApiRetrofitTest {

    public static final String BASE_URL = "https://api.kinopoisk.dev/";

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();
}

