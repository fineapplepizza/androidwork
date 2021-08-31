package com.example.ex0727;

public class PhoneVO {
    // ValueObject 만들 때 필요한 것
    // 1.필드(변수, 클래스변수) : VO에 저장하고 싶은 자료들
    private int imgID;
    private String name;
    private String number;

    // 2. 생성자 : 객체 생성할 때 저장될 데이터를 전달받음

    public PhoneVO(int imgID, String name, String number) {
        this.imgID = imgID; //매개변수로 전달받은 아이디를 필드변수 아이디에 저장해라
        this.name = name;
        this.number = number;
    }

    // 3. get/set 메소드 : 데이터를 수정하거나 꺼낼 때 사용되는 메소드


    public int getImgID() {
        return imgID;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
