package com.example.ex0728;

public class VOclass {//바로가기 정보를 담은 VO
    private String title; //제목
    private String address; //주소

    //생성자
    public VOclass(String title, String address) {
        this.title = title;
        this.address = address;
    }

    //get메소드
    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }
}
