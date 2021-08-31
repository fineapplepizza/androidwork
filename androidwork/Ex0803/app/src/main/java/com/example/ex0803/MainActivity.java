package com.example.ex0803;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv; //메뉴
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 메뉴는 findviewById 한다.
        bnv = findViewById(R.id.bottombar);

        // Fragment 들은 객체 생성한다.
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,fragment1).commit();//초기셋팅값 지정


        // bottomNavigationBar 에서 어떤 메뉴가 선택됐는지 감지한다.
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                // 매개변수 item => 내가 선택한 메뉴
                switch(item.getItemId()){ // 내가 선택한 메뉴의 Id가
                    case R.id.tab1: // tab1이라면
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container,fragment1).commit();
                        //R.id.container 자리에 fragment1을 끼우겠다!

                        break;
                    case R.id.teb2: // tab2라면
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container,fragment2).commit();

                        break;
                    case R.id.tab3: // tab3라면
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container,fragment3).commit();

                        break;

                    case R.id.tab4: // tab4라면
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container,fragment4).commit();

                        break;

                }

                return true;// false가 아닌 true로해야 아이콘이 바뀜

                //뷰 페이저 구현
            }
        });



    }
}