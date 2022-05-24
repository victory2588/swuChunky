package com.java.swuchunky;


import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;


public class wizard_reserve1_sel extends AppCompatActivity {
    Button reservation1_next_btn;
    RadioButton rBtnCalendar, rBtnTime;
    CalendarView calView;
    TimePicker tPicker;
    int selectYear, selectMonth, selectDay,selectHour,selectMin;
    userAccount account;
    wizard_signup ws;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_reserve1_sel);

        String email=((userAccount)this.getApplication()).getEmail();
        Log.d("로그인 email",email);
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

        rBtnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        reservation1_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectHour=tPicker.getCurrentHour();
                selectMin=tPicker.getCurrentMinute();
                Toast.makeText(getApplicationContext(),
                        Integer.toString(selectYear)+"년 "+
                                Integer.toString(selectMonth)+"월 "+
                                Integer.toString(selectDay)+"일 "+
                                Integer.toString(selectHour)+"시 "+
                                Integer.toString(selectMin)+"분 저장됐습니다."
                ,  Toast.LENGTH_LONG).show();

                /*ws.accountRef.update("hour", tPicker.getCurrentHour().toString())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully updated!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error updating document", e);
                            }
                        });*/
                //userAccount account=(userAccount) getApplication();
                //account.setHour(selectHour);
                //db.collection("membership").document(account.getEmail()).set(account, SetOptions.merge());
                //Log.d("시간 추가", String.valueOf(account.getHour()));
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
