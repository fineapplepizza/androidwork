package com.example.ex0803;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Fragment3 extends Fragment {

    // 두더지가 9마리 =>ImageView 9개 => findViewById를 9번!
    // for문 돌려서 findViewById 하는 법!
    ImageView[] dodo = new ImageView[9]; //ImageView 9개가 저장될 배열!
    int score = 0 ; //내가 잡은 두더지 수 저장~
    TextView tv_score, tv_time;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        tv_score = view.findViewById(R.id.tv_score);//스코어
        tv_time = view.findViewById(R.id.tv_time);

        new timeThread().start();//초 세기 시작!
        // for문 돌려서 findViewById하기!
        for(int i = 0; i<dodo.length; i++){
            int id = getResources().getIdentifier("imageView" + (i+1),"id",getActivity().getPackageName());//string으로 주소값 찾는 방법
            //문자열이랑 똑같은 아이디를 찾아서 주소를 정수형으로id를 반환해줌

            dodo[i] = view.findViewById(id);

            // 모든 두더지 올라오게
//            dodo[i].setImageResource(R.drawable.on);
            DodoThread tt = new DodoThread(i);
            tt.start();

            // 두더지 클릭했을 때 올라온 두더지? 내려간 두더지? 판별하기!
            // view에 태그를 달아서 구분지을 수 있음!
            dodo[i].setTag("off"); //처음 시작할때는 모든 두더지가 off 태그!

            // 두더지 클릭 감지!
            dodo[i].setOnClickListener(new View.OnClickListener() {//i번째 두더지를 클릭했을때
                @Override
                public void onClick(View v) {
                    // 매개변수 v => 이벤트가 발생한 view => 내가 클릭한 두더지!
                    if(v.getTag().toString().equals("on")){//지금내가 클릭한 두더지의 태그값을 가지고 와서 string으로 바꿨는데 문자열on과 같다면
                        Toast.makeText(getContext(),"잡았다",Toast.LENGTH_SHORT).show();
                        score++;
                        tv_score.setText(score+"");
                       v.setTag("off");
                    }
                }
            });


        }



        return view;
    }


    Handler handler = new Handler(){
        @Override
        public void handleMessage( Message msg) {
            dodo[msg.arg1].setImageResource(msg.arg2);//msg.arg1번째 두더지에다가 arg2에 해당하는 이미지를 셋하겠다.
            dodo[msg.arg1].setTag(msg.obj.toString());//msg.arg1 번째 두더지 태그 바꾸기(on/off)
        }
    };


    // 두더지 움직이게 만드는 Thread 설계해서
    // 알고리즘 구현해보기

    class DodoThread extends Thread{
        private int index; // 담당 두더지 번호

        public DodoThread(int index){
            this.index = index;
        }



        @Override
        public void run() {
            while(true){ // 영원히 멈추지 않는 두더지
                int offTime = new Random().nextInt(5000)+500;//0.5~1.5초만큼 랜덤하게 들어가 있음

                try {
                    Thread.sleep(offTime); // offTime 만큼 쉰다.

                    // offTime 만큼 쉬었으니 on이미지로 바꿔야함
                    // but 이곳은 MainThread가 아니기 때문에 이미지를 바꿀 수 없음.... => Handler가 필요함!
                    // Message를 전송해서 두더지 이미지를 바꿔달라 요청!

                    // 두더지 이미지를 바꾸기 위해 볓번째 두더지인지 index를 전송 !
                    Message msg = new Message();
                    msg.arg1 = index; //바꿀 두더지 번호!
                    msg.arg2 = R.drawable.on; // 바꿀 이미지 ~
                    msg.obj = "on"; //바꿀 태그 ~


                    handler.sendMessage(msg);//메세지 전송~

                    //나온 상태로 쉬게 만들기
                    int onTime = new Random().nextInt(1000)+500; //0.5 ~ 1.5만큼 올라와 있음!

                    Thread.sleep(onTime); //onTime만큼 쉰다.

                    // new 하는 이유? 한번 전송한 메세지는 재활용 할 수 없음!
                    msg = new Message();
                    msg.arg1 = index;
                    msg.arg2 = R.drawable.off;
                    msg.obj = "off";
                    handler.sendMessage(msg);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    Handler timeHandler = new Handler(){
        @Override
        public void handleMessage( Message msg) {
         // tv_time 에 setText
            tv_time.setText(msg.arg1+"");

        }
    };

    class timeThread extends Thread{
        @Override
        public void run() {
            for(int i = 60;i>=0;i--){// 30~0까지
                Message msg = new Message();
                msg.arg1 = i;
                timeHandler.sendMessage(msg);

                try {
                    Thread.sleep(1000);//1초에 한 번 쉬게
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }



        }
    }

}