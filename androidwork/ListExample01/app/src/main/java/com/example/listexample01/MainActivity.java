package com.example.listexample01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;//list뷰 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);

        List<String> data = new ArrayList<>();//리스트 생성

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        //어댑터 생성(중간다리역할) - 뷰랑 리스트를 연결하기 위해서                          //안드로이드 디자인

        list.setAdapter(adapter);//리스트뷰에다가 어뎁터를 셋팅

        data.add("홍드로이드");
        data.add("안드로이드");
        data.add("사과");
        adapter.notifyDataSetChanged();//.. 이 상태를 저장하겠다.



    }
}