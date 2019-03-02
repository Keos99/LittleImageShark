package ru.keos99.littleinsta.mvp.Presenter.fragments;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import io.reactivex.Scheduler;
import ru.keos99.littleinsta.mvp.model.repositories.UsersRepository;
import ru.keos99.littleinsta.mvp.view.fragments.AboutUserFragmentView;

@InjectViewState
public class AboutUserFragmentPresenter extends MvpPresenter<AboutUserFragmentView> {

    private Scheduler scheduler;
    private UsersRepository usersRepository;
    private String authtoken;

    public AboutUserFragmentPresenter(Scheduler scheduler){
        this.scheduler = scheduler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().getAuthToken();
        loadUserData();
    }

    @SuppressLint("CheckResult")
    public void loadUserData(){
        usersRepository = new UsersRepository();
        usersRepository.getUser("keos99", authtoken)
        .observeOn(scheduler)
        .subscribe(user -> {
            getViewState().setUserNameText(user.getResult().getUsername());
                },
                throwable -> {

                });
    }

    public void getAuthToken (String authtoken) {
        this.authtoken = authtoken;
    }


}
