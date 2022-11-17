package com.example.finalproject2customer.Admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject2customer.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddStockActivity extends AppCompatActivity {
    private Button btnUpdate;
    private EditText item_id,item_name, item_quantity;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ProgressDialog progressDialog;
    private String id="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);
        item_id=findViewById(R.id.itemId);
        item_name=findViewById(R.id.itemName);
        item_quantity=findViewById(R.id.quantityStock);
        btnUpdate=findViewById(R.id.btnUpdate);

        progressDialog=new ProgressDialog(AddStockActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan tunggu");
        progressDialog.setCancelable(false);

        btnUpdate.setOnClickListener(v->{
            if (item_name.getText().length()>0 && item_quantity.getText().length()>0) {
                addStocks(item_id.getText().toString(),item_name.getText().toString(), item_quantity.getText().toString());
            }else{
                Toast.makeText(getApplicationContext(), "Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = getIntent();
        if (intent!=null){
            id = intent.getStringExtra("id");
            item_id.setText(intent.getStringExtra("item_id"));
            item_name.setText(intent.getStringExtra("item_name"));
            item_quantity.setText(intent.getStringExtra("item_qty"));
        }
    }

    private void addStocks(String ID,String name,String quantity){
        Map<String, Object> stocks=new HashMap<>();
        stocks.put("item_id",ID);
        stocks.put("item_name",name);
        stocks.put("item_qty",quantity);
        progressDialog.show();
        db.collection("stocks").document(ID)
                .set(stocks)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Berhasil mengupdate data", Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(), "Gagal mengupdate data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
