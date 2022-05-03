package com.java.swuchunky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.java.swuchunky.wizard.main_calendar.wizard_main;
import com.java.swuchunky.wizard.wizard_mypage;
import com.java.swuchunky.wizard.reserve.wizard_reserve;
import com.java.swuchunky.wizard.reserveview.wizard_reserveview;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_menu; //하단 네비게이션
    public Fragment wizard_main, wizard_mypage, wizard_reserve, wizard_reserveview; //네비게이션을 통해 이동할 프래그먼트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //하단 네비게이션 초기화
        bottom_menu = findViewById(R.id.bottom_menu);
        //하단 네비게이션 선택시 반응 리스너 설정
        bottom_menu.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);

        //처음 보일 프래그먼트
        getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_main).commit();

        //프래그먼트 객체 생성
        wizard_main = new wizard_main();
        wizard_mypage = new wizard_mypage();
        wizard_reserve = new wizard_reserve();
        wizard_reserveview = new wizard_reserveview();
    }


    public boolean onNavigationItemSelected (@NonNull MenuItem item) {
        int id = item.getItemId();
        //홈버튼 선택
        if (id == R.id.wizard_main) {
            getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_main).commit();
            return true;
        }
        //예약리스트 보기 선택
        if (id == R.id.wizard_reserveview) {
            getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_reserveview).commit();
            return true;
        }
        //검색(예약하기) 선택
        if (id == R.id.wizard_reserve) {
            getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_reserve).commit();
            return true;
        }
        //마이페이지 선택
        if (id == R.id.wizard_mypage) {
            getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_mypage).commit();
            return true;
        }
        return true;
    }
}