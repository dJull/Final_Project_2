package com.example.finalproject2customer.Other;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.finalproject2customer.Clothing.TshirtActivity;
import com.example.finalproject2customer.Item;
import com.example.finalproject2customer.ItemActivity;
import com.example.finalproject2customer.ListAdapter;
import com.example.finalproject2customer.R;
import com.example.finalproject2customer.databinding.ActivityOtherBinding;

import java.util.ArrayList;

public class OtherActivity extends AppCompatActivity {

    ActivityOtherBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.cupglass,R.drawable.cuppapper,R.drawable.cupplastic,R.drawable.cupwood};
        String[] item = {"Glass Cup","Papper Cup","Plastic Cup","Wood Cup"};
        String[] harga = {"161","216","86","231"};
        String[] tipe = {"Appliances","Appliances","Appliances","Appliances"};

        ArrayList<Item> itemArrayList = new ArrayList<>();

        for (int i = 0;i< imageId.length;i++){

            Item itemm = new Item(item[i],harga[i],tipe[i],imageId[i]);
            itemArrayList.add(itemm);

        }

        ListAdapter listAdapter = new ListAdapter(OtherActivity.this, itemArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(OtherActivity.this, ItemActivity.class);
                i.putExtra("item",item[position]);
                i.putExtra("harga",harga[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}