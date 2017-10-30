package com.linder.almacenapp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by linderhassinger on 10/30/17.
 */

public class ApiServiceGenerator {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(ApiService.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit;

    private ApiServiceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass) {
        if(retrofit == null) {
            retrofit = builder.client(httpClient.build()).build();
        }
        return retrofit.create(serviceClass);
    }

}
