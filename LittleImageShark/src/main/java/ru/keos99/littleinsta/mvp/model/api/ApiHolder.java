package ru.keos99.littleinsta.mvp.model.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHolder {
    private static ApiHolder instance = new ApiHolder();
    private UserDataSource userDataSource;

    public static ApiHolder getInstance() {
        if (instance == null){
            instance = new ApiHolder();
        }
        return instance;
    }

    private ApiHolder() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        userDataSource = new Retrofit.Builder()
                .baseUrl("https://api.imageshack.com/v2/user")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(UserDataSource.class);
    }

    public UserDataSource getUserDataSource() {
        return userDataSource;
    }
}
