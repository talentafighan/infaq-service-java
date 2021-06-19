package com.example.infaqservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    private long userId;

    @NotBlank
    @Size(min = 1, max = 255, message = "Username has exceeded the limit")
    private String username;

    @NotBlank
    @Size(min = 1, max = 255, message = "Password has exceeded the limit")
    private String password;

    @NotBlank
    @Size(min = 1, max = 255, message = "Email has exceeded the limit")
    private String email;

    @NotBlank
    @Size(min = 1, max = 255, message = "Mobile Phone Number has exceeded the limit")
    private String mobilePhoneNumber;

    @NotBlank
    @Size(min = 1, max = 255, message = "User Type has exceeded the limit")
    private String userType;

    public User(){
    }

    public User(String username, String password, String email, String mobilePhoneNumber, String userType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.userType = userType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "mobile_phone_number", nullable = false)
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    @Column(name = "user_type", nullable = false)
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
