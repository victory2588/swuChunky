package com.java.swuchunky;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class wizard_reserve1_sel extends AppCompatActivity {
    final int DIALOG_DATE = 1;
    final int DIALOG_TIME = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_reserve1_sel);

        Button reservation1_datebtn = (Button)findViewById(R.id.reservation1_datebtn);
        Button reservation1_timebtn = (Button)findViewById(R.id.reservation1_timebtn);

        reservation1_datebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DIALOG_DATE); // 날짜 설정 다이얼로그 띄우기
            }
        });
        reservation1_timebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DIALOG_TIME);
            }
        });
    } // end of onCreate

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        switch(id){
            case DIALOG_DATE :
                DatePickerDialog dpd = new DatePickerDialog
                        (wizard_reserve1_sel.this, // 현재화면의 제어권자
                                new DatePickerDialog.OnDateSetListener() {
                                    public void onDateSet(DatePicker view,
                                                          int year, int monthOfYear, int dayOfMonth) {
                                        Toast.makeText(getApplicationContext(),
                                                year+"년 "+(monthOfYear+1)+"월 "+dayOfMonth+"일 을 선택했습니다",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                                , // 사용자가 날짜설정 후 다이얼로그 빠져나올때
                                //    호출할 리스너 등록
                                2015, 6, 21); // 기본값 연월일
                return dpd;
            case DIALOG_TIME :
                TimePickerDialog tpd =
                        new TimePickerDialog(wizard_reserve1_sel.this,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view,
                                                          int hourOfDay, int minute) {
                                        Toast.makeText(getApplicationContext(),
                                                hourOfDay +"시 " + minute+"분 을 선택했습니다",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }, // 값설정시 호출될 리스너 등록
                                4,19, false); // 기본값 시분 등록
                // true : 24 시간(0~23) 표시
                // false : 오전/오후 항목이 생김
                return tpd;
        }


        return super.onCreateDialog(id);
    }
}
