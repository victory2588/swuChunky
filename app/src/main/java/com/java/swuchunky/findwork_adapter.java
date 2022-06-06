package com.java.swuchunky;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class findwork_adapter extends RecyclerView.Adapter<findwork_adapter.CustomViewHolder> {
    private ArrayList<reservation_info> arrayList;
    private Context context;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    public findwork_adapter(ArrayList<reservation_info> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dobi_findwork_item,parent,false);
        CustomViewHolder holder=new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.email.setText(arrayList.get(position).getEmail());
        holder.category.setText(arrayList.get(position).getCategory());
        holder.date.setText(String.valueOf(arrayList.get(position).getWhen()));
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
        TextView email;
        Button apply;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView=itemView.findViewById(R.id.wizard_image);
            this.email=itemView.findViewById(R.id.wizard_name);
            this.category=itemView.findViewById(R.id.clean_category1);
            this.date=itemView.findViewById(R.id.clean_date1);
            this.request=itemView.findViewById(R.id.clean_request1);
            this.where=itemView.findViewById(R.id.clean_where1);
            this.apply=itemView.findViewById(R.id.test_btn);

            apply.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context.getApplicationContext(), "지원했습니다.", Toast.LENGTH_SHORT).show();
                    int position = getAdapterPosition ();
                    long a= getItemCount();
                    Log.d("위치", String.valueOf(a));
                    //databaseReference=database.getReference("wizard").child("reservation");
                }
            });
        }
    }
}
