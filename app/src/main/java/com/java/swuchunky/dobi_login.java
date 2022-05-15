/*package com.java.swuchunky;

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


public class dobi_login extends AppCompatActivity {
    Button mLoginBtn;
    TextView wizard_membership_txt;
    EditText mEmailText, mPasswordText;
    String role;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dobi_login);

        //버튼 등록하기
        wizard_membership_txt = findViewById(R.id.dobi_membership_txt);
        mLoginBtn = findViewById(R.id.dobi_login_btn);
        mEmailText = findViewById(R.id.dobi_email_Insert);
        mPasswordText = findViewById(R.id.dobi_pw_Insert);


        //가입 버튼이 눌리면
        wizard_membership_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent함수를 통해 register액티비티 함수를 호출한다.
                startActivity(new Intent(getApplicationContext(), dobi_signup.class));
            }
        });

        //로그인 버튼이 눌리면
        mLoginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = mEmailText.getText().toString().trim();
                String pwd = mPasswordText.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(email,pwd)
                        .addOnCompleteListener(dobi_login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(dobi_login.this, wizardMainActivity.class); //getApplicationContext()
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(),"요정님 환영합니다!",Toast.LENGTH_SHORT).show();

                                    /*database = FirebaseDatabase.getInstance();
                                    databaseReference=database.getReference("membership");
                                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                                        FirebaseUser user = firebaseAuth.getCurrentUser();
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            for (DataSnapshot postSnapshot: snapshot.getChildren()){
                                                String key = postSnapshot.getKey();
                                                if(key==user.getUid()){
                                                    userAccount account=snapshot.getValue(userAccount.class);
                                                    role=account.getRole().trim();
                                                }
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {
                                            Toast.makeText(getApplicationContext(), "데이터 가져오기 실패", Toast.LENGTH_LONG).show();
                                        }
                                    });

                                    if(role=="wizard"){
                                        Intent intent = new Intent(wizard_login.this, wizardMainActivity.class); //getApplicationContext()
                                        startActivity(intent);
                                        Toast.makeText(getApplicationContext(),"마법사님 환영합니다!",Toast.LENGTH_SHORT).show();
                                    }else{
                                        Intent intent = new Intent(wizard_login.this, wizardMainActivity.class); //getApplicationContext()
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

*/
