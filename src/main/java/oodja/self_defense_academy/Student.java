package oodja.self_defense_academy;

import java.util.Date;

public class Student {
    String sid;
    String name;
    String email;
    String address;
    String phone_num;
    String role;
    Date date_registered;
    String password;

    public Student(String sid, String name, String email, String address, String phone_num, String role, Date date_registered, String password){
        this.sid = sid;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone_num = phone_num;
        this.role = role;
        this.password = password;
    }

    // your code goes here
}
