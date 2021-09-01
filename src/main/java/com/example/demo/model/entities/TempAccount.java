package com.example.demo.model.entities;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash(value="account", timeToLive = 3600) //valuenya diset 1 jam
public class TempAccount {
    @Id
    private String id;
    private String email;
    private boolean valid = false;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isValid() {
        return valid;
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
