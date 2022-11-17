package com.example.finalproject2customer.Clothing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.finalproject2customer.Item;
import com.example.finalproject2customer.ItemActivity;
import com.example.finalproject2customer.ListAdapter;
import com.example.finalproject2customer.R;
import com.example.finalproject2customer.databinding.ActivityTshirtBinding;

import java.util.ArrayList;

public class TshirtActivity extends AppCompatActivity {

    ActivityTshirtBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTshirtBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.blackshirt,R.drawable.greigeshirt,R.drawable.greyshirt,R.drawable.beigeshirt};
        String[] item = {"Black T-Shirt","Greige T-Shirt","Grey T-Shirt","Beige T-Shirt"};
        String[] harga = {"16","26","6","23"};
        String[] tipe = {"T-Shirt","T-Shirt","T-Shirt","T-Shirt"};

        ArrayList<Item> itemArrayList = new ArrayList<>();

        for (int i = 0;i< imageId.length;i++){

            Item itemm = new Item(item[i],harga[i],tipe[i],imageId[i]);
            itemArrayList.add(itemm);

        }

        ListAdapter listAdapter = new ListAdapter(TshirtActivity.this, itemArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(TshirtActivity.this, ItemActivity.class);
                i.putExtra("item",item[position]);
                i.putExtra("harga",harga[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}