package com.vikas.learningandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import okhttp3.OkHttpClient;
import java.util.List;

public class customAdapter extends RecyclerView.Adapter {
    private List<RetroPhoto> dataList;
    private Context context;

    public customAdapter( List<RetroPhoto> dataList,Context context) {this.dataList = dataList;
        this.context=context;}
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customlayout,viewGroup,false);
        return new placeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ((placeHolder)viewHolder).textView.setText(dataList.get(i).getTitle());
         //Picasso.with(context).load(dataList.get(i).getThumbnailUrl())
                       // .into(((placeHolder)viewHolder).imageView);

    }

    @Override
    public int getItemCount() {
        return 100;
    }
}

class placeHolder extends RecyclerView.ViewHolder {
    TextView textView;
    ImageView imageView;
    public placeHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
    }
}