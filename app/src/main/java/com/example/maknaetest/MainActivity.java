package com.example.maknaetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    // 하단 바를 위한 프레그먼트 선언.
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentCurtain fragmentCurtain = new FragmentCurtain();
    private FragmentTimer fragmentTimer = new FragmentTimer();
    private FragmentRecommend fragmentRecommend = new FragmentRecommend();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentCurtain).commitAllowingStateLoss();   // 첫 화면에서 커튼 프래그먼트 나오도록

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
        bottomNavigationView.setSelectedItemId(R.id.curtainItem);
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.curtainItem:
                    transaction.replace(R.id.frameLayout, fragmentCurtain).commitAllowingStateLoss();
                    break;
                case R.id.timerItem:
                    transaction.replace(R.id.frameLayout, fragmentTimer).commitAllowingStateLoss();
                    break;
                case R.id.recommendItem:
                    transaction.replace(R.id.frameLayout, fragmentRecommend).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}
