package com.example.project_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_rian , btn_apeech, btn_con; //라이언,어피치,콘

   String selnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btn_rian = findViewById(R.id.btn_rian);//라이언
        btn_apeech = findViewById(R.id.btn_apeech);//어피치
        btn_con = findViewById(R.id.btn_con);//콘

        btn_rian.setOnClickListener(this);//라이언
        btn_apeech.setOnClickListener(this);//어피치
        btn_con.setOnClickListener(this);//콘

    }

    @Override
    public void onClick(View v) {

        //intent
        Intent it = new Intent(FirstActivity.this,MainActivity.class);
        if(v.getId()==R.id.btn_rian){//라이언
            selnum = "1";
            it.putExtra("selnum",selnum);
        }else if(v.getId()==R.id.btn_apeech){//어피치
            selnum = "2";
            it.putExtra("selnum",selnum);
        }else if(v.getId()==R.id.btn_con){//콘
            selnum="3";
            it.putExtra("selnum",selnum);
        }
        startActivity(it);//activity보낸다



    }
}