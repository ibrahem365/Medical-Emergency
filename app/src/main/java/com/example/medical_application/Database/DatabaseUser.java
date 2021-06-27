package com.example.medical_application.Database;

public class DatabaseUser {
    public  String email,password ,typeUser;
    public DatabaseUser(){};
    public DatabaseUser(String email,String password,String typeUser)
    {
        this.email=email;
        this.password=password;
        this.typeUser=typeUser;

    }
//    public void setEmail(String email)
//    {
//        this.email=email;
//    }
//    public void setPassword(String password)
//    {
//        this.password=password;
//    }
//    public void setUserType(String typeUser)
//    {
//        this.typeUser=typeUser;
//    }
//    public String getEmail()
//    {
//        return email;
//    }
//    public String getPassword()
//    {
//        return password;
//    }
//    public String getTypeUser()
//    {
//        return typeUser;
//    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }
}
