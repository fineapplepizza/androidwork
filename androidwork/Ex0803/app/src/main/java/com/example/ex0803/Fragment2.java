package com.example.ex0803;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Fragment2 extends Fragment {
    // Thread 구현하는 법
    // 1. Thread 클래스를 상속받아 필요한 알고리즘을 설계한다. 90%
    //  - Activity나 fragment 클래스 안에서 Thread 설계한다.
    // 2. Thread를 시작한다.
    // 3. 필요하다면 Thread를 중지한다.
    TextView tv1, tv2, tv3; // TextView 첫번째, 두번째, 세번째
    Button btn1, btn2, btn3; //버튼 첫번째, 두번째,세번째

    @Override//1. Fragment2정리
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        tv1 = view.findViewById(R.id.tv1); //첫번째 텍스트뷰
        btn1 = view.findViewById(R.id.btn1); //첫번째 버튼

        tv2 = view.findViewById(R.id.tv2); //두번째 텍스트뷰
        btn2 = view.findViewById(R.id.btn2); //두번째 버튼
        // btn2를 클릭했을 때! tv1처럼 tv2에도 숫자가 카운트되게 만들어주세요!

        tv3 = view.findViewById(R.id.tv3); //세번째 텍스트뷰
        btn3 = view.findViewById(R.id.btn3); // 세번째 버튼

        btn1.setOnClickListener(new View.OnClickListener() {//첫번째 버튼 클릭했을때
            @Override
            public void onClick(View v) {
                //thread 실행시키는 법
                // 1.Thread가 구현되어 있는 클래스의 객체를 생성한다.
                // 2. start()메소드를 호출한다.
                timeThread tt = new timeThread(tv1); //timethread객체 생성
                tt.start(); // start호출
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {//두번째 버튼 클릭했을때
            @Override
            public void onClick(View v) {
                timeThread tt = new timeThread(tv2);
                tt.start();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {//세번째 버튼 클릭했을때
            @Override
            public void onClick(View v) {
                timeThread tt = new timeThread(tv3);
                tt.start();
            }
        });

        return view;
    }

    // 객체지향 네가지 특성?
    // 캡슐화, 상속, 추상화, 다형성

    // Thread 설계를 여러개 만들었을 때 문제점.....
    // => 특정TextView 전용 Handler를 만들어야 함
    // => 한 부분만 다른데도 다 복붙해야함....=> 코드가 너무 길어짐

    //tv1전용 Thread + Handler
     Handler handler = new Handler(){
         @Override
         public void handleMessage( Message msg) {//받아서 처리할때
             TextView textView = (TextView) msg.obj;

             textView.setText(msg.arg1+"");//arg1에 담았기 때문에 꺼낼때도 arg1으로 꺼냄

         }
     };


    // 자원공유하기위해 여기에다가 만듬듬
    class timeThread extends Thread{ //Thread상속받음

        // Thread를 시작(start)시키면!
        // run이라는 메소드가 실행됨
        // => run 메소드를 오버라이딩 해준다!
        private TextView textview;// 이 thread가 카운트해야할 textView

        public timeThread(TextView textView){
            this.textview = textView;
        }

        @Override
        public void run() {//run메소드
            // 1~10 까지 1초에 1씩 증가하며 TextView에 띄우기 => 10초 세기!
            for(int i = 1; i<= 10; i++){ // 1부터 10까지 1씩 증가하겠다.


               // tv1.setText(i +"");//숫자는 못들어가서 string변환
                //1부터 10까지 1씩 증가하면서 Textview에 글을 써라
                Message msg = new Message();//메시지 객체 생성,메모리할당(메세지라는 구조의 공간을 확보하겠다)
                msg.arg1 = i; //arg1,arg2 (int),obj (object) 메시지 공간이 3개가 있다.(저장공간)
                msg.obj = textview; //obj에다가 textview를 담음
                handler.sendMessage(msg); //handler에 메시지 보내기
                //handler에 있는 sendMessage메소드 호출해라 msg를 handler한테 보냄

                // Thread를 1초 쉬게 합니다.
                try {//Thread.sleep은 반드시 try,catch를 만듬
                    Thread.sleep(1000);
                } catch (InterruptedException e) {//sleep하는 동안 누가끼어들면 예외처리명시해해
                   e.printStackTrace();
                }

            }

        }
    }

}