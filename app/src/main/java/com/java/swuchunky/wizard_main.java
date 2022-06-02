package com.java.swuchunky;

import android.content.ClipData;
import android.content.Context;
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

    wizardMainActivity activity;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<wizard_main_Item> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    Spinner spinner;

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
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.wizard_main, container, false);
        RecyclerView recyclerview = (RecyclerView) view.findViewById(R.id.wizard_main_listView);
        recyclerview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager( getActivity().getApplicationContext());
        //recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); // 그룹 객체를 담을 어레이 리스트 (어댑터쪽으로)

        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동
        databaseReference = database.getReference(); // DB 테이블 연결

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

            }/*
        //값이 변경되는걸 감지하는 함수!
        databaseReference.child("reserve").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); // 기존 배열리스트가 존재하지않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    wizard_reserveview_Item wizard_reserview_Item = snapshot.getValue(wizard_reserveview_Item.class); //객체를 선언하여 데이터를 담기
                    arrayList.add(wizard_reserview_Item); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("wizardMainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }

            //adapter = new wizard_reserve_listAdapter(arrayList, this);
            //recyclerView.setAdapter(adapter); // 리사이클러뷰에 어댑터 연결*/
        });
        return view;
    }

}