package com.example;

import jakarta.ejb.Stateless;

@Stateless
public class HelloBean {

    public String sayHello(String name) {
        return "Xin chào " + name + "! Bạn đã gọi Enterprise Bean thành công.";
    }
}