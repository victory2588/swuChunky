package com.java.swuchunky;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class wizard_reserve_listAdapter extends RecyclerView.Adapter<wizard_reserve_listAdapter.CustomViewHolder> {
    private ArrayList<wizard_main_Item> listCustom = new ArrayList<>();

    private ArrayList<wizard_main_Item> arrayList;
    private Context context;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    //메인에서 어댑터로 받아온 값
    public wizard_reserve_listAdapter(ArrayList<wizard_main_Item> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wizard_main_item, parent, false);
        //CustomViewHoler holder = new CustomViewHoler(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull wizard_reserve_listAdapter.CustomViewHolder holder, int position) {
        //holder.mname.setText(arrayList.get(position).getmname());
        //holder.mcontent.setText(arrayList.get(position).getmcontent());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        //리스트.xml 요소 아이디 연결
        TextView mname;
        TextView mcontent;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            //this.mname = itemView.findViewById(R.id.mname);
            //this.mcontent = itemView.findViewById(R.id.mcontent);
        }
    }
}