package com.java.swuchunky;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class dobi_ceritified extends Fragment {
    private RecyclerView recyclerView;
    private findwork_adapter adapter;
    private ArrayList<reservation_info> arrayList;
    private FirebaseAuth firebaseAuth;
    private ChildEventListener childEventListener;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        ViewGroup rootview=(ViewGroup) inflater.inflate(R.layout.dobi_ceritified, container, false);
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
                recyclerView.scrollToPosition(arrayList.size()-1);
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
/*reservation_info rvi=snapshot.getValue(reservation_info.class);
                arrayList.add(rvi);

                Log.d("데이터", String.valueOf(snapshot.getValue()));

                adapter=new findwork_adapter(arrayList,getActivity());
                recyclerView.setAdapter(adapter);
                recyclerView.scrollToPosition(arrayList.size()-1);
                adapter.notifyDataSetChanged();*/