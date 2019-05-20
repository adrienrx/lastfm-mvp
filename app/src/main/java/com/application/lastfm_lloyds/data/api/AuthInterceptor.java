package com.application.lastfm_lloyds.data.api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    @Override
    public Response intercept(final Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalUrl = original.url();

        HttpUrl url = originalUrl.newBuilder()
                .addQueryParameter("api_key", "5e0486fe0919c13f73e58609fbc32df9")
                .addQueryParameter("format", "json")
                .build();

        Request request = original.newBuilder().url(url).build();

        return chain.proceed(request);
    }
}
