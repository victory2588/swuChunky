package com.java.swuchunky;

import android.content.Intent;
import android.os.Bundle;
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


public class wizard_login extends AppCompatActivity {
    Button mLoginBtn;
    TextView wizard_membership_txt;
    EditText mEmailText, mPasswordText;
    private FirebaseAuth firebaseAuth;

    MainActivity activity;
    // @Override
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

                activity.onNavigationItemSelected(R.id.nav_wizard_main);

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.menu_containers, new wizard_main()).commit();

                /*String email = mEmailText.getText().toString().trim();
                String pwd = mPasswordText.getText().toString().trim();

               firebaseAuth.signInWithEmailAndPassword(email,pwd)
                        .addOnCompleteListener(wizard_login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    //Intent intent = new Intent(wizard_login.this, wizard_main.class);
                                    //startActivity(intent);
                                    FragmentManager fragmentManager = getSupportFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.menu_containers, new wizard_main()).commit();
                                }else{
                                    Toast.makeText(getApplicationContext(),"로그인 오류",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });*/
            }
        });
    }
}
