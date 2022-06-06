package com.java.swuchunky;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class wizard_reserve3 extends AppCompatActivity{
    private FirebaseAuth firebaseAuth;
    private DatabaseReference firebaseDatabase;
    ImageButton living, move, sofa, animal,special, company, trash, toilet;
    Button reservation_uploadbtn;
    EditText mrequest,maddress;
    private String request,category,when,address;

    TextView living_txt;
    TextView move_txt;
    TextView sofa_txt;
    TextView animal_txt;
    TextView special_txt;
    TextView company_txt;
    TextView trash_txt;
    TextView toilet_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_reserve3);

        reservation_uploadbtn = (Button) findViewById(R.id.reservation3_uploadbtn);
        living = (ImageButton) findViewById(R.id.reservation3_living);
        move = (ImageButton) findViewById(R.id.reservation3_move);
        sofa = (ImageButton) findViewById(R.id.reservation3_sofa);
        animal = (ImageButton) findViewById(R.id.reservation3_animal);
        special = (ImageButton) findViewById(R.id.reservation3_special);
        company = (ImageButton) findViewById(R.id.reservation3_company);
        trash = (ImageButton) findViewById(R.id.reservation3_trash);
        toilet = (ImageButton) findViewById(R.id.reservation3_toilet);
        mrequest= findViewById(R.id.wizard_reserve_rqt);
        maddress=findViewById(R.id.wizard_reserve_address);
        living_txt = findViewById(R.id.living_txt);
        move_txt = findViewById(R.id.move_txt);
        sofa_txt = findViewById(R.id.sofa_txt);
        animal_txt = findViewById(R.id.animal_txt);
        special_txt = findViewById(R.id.special_txt);
        company_txt = findViewById(R.id.company_txt);
        trash_txt = findViewById(R.id.trash_txt);
        toilet_txt = findViewById(R.id.toilet_txt);

        reservation_info rv=new reservation_info();
        firebaseDatabase= FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();

        reservation_uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reservation_info rv=new reservation_info();
                request=mrequest.getText().toString().trim();
                address=maddress.getText().toString().trim();
                rv.setRequest(request);
                rv.setWhere(address);
                rv.setCategory(category);

                when= getIntent().getStringExtra("when").trim();
                rv.setWhen(when);
                rv.setEmail(user.getEmail());
                firebaseDatabase.child("wizard").child("reservation").push().setValue(rv);

                Toast.makeText(getApplicationContext(), "예약 완료됐습니다..", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), wizardMainActivity.class);
                startActivity(intent);
            }
        });
        living.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="생활청소";
                living_txt.setTextColor(Color.parseColor("#ff8da4"));
            }
        });
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="이사청소";
                move_txt.setTextColor(Color.parseColor("#ff8da4"));
            }
        });
        sofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="가구.가전청소";
                sofa_txt.setTextColor(Color.parseColor("#ff8da4"));
            }
        });
        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="반려동물";
                animal_txt.setTextColor(Color.parseColor("#ff8da4"));
            }
        });
        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="특수청소";
                special_txt.setTextColor(Color.parseColor("#ff8da4"));
            }
        });
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="사무실청소";
                company_txt.setTextColor(Color.parseColor("#ff8da4"));
            }
        });
        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="분리수거";
                trash_txt.setTextColor(Color.parseColor("#ff8da4"));
            }
        });
        toilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="화장실";
                toilet_txt.setTextColor(Color.parseColor("#ff8da4"));
                }
        });

    }

}
