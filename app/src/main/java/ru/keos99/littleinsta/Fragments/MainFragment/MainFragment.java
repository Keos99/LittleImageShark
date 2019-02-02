package ru.keos99.littleinsta.Fragments.MainFragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.keos99.littleinsta.R;

import static android.app.Activity.RESULT_OK;

public class MainFragment extends Fragment implements ActivityCompat.OnRequestPermissionsResultCallback {

    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;
    private PhotoRVAdapter photoRVAdapter;
    private List<PhotoListItem> photoListItems;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_CODE_PERMISSION_CAMERA = 100;

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
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
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
                checkPremisionCamera();
                Snackbar.make(view, "Фото добавлено", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void checkPremisionCamera(){
        int permissionStatus = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA);
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            dispatchTakePictureIntent();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CAMERA}, REQUEST_CODE_PERMISSION_CAMERA);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION_CAMERA:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent();
                } else {
                    Snackbar.make(getView(), "Камера: в доступе отказано", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                return;
        }
    }

    public void setRandomList(){
        int imgID;
        photoListItems = new ArrayList<PhotoListItem>();
        for (int i = 0; i < 6; i++) {
            if (i%2 == 0){
                imgID = R.drawable.android;
                } else {
                imgID = R.drawable.android2;
            }
            photoListItems.add(new PhotoListItem(imgID,this));
        }
    }
}
