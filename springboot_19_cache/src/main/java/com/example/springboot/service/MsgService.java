package com.example.springboot.service;

public interface MsgService {
    String get(String tele);

    boolean check(String tele, String code);
}
