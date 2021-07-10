package com.example.medical_application.FirstAid;

import java.util.Collection;

public class fa_info {
    private int name;
    private int img;
    private int disc;


    public fa_info(int img, int name,int disc) {

        this.img = img;
        this.name=name;
        this.disc=disc;
    }

    public int getDisc() {
        return disc;
    }

    public void setDisc(int disc) {
        this.disc = disc;
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
