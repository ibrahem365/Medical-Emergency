package com.example.medical_application.EmerNum;

public class Number {
    private int phoneId;
    private int name;
    private int pNum;
    private int imageResourceId;

    public Number(int phoneId,int name,int pNum,int iRI){
        this.phoneId = phoneId;
        this.name = name;
        this.pNum = pNum;
        this.imageResourceId = iRI;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public int getName() {
        return name;
    }

    public int getpNum() {
        return pNum;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

}