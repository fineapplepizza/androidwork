package com.example.ex0719;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //인터페이스는 반드시 오버라이딩 해야한다

    // Java 소스코드로 OnClick 한곳으로 모는 법
    // 1. OnClickListner를 implements 한다.(class안에 추상메소드와 상수밖에 없는것)
    // 2. OnClick 메소드 생성(오버라이딩)!

    //리소스들은 전역변수
  ImageView img;
  Button btn1,btn2,btn3,btn_pre,btn_next;

    //1.이미지를 배열(int)에 넣는다.
    int [] image ={R.drawable.ryan,R.drawable.peach,R.drawable.nudle};

    //int[]imgs = new int[3];
    //imgs[0] = R.drawable.img1;
    //imgs[1] = R.drawable.img2;
    //imgs[2] = R.drawable.img3;

    // 2. 현재 이미지의 번호를 저장할 변수(int index)를 만든다!
    int index = 0;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //R은 id가 정리되어있는 파일
        img = findViewById(R.id.imageView);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn_pre = findViewById(R.id.btn_pre);
        btn_next = findViewById(R.id.btn_next);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn_pre.setOnClickListener(this);
        btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 매개변수 View는 ?? => 현재 이벤트가 발생한 그 뷰(버튼,텍스트뷰,에디트등등 있음)
        // 우리 지금 하려고 하는거!
        // 버튼들마다 OnClickListener가 다 따로 정의되어 있어서 코드가 복잡함
        // => ClickListener를 딱 한개만 만들어서 5개 버튼 이벤트 처리해주려고 함!
        // 하지만! 버튼 전부다 이 메소드를 실행시킨다?? 좀 이상함..
        // 우리는 버튼을 구분할 필요가 있음
        // => 어떤 버튼 눌렀는지 구분해야함
        // => v.getId()를 사용하여 버튼의 id를 알아내어 구분
        if(v.getId()==R.id.btn1){ // btn1을 클릭했다면
            img.setImageResource(R.drawable.ryan);
        }else if (v.getId()==R.id.btn2){
            img.setImageResource(R.drawable.peach);
        }else if(v.getId() == R.id.btn3){
            img.setImageResource(R.drawable.nudle);
        }else if(v.getId() == R.id.btn_next){
            if(index==image.length-1){ //마지막사진이라면! (사진의 개수가 바뀌더라도 안에 있는 코드를
                //바꾸지 않아도 된다 (유지보수가 용이)
                //마지막 사진이라는 Toast메세지!
                Toast.makeText(MainActivity.this,"마지막 사진입니다.",Toast.LENGTH_SHORT).show();
                img.setImageResource(image[0]);
                index = 0;
            }else{
                index++;
                img.setImageResource(image[index]);
            }

        }else if(v.getId() == R.id.btn_pre){
            if(index == 0){ // 첫번째 사진이라면!
                //첫번째 사진입니다 Toast메세지 띄우기~~
                Toast.makeText(MainActivity.this, "첫번째 사진입니다.", Toast.LENGTH_SHORT).show();
                img.setImageResource(image[image.length-1]);
                index = image.length-1;

            }else{
                index--; // pre버튼을 누르면 index를 감소
                img.setImageResource(image[index]); //index번째의 이미지를 보여준다.
            }

        }



    }
}