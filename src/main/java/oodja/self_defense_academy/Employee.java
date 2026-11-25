package oodja.self_defense_academy;

public abstract class Employee {
    private String eid;
    private String name;
    private String email;
    private String address;
    private String phonenum;
    private String role;
    private String password;
    

    public Employee(String eid, String name, String email, String address, String phonenum, String role, String password) {
        this.eid = eid;
        this.name = name;
        this.email = email;
        this.address = address;
        this.role = role;
        this.phonenum = phonenum;
        this.password = password;
    }

    // Getters 
    public String getEID(){ return eid;}
    public String getName(){ return name;}
    public String getEmail(){ return email;}
    public String getAddress(){ return address;}
    public String getPhoneNumber(){ return phonenum;}
    public String getRole(){ return role;}
    public String getPass(){return password;}


}
