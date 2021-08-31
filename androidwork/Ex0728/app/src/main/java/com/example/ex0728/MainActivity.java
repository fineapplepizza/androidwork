package com.example.ex0728;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<VOclass> data = new ArrayList<>(); //ArrayList생성
    ListView lv;//리스트뷰
    Button btn_add;//버튼 추가
    AdapterClass adapter;//어댑터
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview); //listview
        btn_add = findViewById(R.id.btn_add); //추가버튼

        //바로가기 저장하기
        data.add(new VOclass("스마트인재개발원","https://www.smhrd.or.kr"));
        data.add(new VOclass("daum","https://www.daum.net"));

        //어뎁터 객채 생성하기
        adapter = new AdapterClass(getApplicationContext(),
                R.layout.templete,data);

        // 요기서 nullPointerException이 발생했대요!
        // 의심스러운것은 lv입니다
        // findViewById 하셨나여?.?
        // 생각해보니 안했어요 ㅠㅠ ㅎㅎㅎㅎ 수정하심 될거같아용!!
        //감사합니다
        lv.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//추가 버튼 클릭했을때
                Intent it = new Intent(MainActivity.this,add.class);
                startActivityForResult(it,1001);//왕복

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {//longclick 이벤트
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // 3.position => 이벤트가 발생한 항목의 번호
                //  다이얼로그 띄우기
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("삭제하시겠습니까?"); //다이얼로그에 띄울 문구
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(position); //데이터 지움
                        adapter.notifyDataSetInvalidated();//새로고침
                    }
                });
                builder.create().show();//화면에 띄우기


                // return true로 되어 있으면 일반클릭은 인식안함(롱클릭만쓰겠다)
                return false;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1001){
            if(resultCode == RESULT_OK){
                String title = data.getStringExtra("title");
                String url = data.getStringExtra("url");

                this.data.add(new VOclass(title,url));
                adapter.notifyDataSetChanged();//Adapter새로고침

            }
        }
    }
}