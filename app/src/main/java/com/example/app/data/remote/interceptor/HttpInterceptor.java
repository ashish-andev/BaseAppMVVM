package com.example.app.data.remote.interceptor;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;


import com.example.app.AppController;
import com.example.app.BuildConfig;
import com.example.app.utils.Logger;
import com.example.app.utils.NetworkUtils;
import com.example.app.utils.Utils;

import java.io.IOException;
import java.net.SocketTimeoutException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;


public class HttpInterceptor implements Interceptor {
    private Handler handler = new Handler(Looper.getMainLooper());

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        try {
            if (NetworkUtils.isNetworkConnected()) {
                RequestBody requestBody = request.body();
                Request.Builder requestBuilder = request.newBuilder();
                requestBuilder.addHeader("CompFields-Type", "application/json");

                if (requestBody != null) {
                    request = requestBuilder.post(requestBody).build();
                } else {
                    request = requestBuilder.build();
                }
                if (BuildConfig.DEBUG) {
                    Logger.i("HTTP", request.method() + " -- " + request.url());
                    Logger.i("HTTP", "header-> " + request.headers().toString());
                    Logger.i("HTTP", "reqbody-> " + bodyToString(requestBody));
                }

                Response response = chain.proceed(request);
                Logger.i("HTTP", request.url() + " -- " + response.code());
                ResponseBody body = response.body();
                if (response.isSuccessful() && body != null) {
                    String result = body.string().trim();
                    Logger.i("HTTP", "resBody ->" + result);
                    return response.newBuilder().body(ResponseBody
                            .create(MediaType.parse("application/json"), result))
                            .build();
                } else if (response.code() >= 500 && response.code() < 600) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Utils.showToast("Server error");
                        }
                    });
                } else if (response.code() >= 400 && response.code() < 500) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Utils.showToast("Invalid request");
                        }
                    });
                }
            }
        } catch (SocketTimeoutException e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Utils.showToast("Timeout error");
                }
            });

            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        throw new IOException();
    }


    private String bodyToString(final RequestBody request) {
        try {
            final Buffer buffer = new Buffer();
            if (request != null)
                request.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (Throwable e) {
            return "";
        }
    }
}
