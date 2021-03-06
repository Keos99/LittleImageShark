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
import ru.keos99.littleinsta.mvp.Presenter.fragments.PhotoFragmentPresenter;
import ru.keos99.littleinsta.mvp.view.fragments.PhotoFragmentView;

public class PhotoFragment extends MvpAppCompatFragment implements PhotoFragmentView {

    @InjectPresenter
    PhotoFragmentPresenter photoFragmentPresenter;
    private View view;
    private ImageView iVPhotoDetails;
    private ImageView iVFavorite;
    private TextView tVPhotoDetails;

    public static Fragment newInstance(){
        PhotoFragment fragment = new PhotoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_photo,null);
        initUI();

        return view;
    }

    public void initUI(){
        iVPhotoDetails = view.findViewById(R.id.iv_photo_details);
        iVFavorite = view.findViewById(R.id.iv_favorite);
        tVPhotoDetails = view.findViewById(R.id.tv_photo_details);
    }
}
