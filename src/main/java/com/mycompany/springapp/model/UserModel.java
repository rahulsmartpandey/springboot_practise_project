package com.mycompany.springapp.model;

import javax.persistence.*;

@Entity(name="USER_TABLE")
public class UserModel {

    @Column(name="USER_NAME")
    private String userName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private Long userId;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="EMAIL")
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
