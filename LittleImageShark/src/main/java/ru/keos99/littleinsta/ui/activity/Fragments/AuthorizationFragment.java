package ru.keos99.littleinsta.ui.activity.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.keos99.littleinsta.R;
import ru.keos99.littleinsta.mvp.Presenter.fragments.AuthorizationFragmentPresenter;
import ru.keos99.littleinsta.mvp.view.fragments.AuthorizationFragmentView;

public class AuthorizationFragment extends MvpAppCompatFragment implements AuthorizationFragmentView {

    @InjectPresenter
    AuthorizationFragmentPresenter presenter;

    private EditText loginEditText;
    private EditText passwordEditText;
    private Button authorizationOkButton;

    private View view;

    public static Fragment newInstance(){
        AuthorizationFragment fragment = new AuthorizationFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_authorization,null);
        initUI();
        return view;
    }

    private void initUI(){
        loginEditText = view.findViewById(R.id.login_edittext);
        passwordEditText = view.findViewById(R.id.password_edittext);
        authorizationOkButton = view.findViewById(R.id.authorization_button);
    }
}
