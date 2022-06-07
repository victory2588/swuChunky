package com.java.swuchunky;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class dobi_main  extends Fragment {
    public static dobi_main newInstance() {
        return new dobi_main();
    }
    dobiMainActivity activity;
    private RecyclerView recyclerView;
    private dobi_main_adapter adapter;
    private ArrayList<confirmed_reservation> arrayList;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (dobiMainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.dobi_main, container, false);

        recyclerView=(RecyclerView)view.findViewById(R.id.dobi_main_listView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        arrayList = new ArrayList<>();

        databaseReference=database.getReference("wizard").child("confirmed reservation");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                confirmed_reservation cv=snapshot.getValue(confirmed_reservation.class);
                arrayList.add(cv);

                Log.d("데이터", String.valueOf(snapshot.getValue()));

                adapter=new dobi_main_adapter(arrayList,getActivity());
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

        Spinner spinner = (Spinner) view.findViewById(R.id.dobi_spinner);
        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.month, android.R.layout.simple_spinner_dropdown_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); spinner.setAdapter(monthAdapter);

        //스피너
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //날짜별로 리스트 정보 뜸wizard_main_item //리스트 어댑터 wizardlistAdapter //리스트에서 또 팝업 정의필요wizard_main2
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }
}
