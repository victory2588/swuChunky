package com.java.swuchunky;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.java.swuchunky.MainActivity;
import com.java.swuchunky.R;
//import com.prolificinteractive.materialcalendarview.CalendarDay;
//import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;
import java.util.Calendar;

public class wizard_main extends Fragment {
    public static wizard_main newInstance() {
        return new wizard_main();
    }

    wizardMainActivity activity;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter sAdapter;
    private wizard_main_add_adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<confirmed_reservation> arrayList;
    Spinner spinner;
    Button add_schedule;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (wizardMainActivity) getActivity();
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
        //뷰 넘어가는 부분
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.wizard_main, container, false);recyclerView = (RecyclerView) view.findViewById(R.id.wizard_main_listView);
        recyclerView=(RecyclerView)view.findViewById(R.id.wizard_main_listView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        arrayList = new ArrayList<>(); // 그룹 객체를 담을 어레이 리스트 (어댑터쪽으로)

        add_schedule=(Button)view.findViewById(R.id.add_schedule);

        add_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), wizard_main_add.class);
                startActivity(intent);
            }
        });

        databaseReference=database.getReference("wizard").child("confirmed reservation");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                confirmed_reservation cv=snapshot.getValue(confirmed_reservation.class);
                arrayList.add(cv);

                Log.d("데이터", String.valueOf(snapshot.getValue()));

                adapter=new wizard_main_add_adapter(arrayList,getActivity());
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

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.month, android.R.layout.simple_spinner_dropdown_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); spinner.setAdapter(monthAdapter);

        //스피너
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //날짜별로 리스트 정보 뜸wizard_main_item //리스트 어댑터 wizardmainAdapter //리스트에서 또 팝업 정의필요wizard_main2
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

}