package ru.keos99.littleinsta.Fragments.MainFragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;
import ru.keos99.littleinsta.R;

public class PhotoRVAdapter extends RecyclerView.Adapter<PhotoRVAdapter.VievHolder> {

    private List<PhotoListItem> photoListItems;

    public PhotoRVAdapter (List<PhotoListItem> photoListItems){
        this.photoListItems = photoListItems;
    }

    @NonNull
    @Override
    public VievHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int vievtype) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_foto_rv_adapter,viewGroup,false);
        VievHolder vievHolder = new VievHolder(view);
        return vievHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VievHolder vievHolder, int position) {
        PhotoListItem photoListItem = photoListItems.get(position);
        vievHolder.photoViev.setImageResource(photoListItem.getImageID());
        /*
        if (photoListItem.getFavorites()){
            vievHolder.favoriteViev.setImageResource(R.drawable.hearton);
        } else {
            vievHolder.favoriteViev.setImageResource(R.drawable.heart);
        }
        */
    }

    @Override
    public int getItemCount() {
        return photoListItems.size();
    }

    public static class VievHolder extends RecyclerView.ViewHolder {
        public ImageView photoViev;
        //public ImageView favoriteViev;

        public VievHolder(@NonNull View itemView) {
            super(itemView);
            photoViev = itemView.findViewById(R.id.iv_photo);
            //favoriteViev = itemView.findViewById(R.id.iv_favorites);
        }
    }
}
