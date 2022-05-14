package com.java.swuchunky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedIntstance) {
        super.onCreate(savedIntstance);
        setContentView(R.layout.firstpage);

        Button firstpage_btn = (Button) findViewById(R.id.firstpage_btn);
        firstpage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), wizard_login.class);
                startActivity(intent);
            }
        });
    }
}