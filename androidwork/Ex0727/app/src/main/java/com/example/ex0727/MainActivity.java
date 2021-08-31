package com.example.ex0727;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<PhoneVO>data = new ArrayList<>(); //ArrayList생성
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview);
        // ListView 만들 때 필요한 것
        // 1. 템플릿(layout) 2. 데이터(ArrayList), 3.Adapter

        // 1=> 템플릿 완성!
        // 2=> 데이터를 담을 ArrayList만들어야 하는데
        // 전화번호 하나에 포함된 정보: 이미지(int),이름(String), 전화번호(String)
        // 3개 정보의 타입이 서로 다르기 때문에 한묶음으로 저장할 수 없음...
        // 그래서! 새로운 데이터타입(ValueObject)을 설계해서 저장할 수 있음

        data.add(new PhoneVO(R.drawable.apach,"임명진","01055555555"));
        //메모리할당,객체생성 키워드 new
        data.add(new PhoneVO(R.drawable.muzi,"이명훈","01055555555"));
        data.add(new PhoneVO(R.drawable.neo,"강성관","01055555555"));
        data.add(new PhoneVO(R.drawable.ryan,"정형","01055555555"));

        // Adapter 객체 생성
        PhoneAdapter adapter = new PhoneAdapter(getApplicationContext(),//context 정보
                R.layout.phonelist,data);//템플릿,어레이리스트

        // listView에 adapter 설정!
        lv.setAdapter(adapter);
//기본적으로 제공하는 adapter를 쓸 수 없다.
        //convertView에다가 바로 setText를 시켜버림
    }
}