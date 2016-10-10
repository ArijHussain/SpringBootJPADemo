package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Arij Hussain on 10/7/2016.
 */
@Entity
@Table(name = "userinfo")
public class AppUser {

    @Id
    private Integer userId;

    @NotNull
    private String name;

    @NotNull
    private String userType;

    @NotNull
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
