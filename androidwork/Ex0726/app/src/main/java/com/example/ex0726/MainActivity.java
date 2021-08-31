package com.example.ex0726;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 3. 아이템 데이터 (채팅데이터)생성
    // => ArrayList 만들기 ~~
    ArrayList<String> chat = new ArrayList<>();//String이라고 적어도 되고 안적어도 되고
    //안적었을때는 Object타입에서 String으로 다운캐스팅이 된다.
    // <저장하고 싶은 데이터 타입>
    // int => Ingeger

    ListView lv;
    Button btn_send;
    EditText edt_msg;

    DBManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = new DBManager((getApplicationContext()));
        //DBMAnager객체를 생성하게 되면 DBMAnger클래스의 생성자가
        //호출이 되면서 DBMAnager안에서 DBHelper가 생성이 됨

        lv = findViewById(R.id.listView);
        btn_send = findViewById(R.id.btn_send);
        edt_msg = findViewById(R.id.edt_msg);

        // => 데이터 추가하기
        chat = manager.getAllMsg();//manager가 데이터를 불러와서 chat에다가 저장

        //ListView 한줄에 들어갈 layout(탬플릿)디자인 : simplelist.xml
        //ListView에 적힐 데이터 : chat ArrayList

        //ListView의 원리!!
        // 템플릿에 데이터를 적어서 한줄한줄 추가한다 => 템플릿 + 데이터
        // Adapter 객체 필요!!

        //ListView 만들때 필요한 것
        //1.템플릿(ListView 한줄에 들어갈 디자인) => simplelist.xml
        //2. 데이터 ==>ArrayList
        //3. 어뎁터 => 템플릿이랑 데이터를 합쳐주는 것
        //   -> 이 예제는 글자만 표현되기 때문에 ArrayAdapter 사용 가능(기본제공)
        //   -> 향후에 카톡 디자인을 하려면 Adapter를 새로 설계해주어야 함(조금 어려움)




        // 4. Adapter 만들기
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.simplelist,chat); //템플릿이랑 데이터를 합쳐줘서 listview에 하나하나씩 적재
        // - getApplicationContext -> 현재 페이지 정보
        // - R.layout.simplelist -> 템플릿
        // - chat -> 데이터

        // 5. ListView에 Adapter 설정하기
        lv.setAdapter(adapter);

        // 글자가 너무 작다... 키우고 싶으면??
        // listView ??? 템플릿??? -> 템플릿에서 수정
        //listVew 가변적 레이아웃 - 템플릿을 한줄 한줄 채워넣는다.

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText에 적힌 글자 가져와서
                String msg = edt_msg.getText().toString();
                // listView에 추가한다
                chat.add(msg);
                // adapter 새로고침
                adapter.notifyDataSetChanged();

                // 1. send버튼 누르면 editText글자 사라지게
                edt_msg.setText("");
                // 2. 스크롤이 옮겨졌으면 좋겠음
                //listView 속성중에 trascriptMode => alwaysScroll로 해주면 됨




                manager.insert(msg);//버튼 클릭하면 insert요청(DB에저장해라!)
                //리펙토링방식- 에러를 먼저 호출하고 에러를 고치면서 개발을 함

            }
        });





    }
}