package com.example.ex0723;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SubActivity extends AppCompatActivity {
//Button btn_main;
    //ListView의 항목을 클릭했을 때 다시 돌아가기! => 어떤 항목을 선택했는지 가지고 가야함
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        listView=findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {//ClickListener한단계 업그레이드된거
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//listview에서 item을 클릭했을때
                //AdapterView상위클래스?
                //감지하는게 다르기때문에 매개변수 개수가 다름
                //1.parent ==> 현재이벤트가 발생한 ListView
                //2.view => 현재 이벤트가 발생한 항목
                //3.positon => 현재 이벤트가 발생한 index
                //4.id ==> position이랑 같이씀

                //다시 Main으로 돌아감, 내가 선택한 색 가지고 가야함
                //position에 따라서 color값 부여
                String color = "";
                if(position == 0){
                    color = "#800000";
                }else if(position == 1){
                    color = "#FFD700";
                }else if(position == 2){
                    color = "#4169E1";
                }

                //2. main으로 돌아가보자
                // - 데이터(색깔)를 담을 Intent준비
                Intent it = new Intent(); //다시 돌아갈때는 출발지 도착지 없이 Intent()
                it.putExtra("color",color);

                // - 돌아가기 (결과코드값,인텐트)
                setResult(RESULT_OK,it);

                // - 종료하기
                finish();


//Optional data생략이 가능한 데이터

            }
        });



//        btn_main=findViewById(R.id.btn_main);
//        btn_main.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent it_btn = new Intent(SubActivity.this,MainActivity.class);
////                startActivity(it_btn);
//                //startActivity => task에 계속해서 Activity가 쌓임!
//                //=> main으로 버튼을 누르면 현재 Activity만(sub)종료!
//
//                finish(); // => 현재 Activity 종료!
//            }
//        });

    }


}