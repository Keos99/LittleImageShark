package ru.keos99.littleinsta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    FloatingActionButton floatingActionButton;

    public static Fragment newInstance(){
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,null);
        floatingActionButton = view.findViewById(R.id.fab);
        fabSetOnClickListener();
        return view;
    }

    public void fabSetOnClickListener (){
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Фото добавлено", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
