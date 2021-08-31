package com.example.ex0722;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {//오버라이딩,추상클래스가 되던지
    TextView edt1,edt2 ; //첫번째 두번째 텍스트

    Button btn_add , btn_sub, btn_div, btn_mul; //버튼4개


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //edt1.findViewById(R.id.edt_num1); //edt1안에서 edt_num1 뷰 찾아라
        edt1=findViewById(R.id.edt_num1); //setContentView 되어있는 xml에서 edt_num1 뷰찾아서 edt1이라는 변수에 저장해라
        edt2=findViewById(R.id.edt_num2);

        btn_add=findViewById(R.id.btn_add);
        btn_sub=findViewById(R.id.btn_sub);
        btn_mul=findViewById(R.id.btn_mul);
        btn_div=findViewById(R.id.btn_div);

        btn_add.setOnClickListener(this);
        //setOnClickListner 메소드 안에는 OnClickListener 객체가 들어가게 되어있음
        //지금 MainActivity 클래스가 OnClickListner를 구현하고 있음
        //-> MainActivity가 OnClickListenr라고 볼 수 있음
        // 현재 클래스를 의미하는 this라는 키워드를 사용!(내 자신이 OnClickListner이기 때문에)

        btn_sub.setOnClickListener(this);
        // 지금 코드에서는 add 버튼의 이벤트 따로, sub버튼의 이벤트 따로 ==> 중복되는 코드가 너무 많음
        // 정리해보자! 어떻게 ? ==> 하나의 onClick 메소드로 다 모이게! => onClick안에서 어떤 버튼을 클릭한건지 구분!
        // 1.현재 클래스에 OnClickListener를 implements한다.(인터페이스를 상속->구현한다는 뜻)
        // 2. onClick 메소드를 오버라이딩(재정의) 한다!(추상메소드를 가지고 구현을 함)

       btn_div.setOnClickListener(this);
       btn_mul.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) { //OnClickListner인터페이스 안에 onClick메소드가 있다.
        // 매개변수 View??? => 현재 이벤트가 발생한 뷰 =>내가 클릭한 뷰
        // View의 id 속성으로 어떤 버튼인지 구분할 수 있음
//
//        if(v.getId() == R.id.btn_add){ // add버튼을 눌렀다면~~
//
//        }else if(v.getId() == R.id.btn_sub){
//
//        }else if(v.getId() == R.id.btn_div){
//
//        }else if(v.getId() == R.id.btn_mul){
//
//        }

        int num1=Integer.parseInt(edt1.getText().toString()); //첫번째 EditText에 적혀있는 글자와
        int num2= Integer.parseInt(edt2.getText().toString()); //두번째 EditText에 적혀있는 글자를 가져와서

        Intent it = new Intent(MainActivity.this,ResultActivity.class);

        switch (v.getId()){
            case R.id.btn_add:
                //add버튼을 클릭했을 때 일어날 일


                it.putExtra("result",num1+num2); //키값,value값, // 두 수를 더한 값을
                //putExtra에 연산을 보통하지 않음, 연산해놓은 변수를 넣어줌
                break;
                case R.id.btn_sub:
                //sub버튼을 클릭했을 때 일어날 일


                it.putExtra("result",num1 - num2); //키값,value값, // 두 수를 더한 값을

                break;
            case R.id.btn_div:
                //div버튼을 클릭했을 때 일어날 일
                it.putExtra("result",num1 / num2);
                break;
            case R.id.btn_mul:
                //mul버튼을 클릭했을 때 일어날 일
                it.putExtra("result",num1 * num2);
                break;

        }
        //if문 switch문 중 편한 거 쓰면됨
        startActivity(it);// 보낸다.

    }
}