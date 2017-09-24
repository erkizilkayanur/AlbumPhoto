package com.example.nurerkizilkaya.albumphoto.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurerkizilkaya.albumphoto.R;
import com.example.nurerkizilkaya.albumphoto.model.Photos;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by a s u s on 24.9.2017.
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    public List<Photos> data;
    public Context context;

    public PhotoAdapter(Context context,List<Photos> data){
        this.context = context;
        this.data=data;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_photo_list, parent, false);

        return new PhotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        Photos p=data.get(position);

        holder.albumId.setText(p.getAlbumId().toString());
        holder.titleId.setText(p.getTitle().toString());
        holder.photoId.setText(p.getId().toString());
        //Picasso.with(context).load(p.getUrl()).resize(120, 60).into(holder.imageID);
        Picasso.with(context).load(p.getUrl().toString()).into(holder.imageID);

        Log.d("ADAPTER","****");


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class  PhotoViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imageID)
        ImageView imageID;
        @Bind(R.id.albumId)
        TextView albumId;
        @Bind(R.id.photoId)
        TextView photoId;
        @Bind(R.id.titleId)
        TextView titleId;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
