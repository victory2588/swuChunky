package com.java.swuchunky;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class wizardMainActivity extends FragmentActivity {

    wizard_main wmain;

    private BottomNavigationView bottom_menu; //하단 네비게이션
    private Fragment wizard_main, wizard_mypage, wizard_reserve, wizard_reserveview; //네비게이션을 통해 이동할 프래그먼트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_activity_main); //프래그먼트 화면

        //하단 네비게이션 초기화
        bottom_menu = findViewById(R.id.bottom_menu);

        wizard_main = new wizard_main();
        wizard_mypage = new wizard_mypage();
        wizard_reserve = new wizard_reserve();
        wizard_reserveview = new wizard_reserveview();


        //제일 처음 띄워주는 프래그먼트
        FragmentManager fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_main).commit();


    bottom_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
        //변경이유 : 액티비티 값 전달 때문에(중첩, 초기화 방지)
        @Override
        public boolean onNavigationItemSelected (@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            int id = item.getItemId();
            //홈버튼 선택
            if (id == R.id.nav_wizard_main) { //R.id.nav_wizard_main
                getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_main).commit();
                return true;
            }
            //예약리스트 보기 선택
            if (id == R.id.nav_wizard_reserveview) {
                getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_reserveview).commit();
                return true;
            }
            //검색(예약하기) 선택
            if (id == R.id.nav_wizard_reserve) {
                getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_reserve).commit();
                return true;
            }
            //마이페이지 선택
            if (id == R.id.nav_wizard_mypage) {
                getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, wizard_mypage).commit();
                return true;
            }
            return true;
        }
    });
    }
}
