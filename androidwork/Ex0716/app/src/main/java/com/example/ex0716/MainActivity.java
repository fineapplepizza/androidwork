package com.example.ex0716;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //각각의 id들을 java코드에 사용할 수 있게 초기화 작업
    EditText et_input1, et_input2;
    Button btn_plus, btn_minus, btn_multi,btn_div;
    TextView tv_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//여기서 xml파일을 불러옴

        et_input1 = findViewById(R.id.et_input1); //R은 resource폴더 약자
        et_input2 = findViewById(R.id.et_input2);

        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_multi = findViewById(R.id.btn_multi);
        btn_div = findViewById(R.id.btn_div);

        tv_result = findViewById(R.id.tv_result);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//버튼이 클릭했을 때 이벤트들을 발생시킬수 있음

                // 1.et_input1,et_input2의 값을 각각
                // num1,num2로 받아온다(단, 정수형으로 변환시켜서)

               int num1 = Integer.parseInt(et_input1.getText().toString());
               int num2 = Integer.parseInt(et_input2.getText().toString());


               // 2.num1과 num2를 더해서 result라는 int타입 변수에 저장
                 int result = num1+num2;

               // 3. tv_result에 result값을 출력한다.(setText)

                tv_result.setText(result+""); //setText는 문자열로 변환시켜줘야함

            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //빼기
               int num1 = Integer.parseInt(et_input1.getText().toString());
               int num2 = Integer.parseInt(et_input2.getText().toString());

               //num1-num2빼기 변수에 저장
                int result = num1-num2;
                //tv_result에 result값을 출력한다.(setText)

                tv_result.setText(result+"");
            }
        });
        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 곱하기
               int num1 = Integer.parseInt(et_input1.getText().toString());
               int num2 = Integer.parseInt(et_input2.getText().toString());

               //num1*num2 곱하기 변수에 저장
                int result = num1*num2;
                //tv_result에 result값을 출력한다.
                tv_result.setText(result+"");
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //나누기
                int num1 = Integer.parseInt(et_input1.getText().toString());
                int num2 = Integer.parseInt(et_input2.getText().toString());

                //num1/num2 나누기 변수에 저장
                int result = num1/num2;
                tv_result.setText(result+"");
            }
        });

    }
}