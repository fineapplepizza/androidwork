package com.example.ex0728;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add extends AppCompatActivity implements View.OnClickListener {
    Button btn_plus;//추가하기 버튼
    EditText edt_title, edt_url; // 제목, 주소

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btn_plus = findViewById(R.id.btn_plus); //추가하기 버튼
        edt_title = findViewById(R.id.edt_title); //제목
        edt_url = findViewById(R.id.edt_url); //주소

        btn_plus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         //EditText에 적혀있는 title,url정보 가지고 다시 돌아오기
         String title = edt_title.getText().toString(); //제목가져오기
         String url = edt_url.getText().toString();//주소가져오기

        // 정보를 담기위한 Intent 생성!
        Intent it = new Intent(); //값만담아서 호출한 곳으로 돌아가면되니깐
        it.putExtra("title",title);//title 담아주기
        it.putExtra("url",url); //url 담아주기
        setResult(RESULT_OK,it); //Main으로 돌아가기
        finish();// add 끝내기




    }
}