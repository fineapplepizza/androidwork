package com.example.ex0723;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        layout = findViewById(R.id.layout);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent it_btn = new Intent(MainActivity.this,SubActivity.class);
        startActivityForResult(it_btn, 1001);
        // startActivity는 편도
        // startActivityforResult는 왕복
        // 1001: 요청코드값, 임의의 숫자

    }

    // 갔다 왔을 때 실행될 메소드 만들기
    // onActivityResult => 부모클래스인 AppcompatActivity 메소드 오버라이딩
    // alt+ insert => override Method => onActivityResult 입력(검색)=> 선택하고 엔터


    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // .nullable-생략가능하다(못본척하면됨)
        // 1.requestCode ==>요청코드값
        // 2.resultCode ==>결과코드값
        // 3.data => 데이터(색깔)가 담겨있는 intent

        if(requestCode == 1001 &&resultCode == RESULT_OK){

                String color = data.getStringExtra("color");
                Toast.makeText(getApplicationContext(),color,Toast.LENGTH_SHORT).show();

                layout.setBackgroundColor(Color.parseColor(color)); //설정을해준다 set 값을 가져온다 get
                // Color.parseColor => 색상코드값을 Color객체로 만들어줌

        }
    }
}