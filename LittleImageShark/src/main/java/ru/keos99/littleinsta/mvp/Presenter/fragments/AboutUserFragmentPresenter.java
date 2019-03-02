package ru.keos99.littleinsta.mvp.Presenter.fragments;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.keos99.littleinsta.mvp.model.repositories.UsersRepository;
import ru.keos99.littleinsta.mvp.view.fragments.AboutUserFragmentView;

@InjectViewState
public class AboutUserFragmentPresenter extends MvpPresenter<AboutUserFragmentView> {

    UsersRepository usersRepository;

    public AboutUserFragmentPresenter(){
        usersRepository = new UsersRepository();
    }
}
