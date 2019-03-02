package ru.keos99.littleinsta.mvp.Presenter.fragments;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.Scheduler;
import ru.keos99.littleinsta.mvp.model.repositories.UsersRepository;
import ru.keos99.littleinsta.mvp.view.fragments.AuthorizationFragmentView;

@InjectViewState
public class AuthorizationFragmentPresenter extends MvpPresenter<AuthorizationFragmentView> {

    private Scheduler scheduler;
    private UsersRepository usersRepository;

    public AuthorizationFragmentPresenter(Scheduler scheduler){
        this.scheduler = scheduler;
    }

    @SuppressLint("CheckResult")
    public void onClick(String login, String password) {
        usersRepository = new UsersRepository();
        usersRepository.login(login,password)
        .observeOn(scheduler)
        .subscribe(auth -> {
            getViewState().saveAuthToken(auth.getAuthToken());
            getViewState().changeFragment();
                },
                throwable -> {});
    }
}
