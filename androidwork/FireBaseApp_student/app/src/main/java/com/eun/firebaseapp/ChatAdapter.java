package com.eun.firebaseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<ChatVO> data;
    private LayoutInflater inflater;
    private String loginId;

    public ChatAdapter(Context context, int layout, ArrayList<ChatVO> data,String loginId) {
        //chatAdapter는 ACtivity가 아니기 때문에 생성자를 통해서 loginId전달
        this.context = context;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.loginId = loginId; //현재 로그인 한 아이디
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {//항목 한 줄을 그리는 일
        if (view == null){
            view = inflater.inflate(layout, viewGroup, false);
        }

        TextView tv_myMsg = view.findViewById(R.id.tv_mymsg);
        TextView tv_myTime = view.findViewById(R.id.tv_mytime);
        TextView tv_msg = view.findViewById(R.id.tv_msg);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_time  =view.findViewById(R.id.tv_time);
        ImageView img = view.findViewById(R.id.img);

        ChatVO temp = data.get(i);//i 번째 카톡 내용이 temp에 들어있다.

        if(temp.getName().equals(loginId)){//내가 보낸 카톡이라면
            tv_myMsg.setVisibility(View.VISIBLE);//오른쪽 msg보이게 설정
            tv_myTime.setVisibility(View.VISIBLE);

            tv_msg.setVisibility(View.GONE);// 왼쪽 msg는 지워버린다.
            tv_name.setVisibility(View.GONE);
            tv_time.setVisibility(View.GONE);
            img.setVisibility(View.GONE);

            tv_myMsg.setText(temp.getMsg()); // 오른쪽에 있는 textView에 카톡 내용 띄운다.
            tv_myTime.setText(temp.getTime()); // 오른쪽에 있는 textView에 카톡 시간띄운다.

        }else{ // 로그인한 사람이 보낸 카톡이 아닐 경우에
            tv_myMsg.setVisibility(View.GONE);//오른쪽 msg보이게 지운다
            tv_myTime.setVisibility(View.GONE);

            tv_msg.setVisibility(View.VISIBLE);// 왼쪽 msg는 띄운다.
            tv_name.setVisibility(View.VISIBLE);
            tv_time.setVisibility(View.VISIBLE);
            img.setVisibility(View.VISIBLE);

            tv_msg.setText(temp.getMsg());
            tv_name.setText(temp.getName());
            tv_time.setText(temp.getTime());
            img.setImageResource(temp.getImg());
        }


        return view;
    }
}
