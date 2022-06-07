package com.java.swuchunky;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class wizard_findwork extends Fragment {
    public static wizard_findwork newInstance() {
        return new wizard_findwork();
    }
    private RecyclerView recyclerView;
    private findwork_adapter adapter;
    private ArrayList<reservation_info> arrayList;
    private FirebaseAuth firebaseAuth;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        ViewGroup rootview=(ViewGroup) inflater.inflate(R.layout.dobi_findwork1, container, false);
        recyclerView=(RecyclerView)rootview.findViewById(R.id.dobi_main_listView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        arrayList=new ArrayList<>();

        databaseReference=database.getReference("wizard").child("reservation");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                reservation_info rvi=snapshot.getValue(reservation_info.class);
                arrayList.add(rvi);

                Log.d("데이터", String.valueOf(snapshot.getValue()));

                adapter=new findwork_adapter(arrayList,getActivity());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return rootview;
    }
}
