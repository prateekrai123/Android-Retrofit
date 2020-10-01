package com.indiatechlabs.retrofitgetdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indiatechlabs.retrofitgetdemo.model.MainModel;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    Context context;
    List<MainModel> itemList;

    public RecyclerAdapter(Context context, List<MainModel> itemList){
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_data, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.mainText.setText(itemList.get(position).getTitle());
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(itemList.get(position).getUrl()).into(holder.mainImage);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView mainText;
        ImageView mainImage;

        public RecyclerViewHolder(View itemView){
            super(itemView);

            mainImage = itemView.findViewById(R.id.mainImage);
            mainText = itemView.findViewById(R.id.mainText);
        }
    }

}
