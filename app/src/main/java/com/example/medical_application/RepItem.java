package com.example.medical_application;

public class RepItem {
    private String patName,repType,locaTxt,mTxt,wTxt,chTxt;

    public RepItem(String patName, String repType, String locaTxt, String mTxt, String wTxt, String chTxt) {
        this.patName = patName;
        this.repType = repType;
        this.locaTxt = locaTxt;
        this.mTxt = mTxt;
        this.wTxt = wTxt;
        this.chTxt = chTxt;
    }

    public RepItem(){

    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getRepType() {
        return repType;
    }

    public void setRepType(String repType) {
        this.repType = repType;
    }

    public String getLocaTxt() {
        return locaTxt;
    }

    public void setLocaTxt(String locaTxt) {
        this.locaTxt = locaTxt;
    }

    public String getmTxt() {
        return mTxt;
    }

    public void setmTxt(String mTxt) {
        this.mTxt = mTxt;
    }

    public String getwTxt() {
        return wTxt;
    }

    public void setwTxt(String wTxt) {
        this.wTxt = wTxt;
    }

    public String getChTxt() {
        return chTxt;
    }

    public void setChTxt(String chTxt) {
        this.chTxt = chTxt;
    }
}
