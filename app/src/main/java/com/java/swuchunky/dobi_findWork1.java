package com.java.swuchunky;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class dobi_findWork1 extends Fragment {
    /*private RecyclerView recyclerView;
    private findwork_adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<reservation_info> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;*/

    RecyclerView rv;
    findwork_adapter fadapter;
    List<reservation_info> rlist=new ArrayList<>();

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    public dobi_findWork1(){
    }

    public static dobi_findWork1 newInstance(){
        dobi_findWork1 fragment=new dobi_findWork1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.dobi_findwork1, container, false);


        return view;
    }
    /*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.dobi_findwork1, container, false);

        recyclerView=(RecyclerView)rootView.findViewById(R.id.dobi_main_listView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        arrayList=new ArrayList<>();

        database=FirebaseDatabase.getInstance();
        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();

        databaseReference=database.getReference().child("reservation");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot:datasnapshot.getChildren()){
                    reservation_info rv=snapshot.getValue(reservation_info.class);
                    arrayList.add(rv);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapter=new findwork_adapter(arrayList,getActivity());
        recyclerView.setAdapter(adapter);


        return rootView;
    }*/
}
