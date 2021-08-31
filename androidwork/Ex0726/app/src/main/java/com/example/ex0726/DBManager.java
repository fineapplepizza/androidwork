package com.example.ex0726;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBManager {//데이터 접근하는 일

    DBHelper helper;//DBHelper변수 선언

    public DBManager(Context context){
        helper = new DBHelper(context);
    }
     //DBManager도 context정보가 없어서 DBhelper에게 줄 수 가 없음 (DBhelper를 생성할 떄 context정보를 받아야함)
    //그래서 DBManager생성자도 외부에서 받아올 수 있게 Context 매개변수를 만들어서 이 정보를 DBHelper에게 전달 할 수 있다.

    public void insert(String msg) {
        SQLiteDatabase db = helper.getWritableDatabase();//입력하기위해서
        //getreadableDatabase 가지고 오고 싶을때
        db.execSQL("insert into chat values('"+msg+"')");
        //exeSQL-전송하고 끝날 때 사용

    }



    // DataBase의 모든 정보를 반환하는 메소드 생성!
    // 메소드 설계할 때는 input, output 결정하기!
    // input : x (작업을 처리하기 위해서 외부에서 줘야하는 데이터)-모든정보를 다 돌려받아야하니깐 x
    // output: msg(String타입의 데이터)을 담을건데!몇개인지 모름..ArrayList<String>
    // 몇개인지 알때 배열
    public ArrayList<String>getAllMsg(){
        ArrayList<String> temp = new ArrayList<>(); //모든 메세지를 저장할 ArrayList

        // 1. select 쿼리문 전송
        SQLiteDatabase db = helper.getReadableDatabase();//읽을려고
        Cursor cursor=db.rawQuery("select * from chat",null);
        //rawQuery - 돌려받을게 있을 때, selectionArgs: java의 preparesatement기능

        //2. cursor 한칸씩 옮기면서 데이터 읽어오기

        //moveToNext(): Cursor를 다음칸으로 이동하며 데이터가 있으면 true,없으면 flase
         while(cursor.moveToNext()){ //다음 데이터가 없을 때 까지
             String msg = cursor.getString(0); //현재 가리코 있는 그 줄 읽어라
             temp.add(msg); // arrayList에 차곡차곡 저장하기기
         }

       return temp;
    }

}
