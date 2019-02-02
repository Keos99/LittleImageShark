package ru.keos99.littleinsta.Fragments.ChangeColorShemeFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.keos99.littleinsta.App;
import ru.keos99.littleinsta.R;

public class ChangeColorShemeFragment extends Fragment {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private View view;

    public static Fragment newInstance(){
        ChangeColorShemeFragment fragment = new ChangeColorShemeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_change_color_sheme, null);

        initUI();
        addButtonChangeThemeListener();

        return view;
    }

    public void onClickListener(Button button, int theme){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getInstance().setTheme(theme);
            }
        });
    }

    public void addButtonChangeThemeListener(){
        onClickListener(button1,R.style.Cold_Theme);
        onClickListener(button2,R.style.Orange_Theme);
        onClickListener(button3,R.style.Warm_Theme);
        onClickListener(button4,R.style.AppTheme);
    }

    public void initUI (){
        button1 = view.findViewById(R.id.button);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);
    }


}
