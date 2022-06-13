package com.java.swuchunky;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import android.app.Fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class wizard_login extends AppCompatActivity {
    Button mLoginBtn;
    TextView wizard_membership_txt;
    EditText mEmailText, mPasswordText;
    String role,email,pwd;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_login);

        firebaseAuth =  FirebaseAuth.getInstance();

        //버튼 등록하기
        wizard_membership_txt = findViewById(R.id.wizard_membership_txt);
        mLoginBtn = findViewById(R.id.wizard_login_btn);
        mEmailText = findViewById(R.id.wizard_email_Insert);
        mPasswordText = findViewById(R.id.wizard_pw_Insert);

        Intent intent=getIntent();
        String role=intent.getStringExtra("Whatrole").trim();
        Log.d("역할정보",role);

        //가입 버튼이 눌리면
        wizard_membership_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent함수를 통해 register액티비티 함수를 호출한다.
                startActivity(new Intent(getApplicationContext(), selectuser.class));
            }
        });

        //로그인 버튼이 눌리면
        mLoginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                email = mEmailText.getText().toString().trim();
                pwd = mPasswordText.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(email,pwd)
                        .addOnCompleteListener(wizard_login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    if(role.equals("wizard")){
                                        Intent intent = new Intent(wizard_login.this, wizardMainActivity.class); //getApplicationContext()
                                        startActivity(intent);
                                        Toast.makeText(getApplicationContext(),"마법사님 환영합니다!",Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Intent intent = new Intent(wizard_login.this, dobiMainActivity.class); //getApplicationContext()
                                        startActivity(intent);
                                        Toast.makeText(getApplicationContext(),"요정님 환영합니다!",Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(getApplicationContext(),"로그인 오류",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
