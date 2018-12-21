package ru.keos99.littleinsta.Fragments.MainFragment;

public class PhotoListItem {
    private int imageID;
    private Boolean isFavorite;

    public PhotoListItem(int imageID){
        this.imageID = imageID;
    }

    public PhotoListItem(int imageID, boolean isFavorite){
        this.imageID = imageID;
        this.isFavorite = isFavorite;
    }

    public int getImageID() {
        return imageID;
    }

    public Boolean getFavorites() {
        return isFavorite;
    }
}
