package com.example.medical_application;

public class user_database {
    public  String fullname ,email, password ,governorate,city,age,length,weight,diseases,gender,bloodType;
    public user_database(){}
    public user_database(String fullname , String email,String password , String governorate, String city, String age, String length, String weight, String diabetic, String bloodPressure, String heartPatient, String diseases, String gender, String bloodType)
    {
        this.fullname=fullname;
        this.email=email;
        this.password=password;
        this.governorate=governorate;
        this.city=city;
        this.age=age;
        this.length=length;
        this.weight=weight;

        this.diseases=diseases;
        this.gender=gender;
        this.bloodType=bloodType;
    }

}
