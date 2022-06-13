package com.java.swuchunky;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class wizard_main_add extends FragmentActivity {
    Button wizard_add_btn;
    EditText mtime_add, mwhere_add,mdobiname_add,mwizardname_add,mrqst_add;
    String time_add,where_add,dobiname_add,wizardname_add,rqst_add,category;
    ImageButton living, move, sofa, animal,special, company, trash, toilet;
    private DatabaseReference firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    TextView living_txt;
    TextView move_txt;
    TextView sofa_txt;
    TextView animal_txt;
    TextView special_txt;
    TextView company_txt;
    TextView trash_txt;
    TextView toilet_txt;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_main_add);


        wizard_add_btn=(Button) findViewById(R.id.wizard_add_btn);
        mtime_add=findViewById(R.id.time_add);
        mwhere_add=findViewById(R.id.where_add);
        mdobiname_add = findViewById(R.id.dobiname_add);
        mwizardname_add=findViewById(R.id.wizardname_add);
        mrqst_add = findViewById(R.id.rqst_add);
        living_txt = findViewById(R.id.living_txt);
        move_txt = findViewById(R.id.move_txt);
        sofa_txt = findViewById(R.id.sofa_txt);
        animal_txt = findViewById(R.id.animal_txt);
        special_txt = findViewById(R.id.special_txt);
        company_txt = findViewById(R.id.company_txt);
        trash_txt = findViewById(R.id.trash_txt);
        toilet_txt = findViewById(R.id.toilet_txt);

        confirmed_reservation cv=new confirmed_reservation();
        firebaseDatabase= FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();


        wizard_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time_add=mtime_add.getText().toString().trim();
                where_add=mwhere_add.getText().toString().trim();
                dobiname_add=mdobiname_add.getText().toString().trim();
                wizardname_add=mwizardname_add.getText().toString().trim();
                rqst_add=mrqst_add.getText().toString().trim();

                cv.setTime(time_add);
                cv.setWhere(where_add);
                cv.setDobi_name(dobiname_add);
                cv.setWizard_name(wizardname_add);
                cv.setRequest(rqst_add);
                cv.setEmail(user.getEmail());

                firebaseDatabase.child("wizard").child("confirmed reservation").push().setValue(cv);

                Toast.makeText(getApplicationContext(), "일정이 추가되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), wizardMainActivity.class);
                startActivity(intent);
            }
        });
        living_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="생활청소";
                living_txt.setTextColor(Color.parseColor("#ff8da4"));
                cv.setImg("https://firebasestorage.googleapis.com/v0/b/swuchunky.appspot.com/o/living.png?alt=media&token=d0ea4948-5758-4be1-b016-c96d2d072b8d");
                cv.setCategory(category);
            }
        });
        move_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="이사청소";
                move_txt.setTextColor(Color.parseColor("#ff8da4"));
                cv.setImg("https://firebasestorage.googleapis.com/v0/b/swuchunky.appspot.com/o/move.png?alt=media&token=0b93ea57-ad28-48cc-9aec-0b07ebcf3b7f");
                cv.setCategory(category);
            }
        });
        sofa_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="가구.가전청소";
                sofa_txt.setTextColor(Color.parseColor("#ff8da4"));
                cv.setImg("https://firebasestorage.googleapis.com/v0/b/swuchunky.appspot.com/o/sofa.png?alt=media&token=038cf9de-b8b9-419b-a33c-57071ca33587");
                cv.setCategory(category);
            }
        });
        animal_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="반려동물";
                animal_txt.setTextColor(Color.parseColor("#ff8da4"));
                cv.setImg("https://firebasestorage.googleapis.com/v0/b/swuchunky.appspot.com/o/animal.png?alt=media&token=b2ff58a6-308c-4e36-9708-dd6d1ba81493");
                cv.setCategory(category);
            }
        });
        special_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="특수청소";
                special_txt.setTextColor(Color.parseColor("#ff8da4"));
                cv.setImg("https://firebasestorage.googleapis.com/v0/b/swuchunky.appspot.com/o/special.png?alt=media&token=bc22435f-e8ff-4bf0-a98c-9bd2cbd16ff1");
                cv.setCategory(category);
            }
        });
        company_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="사무실청소";
                company_txt.setTextColor(Color.parseColor("#ff8da4"));
                cv.setImg("https://firebasestorage.googleapis.com/v0/b/swuchunky.appspot.com/o/company.png?alt=media&token=bea32d32-09b2-477c-ab19-56034f9af855");
                cv.setCategory(category);
            }
        });
        trash_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="분리수거";
                trash_txt.setTextColor(Color.parseColor("#ff8da4"));
                cv.setImg("https://firebasestorage.googleapis.com/v0/b/swuchunky.appspot.com/o/trash.png?alt=media&token=0c8b0f00-1a44-4b84-b9ac-3a335dc545ed");
                cv.setCategory(category);
            }
        });
        toilet_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category="화장실";
                toilet_txt.setTextColor(Color.parseColor("#ff8da4"));
                cv.setImg("https://firebasestorage.googleapis.com/v0/b/swuchunky.appspot.com/o/toilet.png?alt=media&token=48594749-9aaf-4de8-9532-26c5ce918c5f");
                cv.setCategory(category);
            }
        });
    }

}
