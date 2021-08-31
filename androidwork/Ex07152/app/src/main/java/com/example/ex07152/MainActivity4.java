package com.example.ex07152;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    TextView tv_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) { //onCreate 맨 처음 어플리케이션이 동작하면 실행되는 함수
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4); //xml파일을 변환시켜서 띄워주는 역할 여기 밑에서 코드쳐야함

        //숫자 0을 가져옴 우선 컴포넌트를 구분하기 위해 id부여
        //tv_count TextView의 값을 가져오자!!

        //textview button 이미지 뷰등 아이디를 초기화해야한다
        //findViewById는 view객체로 리턴  다운 캐스팅해줘야하는데 생략해도 괜찮게 됐다.
        tv_count = findViewById(R.id.tv_count);//resuorce라는 패키지에 id에 저장되어있음,int형태로 저장되었음


    }

    public void count(View view){

        Log.v("myValue","버튼 눌러짐");
        //안드로이드 스튜디오에 제공하는 태그같은거라 작성하는 파트가 아님
        //Log.v(상세) tag:고유한태그,msg:메시지
        //v로 썻다면 verbose로 찾아줘야함
        //검색에는 내가 정한 태그이름을 정하면됨
        //syso 역할한다고 생각하면됨됨
        //
        // getText의 형태를 string형태로 변환
        //int 변환 INteger,parseINt
        int cnt = Integer.parseInt(tv_count.getText().toString());
        cnt++; // cnt +=1; cnt = cnt +1;


        //문자열로 변환하는 법  String.valueOf()
//        tv_count.setText(String.valueOf(cnt)); //setText안에 들어갈 수 있는 것은 문자열만 쓸 수 있다.
        tv_count.setText(cnt+"");
//        Toast.makeText(this,str, Toast.LENGTH_SHORT).show();
        //context는 페이지 정보
         }
}