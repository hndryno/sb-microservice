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
}
