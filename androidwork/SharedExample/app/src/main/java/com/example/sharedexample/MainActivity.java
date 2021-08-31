package com.example.sharedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save ;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {//앱이 죽은다음에 다시 틀면 OnCreate로 재생,불러오는 부분
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save); //id값을 java파일에 연결

        SharedPreferences sharedPreferences =  getSharedPreferences(shared,0);//SharedPreferences 선언
        String value = sharedPreferences.getString("hong",""); //앱이 죽었을때 저장한이름,꺼내오기때문에 빈값
        et_save.setText(value); //value를 setText

    }
    @Override
    protected void onDestroy() {//앱이죽었을때 ,저장부분
        //뒤로가기해서 나가면 onDestroy이로 호출 그럴때 SharedPreferences 저장할 수 있게
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();//sharedPreferences안에 editor연결
                //저장할때 Editor를 불러와야한다.
        String value = et_save.getText().toString();
        editor.putString("hong",value);//putString형태로 저장 hong이라는 이름으로 value값을 저장하겠다.
        editor.commit();//save를 완료해라

    }

}
//sharePreferences는 임시저장- 앱이 삭제되면 데이터가 없음