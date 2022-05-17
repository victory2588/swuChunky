package com.java.swuchunky;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;

public class wizard_main extends Fragment {

    wizardMainActivity activity;

    TextView dateText;
    Calendar calendar;
    private MaterialCalendarView calendarView;

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
                             @Nullable Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment

        //뷰 넘어가는 부분
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.wizard_main, container, false);
        calendarView = view.findViewById(R.id.wizard_main_calendarView);
        calendarView.setSelectedDate(CalendarDay.today());

        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}