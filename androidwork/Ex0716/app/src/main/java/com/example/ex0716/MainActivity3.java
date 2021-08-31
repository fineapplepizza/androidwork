package com.example.ex0716;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    ImageView img_dugu;
    Button btn_dugu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        img_dugu = findViewById(R.id.img_dugu);
        btn_dugu = findViewById(R.id.btn_dugu);

        btn_dugu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // btn_dugu를 눌렀을 때 동작할 코드!

//                img_dugu.setImageResource(R.drawable.gohome);//정수형으로 변환이 되어있어서 그 숫자들을 불러오면됨

                // btn_dugu를 눌렀을 때,
                // Random 클래스를 활용하여
                // 퇴근사진 혹은 남아서 공부 사진
                // 둘 중 하나의 사진이 랜덤하게 뜨도록 코드를 작성

                Random random = new Random();

                int random_number = random.nextInt(2);

                if(random_number == 0){
                    img_dugu.setImageResource(R.drawable.gohome);
                }else{
                    img_dugu.setImageResource(R.drawable.study);
                }



            }
        });
    }
}