package ru.keos99.littleinsta.ui.activity.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.keos99.littleinsta.R;
import ru.keos99.littleinsta.mvp.Presenter.fragments.AboutUserFragmentPresenter;
import ru.keos99.littleinsta.mvp.view.fragments.AboutUserFragmentView;

public class AboutUserFragment extends MvpAppCompatFragment implements AboutUserFragmentView {

    @InjectPresenter
    AboutUserFragmentPresenter presenter;

    TextView userNameTextView;
    ImageView lastLoadImageOne;
    ImageView lastLoadImageTwo;
    ImageView lastLoadImageThree;
    ImageView lastLoadImageFour;

    private View view;

    public static Fragment newInstance(){
        AboutUserFragment fragment = new AboutUserFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_aboutuser,null);
        initUI();
        return view;
    }

    private void initUI(){
        userNameTextView = view.findViewById(R.id.forload_username_textview);
        lastLoadImageOne = view.findViewById(R.id.forload_lastimage1);
        lastLoadImageTwo = view.findViewById(R.id.forload_lastimage2);
        lastLoadImageThree = view.findViewById(R.id.forload_lastimage3);
        lastLoadImageFour = view.findViewById(R.id.forload_lastimage4);
    }

    @Override
    public void setUserNameText(String username) {
        userNameTextView.setText(username);
    }
}
