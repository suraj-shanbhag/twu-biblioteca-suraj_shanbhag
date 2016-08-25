package com.twu.biblioteca;

/**
 * Created by Suraj on 25-08-2016.
 */
public class Member {
    private String member_id;
    private String name;
    private String email;
    private String address;
    private String phone_number;
    private String password;

    public String getMember_id() {
        return member_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }

    public Member(String member_id, String name, String email, String address, String phone_number, String password) {
        this.member_id = member_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.password=password;
    }
}
