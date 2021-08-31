package com.example.project_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img;
    Button pre, next;
    String selnum;
    ArrayList<Integer> arr = new ArrayList<>(); //arrayList생성

    //현재 이미지에 저장할 변수
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        pre = findViewById(R.id.pre);
        next = findViewById(R.id.next);

        Intent it = getIntent();
        selnum = (String)it.getStringExtra("selnum");

        if(selnum.equals("1")){//라이언
            arr.add(R.drawable.rian1);
            arr.add(R.drawable.rian2);
            arr.add(R.drawable.rian3);
        }else if(selnum.equals("2")){//어피치
            arr.add(R.drawable.apeech1);
            arr.add(R.drawable.apeech2);
            arr.add(R.drawable.apeech3);
        }else if(selnum.equals("3")){//콘
            arr.add(R.drawable.con1);
            arr.add(R.drawable.con2);
            arr.add(R.drawable.con3);
        }

        img.setImageResource(arr.get(0));//첫 번째사진 보이게 하기

        pre.setOnClickListener(this);
        next.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {



        if(v.getId()==R.id.next){

            if(index==arr.size()-1){//마지막 사진이라면
                img.setImageResource(arr.get(0));
                index=0;
            }else{
                index++; //next버튼을 누르면 index증가
                img.setImageResource(arr.get(index));
            }

        }else if(v.getId()==R.id.pre){//첫번째 사진이라면
            if(index==0) {
                img.setImageResource(arr.get(0));
                index = arr.size()-1;
            }else{
                index--;//pre버튼을 누르면 index를 감소
                img.setImageResource(arr.get(index));//index번째 이미지 보여준다.
            }
        }






    }
}