package com.example.ex0726;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {//본인이 알아서 DB파일 만들고 테이블 생성
    //1.SQLiteOpenHelper 상속 - 안드로이드에서 내장DB를 만들기위해서 필요한 메소드(기능)들을 다 정리한 클래스 파일
    //안드로이드 제공하는 DB- SQLite

    // 상속할 때 부모에 생성자가 있으면??
    // 생성자란?
    // 객체 생성할 때 함께 호출되는 메소드!
    // 메소드의 이름이 클래스의 이름과 같고 반환형이 없음(return없음)
    // 반드시 생성자 오버라이딩 해줘야함!

    //DBHelper가 하는 일
    // - 데이터베이스 생성, 테이블생성, 연결된 DataBase 객체 가져오기


    public DBHelper( Context context) { //void 없으면 생성자,
        // 뒤에 있는 매개변수 3개는 지워도 상관없음(Context말고 나머지는 클래스안에서 처리가 가능함)
        //@Nullable 생략가능하다는 표기 (지워도 상관없음)
        super(context, "chatDataBase.db", null, 1);//대부분 null로 쓰면 해결됨
        // context => 화면 정보(Activity만 가질 수 있음)
        // name => DataBase파일 이름
        // factory => 그 커서가 있다면 넣어라->아무것도 안넣을 거기 때문에 null
        // version => DB버전

        //생성자가 하는일: 정해진 DataBase 생성하고 App과 연결~
        //super하면서 부모의 생성자를 호출 현재 부모인 SQLiteopenhelper가 생성되었기 때문에
        // SQLiteopenhelper안에서 알아서 연결이랑 생성을 다알아서 해줌

        //DBHelper 클래스는 화면정보를 가지고 있지않음 Activity가 DBHelper에게 화면정보를 줘야
        // (context정보를 외부에서 받아와야함)->그래서 매개변수로 남겨둠(Activity에서 정보 받아올려고)
        //
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 테이블 생성 ~
        // 매개변수 SQLiteDataBase를 통해 create 데이터 전송~
        db.execSQL("create table chat(msg varchar2(50))");
        //execSQL-쿼리문장 전송하는 명령어

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//핸드폰 내에서 자동으로 업데이트
        // 혹시 DataBase버전이 업데이트 되면 호출되는 메소드
        // 개발자 입장에서 table구조가 변경된 경우에 호출
        db.execSQL("drop table chat");//지금 테이블 삭제
        onCreate(db);//새로운 테이블 생성
        //테이블 구조가 변경됐으면 지금 테이블 삭제하고 새로운 테이블로 만들어라라
    }


}