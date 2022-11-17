package com.example.finalproject2customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Item> {

    public ListAdapter(Context context, ArrayList<Item> itemArrayList){

        super(context, R.layout.list_item, itemArrayList);

    }

    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Item item = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.foto);
        TextView itemname = convertView.findViewById(R.id.itemname);
        TextView harganame = convertView.findViewById(R.id.harganame);
        TextView tipename = convertView.findViewById(R.id.tipename);

        imageView.setImageResource(item.imageId);
        itemname.setText(item.item);
        harganame.setText(item.harga);
        tipename.setText(item.tipe);

        return convertView;

    }

}
