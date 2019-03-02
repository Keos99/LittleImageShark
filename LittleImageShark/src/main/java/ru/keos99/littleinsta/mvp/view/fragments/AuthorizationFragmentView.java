package ru.keos99.littleinsta.mvp.view.fragments;

import com.arellomobile.mvp.MvpView;

public interface AuthorizationFragmentView extends MvpView {
    void changeFragment();
    void saveAuthToken (String authtoken);
}
