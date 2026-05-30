package com.example.ejb;

import jakarta.ejb.Singleton;

@Singleton // Chỉ có DUY NHẤT một instance được chia sẻ cho toàn bộ ứng dụng
public class VisitorCounterEJB {

    private int count = 0; // Biến lưu trữ số lượt truy cập

    // Đồng bộ hàm để tránh xung đột dữ liệu khi nhiều người truy cập cùng lúc
    public synchronized int incrementAndGet() {
        count++;
        return count;
    }
}