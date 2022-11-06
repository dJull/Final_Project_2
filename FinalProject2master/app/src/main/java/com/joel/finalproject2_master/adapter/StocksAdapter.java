package com.joel.finalproject2_master.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joel.finalproject2_master.R;
import com.joel.finalproject2_master.model.Stocks;

import java.util.List;

public class StocksAdapter extends RecyclerView.Adapter<StocksAdapter.MyViewHolder> {
    private Context context;
    private List<Stocks> list;
    private Dialog dialog;

    public interface Dialog{
        void onClick(int pos);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public StocksAdapter(Context context, List<Stocks> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data_stocks, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.idItem.setText(list.get(position).getId());
        holder.itemName.setText(list.get(position).getName());
        holder.qty.setText(list.get(position).getQty());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView idItem,itemName, qty;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idItem = itemView.findViewById(R.id.id);
            itemName = itemView.findViewById(R.id.namaItem);
            qty = itemView.findViewById(R.id.qtyItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }
}