package ru.keos99.littleinsta.Fragments.MainFragment;

public class PhotoListItem {
    private int imageID;
    private Boolean favorites;

    public PhotoListItem(int imageID, boolean favorites){
        this.imageID = imageID;
        this.favorites = favorites;
    }

    public int getImageID() {
        return imageID;
    }

    public Boolean getFavorites() {
        return favorites;
    }
}
