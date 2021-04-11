package com.example.medical_application;

public class Item {
    private int image1; private String txt1; private String txt2; private String  txt3; private String  txt5;

    public Item(int image1, String txt1, String txt2, String txt3, String txt5) {
        this.image1 = image1;
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.txt3 = txt3;
        this.txt5 = txt5;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }

    public String getTxt3() {
        return txt3;
    }

    public void setTxt3(String txt3) {
        this.txt3 = txt3;
    }

    public String getTxt5() {
        return txt5;
    }

    public void setTxt5(String txt5) {
        this.txt5 = txt5;
    }
}

