package ru.keos99.littleinsta.Fragments.MainFragment;

import android.support.v4.app.Fragment;

public class PhotoListItem {
    Fragment fragment;
    private int imageID;


    public PhotoListItem(int imageID,Fragment fragment){
        this.imageID = imageID;
        this.fragment = fragment;
    }

    public int getImageID() {
        return imageID;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
