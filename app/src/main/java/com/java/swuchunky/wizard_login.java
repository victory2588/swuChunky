package com.java.swuchunky;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class wizard_login extends AppCompatActivity {
    Button mLoginBtn;
    TextView wizard_membership_txt;
    EditText mEmailText, mPasswordText;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_login);

        firebaseAuth = FirebaseAuth.getInstance();
        //버튼 등록하기
        wizard_membership_txt = findViewById(R.id.wizard_membership_txt);
        mLoginBtn = findViewById(R.id.wizard_login_btn);
        mEmailText = findViewById(R.id.wizard_email_Insert);
        mPasswordText = findViewById(R.id.wizard_pw_Insert);


        //가입 버튼이 눌리면
        wizard_membership_txt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //intent함수를 통해 register액티비티 함수를 호출한다.
                startActivity(new Intent(getApplicationContext(), wizard_signup.class));

            }
        });

        //로그인 버튼이 눌리면
        mLoginBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String email = mEmailText.getText().toString().trim();
                String pwd = mPasswordText.getText().toString().trim();
                firebaseAuth.signInWithEmailAndPassword(email,pwd)
                        .addOnCompleteListener((Activity) getApplicationContext(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(getApplicationContext(), wizard_main.class);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(getApplicationContext(),"로그인 오류",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    /*protected void onCreate(@Nullable Bundle savedInstanceState) {
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
    }*/
    }
}
