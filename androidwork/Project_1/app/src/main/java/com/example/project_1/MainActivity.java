package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_first, btn_second, btn_third; //첫번째,두번째,세번째 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_first = findViewById(R.id.btn_first); //첫번째 버튼
        btn_second = findViewById(R.id.btn_second);//두번째 버튼
        btn_third = findViewById(R.id.btn_third);//세번째 버튼

        btn_first.setOnClickListener(this);
        btn_second.setOnClickListener(this);
        btn_third.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_first){//첫번째 버튼 클릭했다면
            btn_first.setText("1ST BUTTON!");
        }else if(v.getId()==R.id.btn_second){//두번째 버튼 클릭했다면
            btn_second.setText("2ND BUTTON!");
        }else if(v.getId()==R.id.btn_third){//세 번째 버튼 클릭했다면
            btn_third.setText("3RD BUTTON!");
        }
    }
}