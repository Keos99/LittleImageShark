package ru.keos99.littleinsta.mvp.model.api;




import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.keos99.littleinsta.mvp.model.entity.user.Auth;
import ru.keos99.littleinsta.mvp.model.entity.user.User;

public interface UserDataSource {
    //https://api.imageshack.com/v2/user/<username> - данные о пользователе (GET)
    @GET("{user}")
    Single<User> getUser(@Path("user") String username, @Query ("auth_token") String authtoken);

    //https://api.imageshack.com/v2/user/login - авторизация пользователя (post)
    @POST("login")
    Single<Auth> login(@Query("user") String userlogin, @Query ("password") String password);
}
