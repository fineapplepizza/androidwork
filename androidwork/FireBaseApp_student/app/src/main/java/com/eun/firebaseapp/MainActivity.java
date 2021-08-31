package com.eun.firebaseapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ChatVO> data = new ArrayList<>();
    String loginId; // 현재 로그인한사람 ID
    ChatAdapter adapter;
    ListView lv;
    Button btn_send;
    EditText edt_input;
    // 파이어베이스 생성
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://fir-app-365b0-default-rtdb.firebaseio.com/");
    //FireBase에 서버URl을 가지고 오는 소스코드
    DatabaseReference myRef = database.getReference("message");
//myRef통해 데이터베이스 전송

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginId = getIntent().getStringExtra("loginId");

        lv = findViewById(R.id.listview);
        btn_send = findViewById(R.id.btn_send);
        edt_input = findViewById(R.id.edt_input);

        data.add(new ChatVO(R.drawable.ic_launcher_background, "임명진", "여러분 안녕하세요~^^", "AM 09:00"));
        data.add(new ChatVO(R.drawable.ic_launcher_background, "김대원", "안녕하세요!", "AM 09:01"));
        data.add(new ChatVO(R.drawable.ic_launcher_background, "윤희근", "넵 안녕하세요~", "AM 09:01"));
        data.add(new ChatVO(R.drawable.ic_launcher_background, "최영재", "^__________^", "AM 09:01"));
        data.add(new ChatVO(R.drawable.ic_launcher_background, "정선일", "좋은아침이에요~", "AM 09:01"));
        data.add(new ChatVO(R.drawable.ic_launcher_background, "윤영은", "명진쌤 화이팅!!", "AM 09:01"));


        adapter = new ChatAdapter(getApplicationContext(), R.layout.chatlist, data,loginId);

        lv.setAdapter(adapter);

        // 1. 내가 보낸 메세지는 오른쪽에, 남이보낸 메세지는 왼쪽에 띄우기
        // 2. FireBase 연동하기
        // send버튼 누르면 서버로 값보내기~~~
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // firebaseDataBase로 값 전송하는 명령
                myRef.push().setValue(new ChatVO(R.drawable.logo,
                        loginId, edt_input.getText().toString(),"PM 04:52"));
            }
        });

        // firebaseDataBase에 값이 추가됨을 감지
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot,  String s) {
                // 데이터가 추가됐을 때 실행되는 메소드!
                // DataBase에 값이 추가되면 데이터를 가져와서 ArrayList에 추가한다.
                data.add(dataSnapshot.getValue(ChatVO.class));
                //dataAnpshot에서 값을 가져올건데 ChatVO타입으로 가져오겠다.
                adapter.notifyDataSetChanged();//새로고침

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot,  String s) {
               // 변경됐을 때 실행되는 메소드
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                 // 삭제됐을 때 실행되는 메소드
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot,  String s) {
               // 옮겨졌을 때 감지해서 실행되는 메소드
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //무언가 실패했을때
            }
        });




    }
}