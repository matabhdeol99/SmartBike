package com.journaldev.smartbike;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private Context context;
    private List<String> images;
    protected PhotoLiatener photoLiatener;

    public GalleryAdapter(Context context, List<String> images, PhotoLiatener photoLiatener) {

        this.context = context;
        this.images=images;
        this.photoLiatener=photoLiatener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.gallery_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final String image = images.get(position);

        Glide.with(context).load(image).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                photoLiatener.onPhotoClick(image);

            }
                                           }
        );

    }

    @Override
    public int getItemCount() {
        if(images != null)

        {

            return images.size();

        }



        return 0;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image= itemView.findViewById(R.id.image);
        }
    }

    public interface PhotoLiatener{
        void onPhotoClick(String path);
    }
}
