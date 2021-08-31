package com.example.ex0728;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterClass extends BaseAdapter {//BaseAdapter상속받기
    private Context context; //inflater를 추출하기 위해
    private LayoutInflater inf; //xml을 눈에 보이게하는 도구
    private int layout; //템플릿
    private ArrayList<VOclass>data;//데이터

//생성자
    public AdapterClass(Context context, int layout, ArrayList<VOclass> data) {//context,layout,data외부에서 받아올수있게
        this.context = context;
        this.inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
        this.data = data;
    }

    @Override
    public int getCount() {//listview항목 개수 지정 ,//데이터의 개수 만큼 리스트뷰를 표현하겠다.
        return data.size();
    }

    @Override
    public Object getItem(int position) {//position번째 data변환
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {//position번째 id변환
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){ //이전에 뷰가 없다면,최초로 실행되는 거라면
           convertView = inf.inflate(layout,parent,false);
           //독립적인 객체로 동작할 거니깐 false

       }

        TextView tv_title = convertView.findViewById(R.id.tv_title);//제목
       tv_title.setText(data.get(position).getTitle());
       TextView tv_url = convertView.findViewById(R.id.tv_url); //주소
        tv_url.setText(data.get(position).getAddress());

        //go버튼 누르면 해당 url로 바로가기
        Button btn_go = convertView.findViewById(R.id.btn_go);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(tv_url.getText().toString()));
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(data.get(position).getAddress()));


                // Adapter에서 startActivity 호출 할 수 없음... startActivity는 Activity만 가능
                // MAinActivity에서 전달해준Context객체의 도움을 받아서 startActivity실행!

                // 현재 실행중인 Activity는 TASK에 쌓임
                //  Adapter는 TASK에 쌓인 상태가 아님...

                //그래서 Intent를 실행시킬 때(ACTION_VIEW를 실행하고자 할 때)
                // 새로운 TASK를 만들고 실행시키면 됨
                it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //flags -intent로 줄 수 있는 옵션
                //새로운 액티비티를 테스크에 실행하겠다.
                context.startActivity(it);
            }
        });


        return convertView;//만들어진 뷰 리턴
    }
}
