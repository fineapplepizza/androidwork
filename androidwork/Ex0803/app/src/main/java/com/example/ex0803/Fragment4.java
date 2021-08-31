package com.example.ex0803;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment4 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 여기서 fragment를 그립니다...
        // inflate
        // xml파일을 화면에 그리는 것!
        View view = inflater.inflate(R.layout.fragment_4, container, false);

        

        Button btn = view.findViewById(R.id.btn_ok);
        EditText edt_url = view.findViewById(R.id.edt_url);

        // 버튼을 누르면 EditText에 적혀있는 주소값 가지고 와서
        //Fragment1의 address를 바꾼다.

        // App이 껐다 켜져도 데이터를 유지할 수 있게 하는 방법!
        // 1.Android 내장 DataBase => SQLite
        // 2.Server 연동해서 데이터 외부에 저장하기 => FireBase, Volley

        // 그렇다면! App기능중에서 로그인 유지 기능 구현하려면?????
        // 쿠키, 세션 같은 기능 => SharedPreference!
        // SharedPreference는 주로 언제쓸까?
        // 회원 한명의 정보를 계속 기억해야할 때(로그인유지기능)
        // APP 최초 실행여부 알아낼 때 (처음킨건지,두번째킨건지)
        // Fragment끼리 데이터 주고 받을 때 ~~

        //SharedPreference -어플 내에 있지만 모든 Activity , 모든 fragment에 접근할 수 있는 공용의 공간을 사용

        SharedPreferences spf = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE);
        //urlSPF에 SharedPReference를 하나만 두겠다
        //(MODE_PRIVATE)-하나만 두겠다는 뜻
        //fragment이기 때문에 앞에 Activity가 있음

        //spf에 값을 저장하고 싶을 때 사용하는 객체(Editor)
        SharedPreferences.Editor editor = spf.edit();



        btn.setOnClickListener(new View.OnClickListener() {//버튼을 누르면
            @Override
            public void onClick(View v) {
                String address = edt_url.getText().toString();// 이곳에 editText에 적혀있는 글 가져오는 소스코드 입력하기!


                // address 값 spf에 저장하기!
                editor.putString("address",address);// 키값,value값 지정
                editor.commit(); // ★★★★★ 진짜 sharedPreference에 반영될려면 commit까지 해야함

                Toast.makeText(getContext(), "기본 주소가'"+ address+"'로 바뀌었습니다!", Toast.LENGTH_LONG).show();

               // 키패드 지우는 코드
                InputMethodManager im = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);//InputMethod다운캐스팅
                im.hideSoftInputFromWindow(v.getWindowToken(),0);
                //flags는 옵션인데 옵션에 따로 줄게 없어서 0 -> null
                //getWindowToken() 현재페이지 정보
            }
        });

        return view;
    }
}