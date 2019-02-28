package ru.keos99.littleinsta.mvp.model.api;


//https://api.imageshack.com/v2/user/login - авторизация пользователя (post)

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.keos99.littleinsta.mvp.model.entity.user.User;

public interface UserDataSource {
    //https://api.imageshack.com/v2/user/<username> - данные о пользователе (GET)
    @GET("/{user}")
    Single<User> getUser(@Path("user") String username);
}
