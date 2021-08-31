package com.example.ex0720;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {
    // (1)TextView를 클릭하면 (2)회원가입 페이지로 이동한다!
    TextView tv_join;
    //로고를 클릭하면
    ImageView img_down;
    // 카메라를 실행합니다.
    TextView tv_camera;
    // 전화 거는거
    TextView tv_call;
    //로그인 버튼
    Button btn_login;

    EditText edt_id,edt_pw; // 아이디 비밀번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //View가 어디에 있는지 찾아옴
        tv_join = findViewById(R.id.tv_join); //보통은 findViewById()는 setContentView아래에다가 몰아서 씀
        img_down = findViewById(R.id.img_down); //카카오 다운
        tv_camera = findViewById(R.id.tv_camera); //카메라
        tv_call = findViewById(R.id.tv_call); // 전화 거는 거
        btn_login = findViewById(R.id.btn_login); // 로그인 버튼
        edt_id = findViewById((R.id.edt_id)); //아이디
        edt_pw = findViewById(R.id.edt_pw); //비밀번호

        tv_join.setOnClickListener(new View.OnClickListener() { //TextView를 클릭했을때
            @Override
            public void onClick(View v) {
                // 회원가입페이지로 이동한다!
                Intent it_kakao = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.kakao.com/weblogin/create_account?continue=https%3A%2F%2Faccounts." +
                        "kakao.com%2Fweblogin%2Faccount%2Finfo")); // Intent(화면과의 이동과 데이터 전달)
                //ACTION_VIEW- 무언가를 보여줘라,Intent가 취해야할 행동
                //uri- 이 주소를 보여줘라 ,이 일을 수행함으로 써 실행하는 것
                //Intent객체를 실행해주기 위해서
                startActivity(it_kakao);
            }
        });

        img_down.setOnClickListener(new View.OnClickListener() {//로고를 클릭했을때
            @Override
            public void onClick(View v) {
                //Intent -> 액션+데이터
                Intent it_down = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.kakao.talk"));
                //패키지 이름을 가진 어플이 있는지 없는 감지해서 없으면 다운받는 주소로 이동
                //모든 어플에는 자기 고유 패키지가 있다.
                startActivity(it_down); //startActivity : Intent실행시켜주는 것
            }
        });

        tv_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//카메라를 실행시키는 액션!
                // 이번에는 데이터 없이 액션만 지정
                startActivity(it_camera);
            }
        });
        tv_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //바로 전화건다!!



                // 권한 부여받기~!!
                // 1. Manifest 파일을 열어서 권한(Permission)부여 소스코드를 입력한다.
                // => <uses-configuration android:name="android.permission.CALL_PHONE"/>
                // 2. 권한(Permission)을 허용해 달라는 alert 창을 띄운다.
               //권한부여코드 권한이 있으면 0 없으면 다른 숫자
                //권한요청 그대로 쓰는 코드인데 응용할때는 CALL_PHONE자리만 바꾸면됨
                if(ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.CALL_PHONE) != 0){ // 현재 CALL_PHONE 권한이 없다면
                    // 권한 요청
                    ActivityCompat.requestPermissions(MainActivity3.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            0);
                }else{ // 현재 CALL_PHONE 권한이 있다면!
                    //Uri.parse-String데이터를 가지고 Uri객체로 만들어주는 메소드
                    Intent it_call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01092340920"));
                    //주의사항 tel 소문자 : 앞뒤띄어쓰기 없고 전화번호 - 없음 minetype?
                    startActivity(it_call);

                }


            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그인 버튼 눌렀을 때!
                //로그인기능 구현하기 (다른 페이지로 이동하기)
                //1단계) 무조건 다음페이지로 이동!
                //2단계) 아이디랑 비밀번호 일치하면 이동!
                //내가 어떠한 문제를 해결하기 위해서 절차를 생각해보는 것 (알고리즘,플로우차트)
                // -> 버튼을 눌렀을 때! => findViewById, setOnClickListener
                // -> 위(EditText)에 적혀있는 아이디와 비밀번호를 가져와서
                // ★★ EditText findViewById 해야함
                String id=edt_id.getText().toString(); //글자를 정확하게 가져올려면 toString()까지, 아이디 가져오기
                String pw=edt_pw.getText().toString(); //비밀번호 가져오기
                //getText로만 가져오면 캐릭터배열이라는 타입으로 가져온다. 그래서 문자열로 타입을 변환해야한다.
                //원리를 알고 개발해야한다.
                // 이게 왜 되는지 알아야함
                // -> 내가 설정해둔 아이디/비밀번호와 일치한다면
                if(edt_id.getText().toString().equals("eowls") && pw.equals("1214")){

                    //3단계) 다음페이지에서 ____님 환영합니다!
                    // => MainActivity에서 ResultActivity로 데이터 보내기
                    // => Intent에 데이터 담아서 보내기~~~

                    // -> 다음 페이지로 넘긴다!
                    Intent it_login = new Intent(MainActivity3.this,ResultActivity.class);
                    //출발 지점이랑 도착지점을 적어주면됨(출발지에는 this 도착지에는 class)적어주면됨

                    it_login.putExtra("id", id); //intent에 'id'라는 키값으로 id변수 담아줌!
                    // 만약 pw도 보내주고 싶다면???
                    // putExtra 여러번 쓰면 됨~~
                    startActivity(it_login);
                }else{
                    Toast.makeText(getApplicationContext(),"일치하지 않습니다!",
                            Toast.LENGTH_SHORT).show();
                }
                // EditText 쓸 때 자주 실수하는 것들
                // 1.언제 getText 해야하는지 잘 판단할 것
                // 2. equals 비교할 때 반드시 getText한 값과 비교할 것

                // Toast 메세지 쓸 때 자주 실수하는 것
                // 1. show()!!!!
                // 2. 괄호 잘 볼 것




            }
        });
    }

}
//기기 //현재사용되는 어플//상태
//error창에 경고도 뜨기때문에 어플이 중지되는거 아 니면 크게 신경쓸 필요가 없음