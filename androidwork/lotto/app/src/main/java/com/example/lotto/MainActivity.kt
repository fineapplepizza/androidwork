package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //6개의 텍스트뷰를 같은 어레이리스트를 만듬
        val lotteryNumbers = arrayListOf(number1, number2, number3, number4, number5, number6)

        val countDownTimer = object:CountDownTimer(3000,100){
            //3초짜리 타이머를 지정하고 100밀리 센컨드마다 작업하겠다.

            override fun onFinish() { //타이머가 다했을때 호출
            }
            override fun onTick(p0: Long) {
                //100밀리 세컨드마다 호출되면서 전체3초중에 얼마나 남았는지가 파라미터로 전달
                lotteryNumbers.forEach {
                    val randomNumber = (Math.random() * 45 + 1).toInt() //Integer형태로 변환
                    it.text = "$randomNumber"
                }
            }
        }

        lotteryButton.setOnClickListener {
            if (lotteryButton.isAnimating){//클릭했을때 동작하고 있는지 아닌지 알기위해서
                //동작하는 중이라면
                lotteryButton.cancelAnimation() //애니메이션 멈춤
                countDownTimer.cancel() //타이머 취소

            }else{//동작하고 있는 중이 아니라면
                lotteryButton.playAnimation()//클릭했을때 애니메이션이 실행이됨
                countDownTimer.start()

            }

        }
    }
}