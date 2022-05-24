package com.java.swuchunky;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class wizard_reserve1_sel extends AppCompatActivity {
    Button reservation1_next_btn;
    RadioButton rBtnCalendar, rBtnTime;
    CalendarView calView;
    TimePicker tPicker;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_reserve1_sel);

        reservation1_next_btn = (Button) findViewById(R.id.reservation1_next_btn);

        rBtnCalendar = (RadioButton) findViewById(R.id.rBtnCalendar);
        rBtnTime = (RadioButton) findViewById(R.id.rBtnTime);

        tPicker = (TimePicker) findViewById(R.id.reserve_timePicker);
        calView = (CalendarView) findViewById(R.id.reserve_calendarVeiw);

        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rBtnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calView.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
            }
        });

        reservation1_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        Integer.toString(selectYear)+"년 "+
                                Integer.toString(selectMonth)+"월 "+
                                Integer.toString(selectDay)+"일 "+
                                Integer.toString(tPicker.getCurrentHour())+"시 "+
                                Integer.toString(tPicker.getCurrentMinute())+"분 저장됐습니다."
                ,  Toast.LENGTH_LONG).show();
            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;
            }
        });
    }
}
