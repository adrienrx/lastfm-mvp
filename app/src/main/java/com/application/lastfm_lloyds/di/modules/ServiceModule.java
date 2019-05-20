package com.application.lastfm_lloyds.di.modules;

import com.application.lastfm_lloyds.data.api.LFMApi;
import com.application.lastfm_lloyds.data.repo.LFMDataSource;
import com.application.lastfm_lloyds.data.repo.LFMRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@Module(includes = NetworkModule.class)
public class ServiceModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit(final OkHttpClient okHttpClient) {
        ObjectMapper jacksonMapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        return new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(jacksonMapper))
                .build();
    }

    @Provides
    @Reusable
    LFMApi provideLFMApiService(final Retrofit retrofit) {
        return retrofit.create(LFMApi.class);
    }

    @Provides
    LFMDataSource provideSearchRepository(final LFMApi lfmApi) {
        return LFMRepository.getInstance(lfmApi);
    }

}
