package com.example.finalproject2customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject2customer.databinding.ActivityItemBinding;
import com.google.android.material.button.MaterialButton;

public class ItemActivity extends AppCompatActivity {

    ActivityItemBinding binding;
    MaterialButton belibtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        belibtn = findViewById(R.id.belibtn);

        belibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemActivity.this,"Barang Dimasukan Dalam Keranjang",Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = this.getIntent();

        if (intent != null){

            String item = intent.getStringExtra("item");
            String harga = intent.getStringExtra("harga");
            int imageid = intent.getIntExtra("imageid",R.drawable.blackshirt);

            binding.nama1.setText(item);
            binding.harga1.setText(harga);
            binding.foto1.setImageResource(imageid);

        }

    }

}
