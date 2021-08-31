package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_splash_main2.*

class SplashMainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_main2)



        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable { //클릭을 하지않고 3초정도 있을때 자동으로 mainActivity에 넘어가는 코딩
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(runnable,3000)//Runnable 코드블럭 객체 전달, delayMillis는 지연시간

        animationView.setOnClickListener{
            //메인 엑티비티로 이동
            handler.removeCallbacks(runnable) //클릭하면 runnable이라는 콜백을 삭제해서 3초가 실행이 안됨
                                               //콜백이 제거되어 또한번 메인액티비티가 뜨는것을 방지할 수있음
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish() //fininsh 하지않으면 메인엑티비티화면에서 다시 이전것을 눌렀을때 스플레쉬화면으로 보여진다.
        }


    }
}