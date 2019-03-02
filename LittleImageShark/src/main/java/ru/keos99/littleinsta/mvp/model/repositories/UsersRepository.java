package ru.keos99.littleinsta.mvp.model.repositories;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import ru.keos99.littleinsta.mvp.model.api.ApiHolder;
import ru.keos99.littleinsta.mvp.model.entity.user.Auth;
import ru.keos99.littleinsta.mvp.model.entity.user.User;

public class UsersRepository {

    public Single<User> getUser (String username, String authtoken){
        return ApiHolder.getApi().getUser(username,authtoken)
                .subscribeOn(Schedulers.io());
    }

    public Single<Auth> login (String userlogin, String password){
        return ApiHolder.getApi().login(userlogin, password)
                .subscribeOn(Schedulers.io());
    }
}
