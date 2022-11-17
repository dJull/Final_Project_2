package com.example.finalproject2customer.Electronic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.finalproject2customer.Item;
import com.example.finalproject2customer.ItemActivity;
import com.example.finalproject2customer.ListAdapter;
import com.example.finalproject2customer.R;
import com.example.finalproject2customer.databinding.ActivityComputerBinding;

import java.util.ArrayList;

public class ComputerActivity extends AppCompatActivity {

    ActivityComputerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityComputerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.macbookair,R.drawable.macbookpro,R.drawable.rogstrix,R.drawable.tuf};
        String[] item = {"Macbook Air","Macbook Pro","Asus ROG Strix","Asus TUF"};
        String[] harga = {"6","16","23","26"};
        String[] tipe = {"Laptop","Laptop","Laptop","Laptop"};

        ArrayList<Item> itemArrayList = new ArrayList<>();

        for (int i = 0;i< imageId.length;i++){

            Item itemm = new Item(item[i],harga[i],tipe[i],imageId[i]);
            itemArrayList.add(itemm);

        }

        ListAdapter listAdapter = new ListAdapter(ComputerActivity.this, itemArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ComputerActivity.this, ItemActivity.class);
                i.putExtra("item",item[position]);
                i.putExtra("harga",harga[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}