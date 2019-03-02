package ru.keos99.littleinsta.mvp.model.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHolder {
    private static ApiHolder instance = new ApiHolder();
    UserDataSource userDataSource;

    public static ApiHolder getInstance() {
        if (instance == null){
            instance = new ApiHolder();
        }
        return instance;
    }

    private ApiHolder() {
        userDataSource = new Retrofit.Builder()
                .baseUrl("https://api.imageshack.com/v2/user/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()))
                .build()
                .create(UserDataSource.class);
    }

    public static UserDataSource getApi() {
        return getInstance().userDataSource;
    }
}
