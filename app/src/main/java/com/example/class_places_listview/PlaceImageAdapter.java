package com.example.class_places_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceImageAdapter extends BaseAdapter {
    private ArrayList<String> imageList;
    private LayoutInflater inflater;

    public PlaceImageAdapter(Context context, ArrayList<String> imageList) {
        this.imageList = imageList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImgViewHolder holder;
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.img_row, null);
            holder = new ImgViewHolder();
            holder.placeImage = convertView.findViewById(R.id.placeImage);
            convertView.setTag(holder);
        }else{
            holder=(ImgViewHolder) convertView.getTag();
        }

        int imId=convertView.getResources().getIdentifier(imageList.get(position),"mipmap",inflater.getContext().getPackageName());
        holder.placeImage.setImageResource(imId);

        return convertView;
    }

    private class ImgViewHolder{

        private ImageView placeImage;
    }

}
