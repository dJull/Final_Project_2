package com.example.finalproject2customer.Book;

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
import com.example.finalproject2customer.databinding.ActivityBookBinding;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    ActivityBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.sejarahsumatra,R.drawable.sejarahindo,R.drawable.sejarahdunia,R.drawable.matematika};
        String[] item = {"Sejarah Sumatra","Sejarah Indonesia","Sejarah Dunia","Matematika Teknik"};
        String[] harga = {"116","126","86","123"};
        String[] tipe = {"Pendidikan","Pendidikan","Pendidikan","Pendidikan"};

        ArrayList<Item> itemArrayList = new ArrayList<>();

        for (int i = 0;i< imageId.length;i++){

            Item itemm = new Item(item[i],harga[i],tipe[i],imageId[i]);
            itemArrayList.add(itemm);

        }

        ListAdapter listAdapter = new ListAdapter(BookActivity.this, itemArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(BookActivity.this, ItemActivity.class);
                i.putExtra("item",item[position]);
                i.putExtra("harga",harga[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}