package com.java.swuchunky;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dobiMainActivity extends FragmentActivity {
    dobi_main dmain;

    private BottomNavigationView dobi_menu; //하단 네비게이션
    private Fragment dobi_main, dobi_mypage, dobi_ChatRoomFragment, dobi_findWork1; //네비게이션을 통해 이동할 프래그먼트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dobi_activity_main); //프래그먼트 화면

        //하단 네비게이션 초기화
        dobi_menu = findViewById(R.id.dobi_menu);

        dobi_main = new dobi_main();
        dobi_mypage = new dobi_mypage();
        dobi_ChatRoomFragment = new dobi_ChatRoomFragment();
        dobi_findWork1 = new dobi_findWork1();


        //제일 처음 띄워주는 프래그먼트
        FragmentManager fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, dobi_main).commit();


        dobi_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            //변경이유 : 액티비티 값 전달 때문에(중첩, 초기화 방지)
            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();

                int id = item.getItemId();
                //홈버튼 선택
                if (id == R.id.nav_dobi_main) { //R.id.nav_wizard_main
                    getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, dobi_main).commit();
                    return true;
                }
                //예약리스트 보기 선택
                if (id == R.id.nav_dobi_apply) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, dobi_ChatRoomFragment).commit();
                    return true;
                }
                //검색(예약하기) 선택
                if (id == R.id.nav_dobi_findWork1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, dobi_findWork1).commit();
                    return true;
                }
                //마이페이지 선택
                if (id == R.id.nav_dobi_mypage) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.menu_containers, dobi_mypage).commit();
                    return true;
                }
                return true;
            }
        });
    }
    public void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.menu_containers, fragment).commit();
    }
}
