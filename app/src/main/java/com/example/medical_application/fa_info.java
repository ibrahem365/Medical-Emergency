package com.example.medical_application;

import java.util.Collection;

public class fa_info {
    private int name;
    private int img;

    public fa_info(int img,int name) {

        this.img = img;
        this.name=name;
    }
    public void setName(int name) {

        this.name = name;
    }

    public int getName() {

        return name;
    }

    public void setImg(int img) {

        this.img = img;
    }

    public int getImg() {

        return img;
    }



}
