package ru.keos99.littleinsta.Fragments.ChangeColorShemeFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.keos99.littleinsta.R;

public class ChangeColorShemeFragment extends Fragment {

    public static Fragment newInstance(){
        ChangeColorShemeFragment fragment = new ChangeColorShemeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_color_sheme, null);
        return view;
    }
}
