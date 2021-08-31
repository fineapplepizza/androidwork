package com.example.ex0724;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity  {

    EditText et_id; //id입력 텍스트
    EditText et_pw; //pw입력 텍스트
    Button btn_login; //로그인 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        et_id = findViewById(R.id.et_id); //id
        et_pw = findViewById(R.id.et_pw); //pw
        btn_login = findViewById(R.id.btn_login); //로그인

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = et_id.getText().toString();//id글자 가져오기
                String pw = et_pw.getText().toString();//pw글자 가져오기

                if(id.equals("eowls")&&pw.equals("1214")){
                    //id와 pw를 맞게 입력했다면~
                    Intent it = new Intent();
                    it.putExtra("id",id);
                    setResult(RESULT_OK, it); //다시 돌아가기
                    finish();//종료하기

                }
            }
        });
    }


}

