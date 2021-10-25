//package com.growingmom.project.auth.entity;
//
//import lombok.Builder;
//import lombok.Getter;
//import lombok.ToString;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.redis.core.RedisHash;
//
//@ToString
//@Getter
//@RedisHash("login-token")
//public class RedisToken {
//
//    @Id
//    String email;
//
//    String token;
//
//    @Builder
//    public RedisToken(String email, String token) {
//        this.email = email;
//        this.token = token;
//    }
//}
