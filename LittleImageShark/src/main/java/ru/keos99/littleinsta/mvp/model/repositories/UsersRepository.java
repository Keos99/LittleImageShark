package ru.keos99.littleinsta.mvp.model.repositories;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import ru.keos99.littleinsta.mvp.model.api.ApiHolder;
import ru.keos99.littleinsta.mvp.model.entity.user.User;

public class UsersRepository {

    public Single<User> getUser (String username){
        return ApiHolder.getUserDataSource().getUser(username)
                .subscribeOn(Schedulers.io());
    }
}
