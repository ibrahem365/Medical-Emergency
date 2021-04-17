package com.example.medical_application;

public class para_medic_database {

    public  String fullname ,email, password ,governorate,city,numambulancs,numbeds,numcarerooms;
    public para_medic_database()
    {}
    public para_medic_database(String fullname,String email,String password,String governorate,String city,String numambulancs,String numbeds,String numcarerooms )
    {
        this.fullname=fullname;
        this.email=email;
        this.password=password;
        this.governorate=governorate;
        this.city=city;
        this.numambulancs=numambulancs;
        this.numbeds=numbeds;
        this.numcarerooms=numcarerooms;

    }

}
