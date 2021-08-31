package com.example.ex0724;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn_loginMain, btn_write; //로그인,글작성 변수 선언
    TextView tv_result; //텍스트뷰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_loginMain = findViewById(R.id.btn_loginMain); //로그인버튼
        btn_write = findViewById(R.id.btn_write); //글작성버튼
        tv_result = findViewById(R.id.tv_result);//텍스트뷰

        btn_loginMain.setOnClickListener(new View.OnClickListener() { //버튼클릭했을때
            @Override
            public void onClick(View v) {
                //MainActivity -> SubActivity
                Intent it = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(it, 1001); //왕복
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // 다녀왔을 때 실행되는 메소드~~~
        super.onActivityResult(requestCode, resultCode, data);
        //Intent data 에 데이터가 담겨있다.
        if (requestCode == 1001) {//요청코드값이 1001이였고
            if (resultCode == RESULT_OK) { //요청결과가 ok였다면
                String id = data.getStringExtra("id");
                tv_result.setText(id + "님 환영합니다~~");//textView 글자 바꾸기
                btn_write.setEnabled(true);//글작성 버튼 활성화
                btn_loginMain.setText("로그아웃"); //로그인 버튼 글자 바꾸기
            }
        }
    }
}