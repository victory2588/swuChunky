package com.java.swuchunky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    wizard_main wizard_main;
    wizard_mypage wizard_mypage;
    wizard_reserve wizard_reserve;
    wizard_reserveview wizard_reserveview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wizard_main = new wizard_main();
        wizard_mypage = new wizard_mypage();
        wizard_reserve = new wizard_reserve();
        wizard_reserveview = new wizard_reserveview();

        getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers,wizard_main).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigaitionview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.wizard_main:
                        getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_main).commit();
                        return true;
                    case R.id.wizard_reserveview:
                        getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_reserveview).commit();
                        return true;
                    case R.id.wizard_reserve:
                        getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_reserve).commit();
                        return true;
                    case R.id.wizard_mypage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_mypage).commit();
                        return true;
                }
                return false;
            }
        });
    }
}