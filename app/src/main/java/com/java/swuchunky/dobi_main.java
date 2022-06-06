package com.java.swuchunky;

import android.content.Context;
import android.os.Bundle;
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
import androidx.recyclerview.widget.RecyclerView;

public class dobi_main  extends Fragment {
    dobiMainActivity activity;
    //wizardAdapter adapter;
    RecyclerView recyclerView;
    //Spinner spinner;


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
        //뷰 넘어가는 부분
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.dobi_main, container, false);

        //adapter = new wizardAdapter();
        RecyclerView recyclerview = (RecyclerView) view.findViewById(R.id.dobi_main_listView);
        // listView.setAdapter(adapter);

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
