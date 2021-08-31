package com.example.ex0720;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_result = findViewById(R.id.tv_result);


        // 보내준 Intent 받아오기
        Intent it = getIntent();

        //intent안에 들어있는 데이터 꺼내기
        String id = it.getStringExtra("id");//원하는 자료형 Extra를 가져오면됨

        // textView에 전달받은 id 적어서 화면에 띄우기
        tv_result.setText(id + "님 환영합니다~~~"); //setText 글자를 쓸 때


    }
}