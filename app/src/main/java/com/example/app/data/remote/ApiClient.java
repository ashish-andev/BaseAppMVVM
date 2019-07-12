package com.example.app.data.remote;


import com.example.app.data.remote.interceptor.HttpInterceptor;
import com.example.app.utils.Constants;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    private final static int CACHE_SIZE_BYTES = 1024 * 1024 * 2;
    private static final int CONNECT_TIMEOUT = 20;
    private static final int READ_TIMEOUT = 30;
    private static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            apiService = initApiService().create(ApiService.class);
        }
        return apiService;
    }

    private static Retrofit initApiService() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
//        httpClient.cache(new Cache(AppController.getInstance().getCacheDir(), CACHE_SIZE_BYTES));
        httpClient.addInterceptor(new HttpInterceptor());
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(httpClient.build())
                .build();
    }


}
