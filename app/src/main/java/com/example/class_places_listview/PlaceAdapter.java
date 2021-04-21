package com.example.class_places_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends BaseAdapter {
    private ArrayList<Place> placesList;
    private LayoutInflater inflater;

    public PlaceAdapter(Context context, ArrayList<Place> placesList) {
        this.placesList = placesList;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount()  {
        return placesList.size();
    }

    @Override
    public Object getItem(int position)  { return placesList.get(position);}

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.place_row, null);
            holder = new ViewHolder();
            holder.placeNameLbl = convertView.findViewById(R.id.placeNameLbl);
            holder.placeImg = convertView.findViewById(R.id.placeImg);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        holder.placeNameLbl.setText(placesList.get(position).getName());
        int imId=convertView.getResources().getIdentifier(placesList.get(position).getImages().get(0).toString(),"mipmap",inflater.getContext().getPackageName());
        holder.placeImg.setImageResource(imId);

        return convertView;
    }
    private class ViewHolder{
        //create attributes according to the object related to the list_row
        private TextView placeNameLbl;
        private ImageView placeImg;
    }

}
