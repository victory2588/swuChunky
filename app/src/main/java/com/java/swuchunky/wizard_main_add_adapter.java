package com.java.swuchunky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class wizard_main_add_adapter extends RecyclerView.Adapter<wizard_main_add_adapter.CustomViewHolder> {
    private ArrayList<confirmed_reservation> arrayList;
    private Context context;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    public wizard_main_add_adapter(ArrayList<confirmed_reservation> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.wizard_main_item,parent,false);
        CustomViewHolder holder=new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Glide.with(holder.itemView).load(arrayList.get(position).getImg()).into(holder.imageView);
        holder.dobi_name.setText(arrayList.get(position).getDobi_name());
        holder.category.setText(arrayList.get(position).getCategory());
        holder.date.setText(String.valueOf(arrayList.get(position).getTime()));
        holder.request.setText(arrayList.get(position).getRequest());
        holder.where.setText(arrayList.get(position).getWhere());
    }

    @Override
    public int getItemCount() {
        return arrayList != null ? arrayList.size():0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView category;
        TextView date;
        TextView request;
        TextView where;
        TextView dobi_name;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView=itemView.findViewById(R.id.wizard_image);
            this.dobi_name=itemView.findViewById(R.id.dobi_name);
            this.category=itemView.findViewById(R.id.clean_info_txt);
            this.date=itemView.findViewById(R.id.clean_info1_txt);
            this.request=itemView.findViewById(R.id.clean_info2_txt);
            this.where=itemView.findViewById(R.id.clean_info3_txt);
        }
    }
}
