package com.doku.android.sdk.utils;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * Created by dedyeirawan on 21,May,2020
 */
public class CookieInterceptor implements Interceptor {
    @Override
    public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
        String cookie = "DokuPaySdk";
        Request request = chain.request();
        if(cookie != null) {
            request = request.newBuilder()
                    .removeHeader("Cookie")
                    .addHeader("Cookie", cookie)
                    .addHeader("content-type", "application/json")
                    .header("Connection", "close")
                    .build();
        }else {
            request = request.newBuilder().build();
        }
        okhttp3.Response response = chain.proceed(request);
        return response;
    }
}
