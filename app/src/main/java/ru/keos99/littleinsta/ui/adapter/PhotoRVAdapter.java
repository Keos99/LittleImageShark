package ru.keos99.littleinsta.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

import ru.keos99.littleinsta.mvp.model.entity.PhotoListItem;
import ru.keos99.littleinsta.ui.activity.Fragments.PhotoFragment;
import ru.keos99.littleinsta.R;

public class PhotoRVAdapter extends RecyclerView.Adapter<PhotoRVAdapter.VievHolder> {

    private List<PhotoListItem> photoListItems;
    private Fragment fragment;

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
        vievHolder.bind(position,vievHolder);
    }

    @Override
    public int getItemCount() {
        return photoListItems.size();
    }

    public class VievHolder extends RecyclerView.ViewHolder {
        public ImageView photoViev;

        public VievHolder(@NonNull View itemView) {
            super(itemView);
            photoViev = itemView.findViewById(R.id.iv_photo);
        }

        public void bind (final int position,VievHolder vievHolder ){
            final PhotoListItem item = photoListItems.get(position);
            fragment = item.getFragment();
            vievHolder.photoViev.setImageResource(item.getImageID());

            itemView.setOnClickListener(v -> fragment.getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_master,PhotoFragment.newInstance())
                    .addToBackStack("Fragment")
                    .commit());
        }
    }
}
