package com.java.swuchunky;


import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;


public class wizard_reserve1_sel extends FragmentActivity {
    Button reservation1_next_btn;
    RadioButton rBtnCalendar, rBtnTime;
    CalendarView calView;
    TimePicker tPicker;
    int selectYear, selectMonth, selectDay,selectHour,selectMin;
    private DatabaseReference firebaseDatabase;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_reserve1_sel);

        firebaseDatabase=FirebaseDatabase.getInstance().getReference();

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
                ,  Toast.LENGTH_SHORT).show();


                FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
                reservation_info rv=new reservation_info();

                rv.setEmail(user.getEmail());
                rv.setYear(selectYear);
                rv.setMonth(selectMonth);
                rv.setDay(selectDay);
                rv.setHour(selectHour);
                rv.setMin(selectMin);

                firebaseDatabase.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        firebaseDatabase.child(user.getUid()).child("reservation").push().setValue(rv);
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

                Log.d("로그인 정보",user.getEmail());

                Intent intent = new Intent(getApplicationContext(), wizard_reserve3.class);
                startActivity(intent);
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
