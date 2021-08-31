package com.example.ex0722;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_result = findViewById(R.id.tv_result);


        Intent it = getIntent();
        int result = it.getIntExtra("result",0);

        //defaultValue- 키값이 없을때 사용될 기본값 보통 -1값이나 0을 많이씀

        tv_result.setText(result+"");
        //setText할때 정수형 데이터를 넣으면 에러가 난다.
        //Resources$NotFoundException
        //why?
        // 정수형 데이터를 넣으면 Strings.xml 파일 데이터를 참조한다고 생각!
        //Strings 파일
        //어플에 쓰는 변수를 미리 참조해서 씀
        //Strings파일에 무언가를 만들면 R파일에 등록이된다.
        //결론은 settext를 할때 숫자형을 넣으면 문자데이터의 아이디값이구나 생각함


    }
}