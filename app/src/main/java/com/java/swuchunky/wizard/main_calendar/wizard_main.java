package com.java.swuchunky.wizard.main_calendar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import com.java.swuchunky.R;

import java.util.Calendar;

public class wizard_main extends Fragment {
//    private HomeViewModel homeViewModel;
//    private FragmentHomeBinding binding;

    TextView dateText;
    CalendarView calendarView;
    Calendar calendar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();

        View view = inflater.inflate(R.layout.wizard_main, container, false);

        final String[] LIST = {"List1", "List2", "List3", "List4", "List5", "List6", "List7"};
        ListView listView = (ListView) view.findViewById(R.id.wizard_main_listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.wizard_mainitem, R.id.textList, LIST);
        listView.setAdapter(adapter);

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
        //return inflater.inflate(R.layout.wizard_main, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }
    //public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
   //     super.onViewCreated(view, savedInstanceState);
   // }
}