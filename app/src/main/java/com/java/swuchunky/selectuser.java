package com.java.swuchunky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class selectuser extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectuser);

        Button makeWizard_btn = (Button) findViewById(R.id.makeWizard_btn);
        makeWizard_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wizardMainActivity.class);
                startActivity(intent);
            }
        });

        Button makeFairy_btn = (Button) findViewById(R.id.makeFairy_btn);
        makeFairy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wizardMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
