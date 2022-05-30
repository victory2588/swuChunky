package com.java.swuchunky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class selectuser extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectuser);

        ImageButton makeWizard_btn = (ImageButton) findViewById(R.id.makeWizard_btn);
        makeWizard_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wizard_signup.class);
                intent.putExtra("Whatrole","wizard");
                startActivity(intent);
            }
        });

        ImageButton makeFairy_btn = (ImageButton) findViewById(R.id.makeFairy_btn);
        makeFairy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wizard_signup.class);
                intent.putExtra("Whatrole","dobi");
                startActivity(intent);
            }
        });
    }
}
