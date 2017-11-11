package com.mr.rohmani.recyclegrid;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by USER on 10/11/2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private String[] mData = new String[0];
    private TypedArray mImage;
    private LayoutInflater mInflater;
    private Context context;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, String[] data, TypedArray image) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mImage = image;
        this.context = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_menu, parent, false);
        MyViewHolder rcv = new MyViewHolder(view);
        return rcv;
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String menu = mData[position];
        holder.myTextView.setText(menu);
        holder.myImage.setImageResource(mImage.getResourceId(position, -1));
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.length;
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData[id];
    }

}
