package ru.keos99.littleinsta.mvp.view.fragments;

import com.arellomobile.mvp.MvpView;

public interface AboutUserFragmentView extends MvpView {
    void setUserNameText (String username);
    void getAuthToken();
}
