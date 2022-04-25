package com.java.swuchunky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class wizard_login extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TextView wizard_membership_txt;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_login);

        //로그인 버튼 클릭시 - 메인 이동
        Button wizard_login_btn = (Button) findViewById(R.id.wizard_login_btn);
        wizard_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wizard_main.class);
                startActivity(intent);
            }
        });

        //회원가입 텍스트뷰 클릭시 - 회원가입
        wizard_membership_txt = (TextView) findViewById(R.id.wizard_membership_txt);
        wizard_membership_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wizard_signup.class);
                startActivity(intent);
            }
        });
    }
}
