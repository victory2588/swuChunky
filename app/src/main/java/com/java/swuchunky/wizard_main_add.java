package com.java.swuchunky;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class wizard_main_add extends FragmentActivity {
    Button wizard_add_btn;
    EditText mcategory_add, mtime_add, mwhere_add,mdobiname_add,mrqst_add;
    String category_add,time_add,where_add,dobiname_add,rqst_add;
    private DatabaseReference firebaseDatabase;
    private FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_main_add);

        wizard_add_btn=(Button) findViewById(R.id.wizard_add_btn);
        mcategory_add= findViewById(R.id.category_add);
        mtime_add=findViewById(R.id.time_add);
        mwhere_add=findViewById(R.id.where_add);
        mdobiname_add = findViewById(R.id.dobiname_add);
        mrqst_add = findViewById(R.id.rqst_add);

        confirmed_reservation cv=new confirmed_reservation();
        firebaseDatabase= FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();


        wizard_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category_add=mcategory_add.getText().toString().trim();
                time_add=mtime_add.getText().toString().trim();
                where_add=mtime_add.getText().toString().trim();
                dobiname_add=mdobiname_add.getText().toString().trim();
                rqst_add=mrqst_add.getText().toString().trim();

                cv.setCategory(category_add);
                cv.setTime(time_add);
                cv.setWhere(where_add);
                cv.setName(dobiname_add);
                cv.setRequest(rqst_add);
                cv.setEmail(user.getEmail());

                firebaseDatabase.child("wizard").child("confirmed reservation").push().setValue(cv);

                Toast.makeText(getApplicationContext(), "일정이 추가되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), wizardMainActivity.class);
                startActivity(intent);
            }
        });
    }

}
