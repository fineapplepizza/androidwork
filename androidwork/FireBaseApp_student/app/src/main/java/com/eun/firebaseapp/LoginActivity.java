package com.eun.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText edt_id, edt_pw;
    Button btn_login, btn_join;
    String[][] member = {{"임명진", "0518"}, {"이은비", "1214"},{"정선일","0000"}};
     // Volley 사용해서 Server랑 통신하는 법!
    //1. requestQueue => Server랑 연결해서 데이터를 전송할 통로!
    //2. StringRequest => 요청(reqeust), 응답(response)에 대해 미리 짜놓은 알고리즘~

    RequestQueue requestQueue;
    StringRequest stringRequest_join; // 회원가입 알고리즘(joinservlet에 보냄)
    StringRequest stringRequest_login; // 로그인 알고리즘즘(loginservlet에 보냄)

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_join = findViewById(R.id.btn_join);// 회원가입버튼

       //requestQueue 생성!
       requestQueue = Volley.newRequestQueue(getApplicationContext());









       // StringRequest 생성!
       // 객체 생성 시 매개변수 4개(데이터전송방식(get/post),전송하고싶은url,응답을 처리하는 메소드,에러나는 것을 감지하는 에러리슨)
       stringRequest_join = new StringRequest(Request.Method.POST,
               "http://172.30.1.25:8081/And_MemberServer/JoinServlet",
               new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       //응답을 처리하는 메소드
                       if(response.equals("1")){ //회원 가입자로댔으면 행이 1 추가되니깐 결과값 1로 옴
                           Toast.makeText(getApplicationContext(),
                                   "회원가입 완료!",Toast.LENGTH_SHORT).show();
                       }
                   }
               }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {

           }
       }){// 몸체부분
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {//필요한메소드는 몸체를 구현
               //protecte - 접근 제한자 getParams메소드,리턴타입 Map이라는 자료구조로 리턴하겠다.
               Map<String,String> params = new HashMap<>();
               //params는 파라미터 줄임말
               params.put("id",edt_id.getText().toString());//Map은 순서가 없어서 집어넣는거 put
               params.put("pw",edt_pw.getText().toString());

               return params;
           }
       };

       stringRequest_login = new StringRequest(Request.Method.POST,
               "http://172.30.1.25:8081/And_MemberServer/LoginServlet",
               new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {//response 응답한 값
                       // 응답을 처리
                       if(response.equals("true")){
                           Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                         intent.putExtra("loginId", edt_id.getText().toString());
                        startActivity(intent);
                       }

                   }
               }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {

           }
       }){
           // alt + insert => overrding
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               Map<String,String>params = new HashMap<>();

               params.put("id",edt_id.getText().toString());
               params.put("pw",edt_pw.getText().toString());

               return params;
           }
       };



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
//                for (String[] temp : member) {
//                    if (temp[0].equals(edt_id.getText().toString()) && temp[1].equals(edt_pw.getText().toString())) {
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        intent.putExtra("loginId", edt_id.getText().toString());
//                        startActivity(intent);
//                        //확장 for문(for-each)문
////member 2차원배열
////배열에서 값을 하나씩 꺼낼때 쓰는 것
////:기준 오른쪽에는 배열
////:기준 왼쪽은 배열에서 값을 하나씩 꺼내서 저장할 임시변수
////2차원- 1차원배열을 한묶음으로 묶은것
//                    }
//                }
              requestQueue.add(stringRequest_login);
            }
        });
        // join버튼 눌렀을 때 requestQueue에 stringRequest 전송!
       btn_join.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               requestQueue.add(stringRequest_join); //requestQueue라는 전송통로애 stringRequest라는 로직이 실행됨
           }
       });
    }
}