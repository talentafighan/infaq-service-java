package com.example.infaqservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class TemporaryToken {
    private long userId;

    @NotBlank
    @Size(min = 1, max = 255, message = "Token has exceeded the limit")
    private String token;

    private Date expiredDate;

    public TemporaryToken() {
    }

    public TemporaryToken(String token, Date expiredDate) {
        this.token = token;
        this.expiredDate = expiredDate;
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

    @Column(name = "token", nullable = false)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "expired_date", nullable = false)
    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return "TemporaryToken{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", expiredDate=" + expiredDate +
                '}';
    }
}
