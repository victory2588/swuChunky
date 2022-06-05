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

public class selectlogin extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectlogin);

        ImageButton beWizard_btn = (ImageButton) findViewById(R.id.beWizard_btn);
        beWizard_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wizard_login.class);
                intent.putExtra("Whatrole","wizard");
                startActivity(intent);
            }
        });

        ImageButton beFairy_btn = (ImageButton) findViewById(R.id.beFairy_btn);
        beFairy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wizard_login.class);
                intent.putExtra("Whatrole","dobi");
                startActivity(intent);
            }
        });
    }
}
