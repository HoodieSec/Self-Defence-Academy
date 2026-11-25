package oodja.self_defense_academy;

public class manager extends Employee{
    public manager(String eid, String name, String email, String address, String phonenum, String password) {
        super(eid, name, email, address, phonenum, "manager", password);
    }
}
