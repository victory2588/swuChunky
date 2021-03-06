package com.java.swuchunky;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class wizard_signup extends AppCompatActivity {
    private static final String TAG = "wizard_signup";
    EditText EmailText, PasswordText, PasswordcheckText, Name;
    Button registerBtn;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_signup);

        //파이어베이스 접근 설정
        firebaseAuth =  FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance().getReference();

        Name = findViewById(R.id.membership_name_txt);
        EmailText = findViewById(R.id.membership_email_txt);
        PasswordText = findViewById(R.id.membership_pw_txt);
        PasswordcheckText = findViewById(R.id.mebership_pwconfirm_txt);
        registerBtn = findViewById(R.id.wizard_membership_btn);

        //가입버튼 클릭리스너   -->  firebase에 데이터를 저장한다.
        registerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //가입 정보 가져오기
                String name = Name.getText().toString().trim();
                String email = EmailText.getText().toString().trim();
                String pwd = PasswordText.getText().toString().trim();
                String pwdcheck = PasswordcheckText.getText().toString().trim();
                Intent intent=getIntent();
                String role=intent.getStringExtra("Whatrole").trim();


                if(pwd.equals(pwdcheck)) {
                    Log.d(TAG, "등록 버튼 " + email + " , " + pwd);
                    final ProgressDialog mDialog = new ProgressDialog(wizard_signup.this);
                    mDialog.setMessage("가입중입니다...");
                    mDialog.show();

                    //파이어베이스에 신규계정 등록하기
                    firebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(wizard_signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //가입 성공시
                            if (task.isSuccessful()) {
                                mDialog.dismiss();
                                FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
                                userAccount account=new userAccount();

                                account.setIdToken(user.getUid());
                                account.setEmail(user.getEmail());
                                account.setName(name);
                                account.setPwd(pwd);
                                account.setRole(role);

                                if(role.equals("dobi")){
                                    firebaseDatabase.child("dobi").child("user").child(user.getUid()).setValue(account);
                                }
                                else{
                                    firebaseDatabase.child("wizard").child("user").child(user.getUid()).setValue(account);
                                }

                                Intent i = new Intent(wizard_signup.this, selectlogin.class);
                                startActivity(i);
                                finish();
                                Toast.makeText(getApplicationContext(), "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                mDialog.dismiss();
                                Toast.makeText(getApplicationContext(), "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                return;  //해당 메소드 진행을 멈추고 빠져나감.
                            }
                        }
                    });

                    //비밀번호 오류시
                }else{
                    Toast.makeText(getApplicationContext(), "비밀번호가 틀렸습니다. 다시 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();; // 뒤로가기 버튼이 눌렸을시
        return super.onSupportNavigateUp(); // 뒤로가기 버튼
    }
}




