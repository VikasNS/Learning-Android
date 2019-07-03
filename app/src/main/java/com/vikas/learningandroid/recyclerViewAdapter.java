package com.vikas.learningandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter {

    private List<String> list;
    public  recyclerViewAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_textview,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(linearLayout);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MyViewHolder)viewHolder).one.setText(list.get(i));
        ((MyViewHolder)viewHolder).two.setText(list.get(i));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView one;
        TextView two;
        public MyViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            linearLayout = itemView;
            one = itemView.findViewById(R.id.one);
            two = itemView.findViewById(R.id.two);
        }
    }
}
