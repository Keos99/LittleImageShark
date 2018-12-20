package ru.keos99.littleinsta.Fragments.MainFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.keos99.littleinsta.R;

public class MainFragment extends Fragment {

    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;
    private PhotoRVAdapter photoRVAdapter;
    private List<PhotoListItem> photoListItems;

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

        recyclerView = view.findViewById(R.id.rv_photo);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setHasFixedSize(true);
        setRandomList();
        photoRVAdapter = new PhotoRVAdapter(photoListItems);
        recyclerView.setAdapter(photoRVAdapter);

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

    public void setRandomList(){
        int imgID;
        boolean favorite;
        photoListItems = new ArrayList<PhotoListItem>();
        for (int i = 0; i < 50; i++) {
            if (i%2 == 0){
                imgID = R.drawable.android;
                favorite = true;
            } else {
                imgID = R.drawable.android2;
                favorite = false;
            }
            photoListItems.add(new PhotoListItem(imgID,favorite));
        }

    }
}
