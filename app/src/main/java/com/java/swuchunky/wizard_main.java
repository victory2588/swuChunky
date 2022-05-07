package com.java.swuchunky;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import com.java.swuchunky.MainActivity;
import com.java.swuchunky.R;

import java.util.Calendar;

public class wizard_main extends Fragment {
//    private HomeViewModel homeViewModel;
//    private FragmentHomeBinding binding;

    //메인 액티비티 객체 선언
    MainActivity activity;

    TextView dateText;
    CalendarView calendarView;
    Calendar calendar;

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment

        //뷰 넘어가는 부분
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.wizard_main, container, false);

        MainActivity activity = (MainActivity) getActivity();
        //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.menu_containers, new wizard_main()).commit();

        //캘린더 내의 리스트
        final String[] LIST = {"List1", "List2", "List3", "List4", "List5", "List6", "List7"};
        ListView listView = (ListView) view.findViewById(R.id.wizard_main_listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.wizard_mainitem, R.id.textList, LIST);
        listView.setAdapter(adapter);

        //캘린더 뷰 선언
        calendar = Calendar.getInstance();
        dateText = (TextView)view.findViewById(R.id.date);
        calendarView = (CalendarView) view.findViewById(R.id.wizard_main_calendarView);

        String date = calendar.get(Calendar.YEAR) + "년 " + (calendar.get(Calendar.MONTH)+1) + "월 " + calendar.get(Calendar.DAY_OF_MONTH) + "일";
        dateText.setText(date);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "년 " + (month+1) + "월 " + dayOfMonth + "일";
                dateText.setText(date);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }
}