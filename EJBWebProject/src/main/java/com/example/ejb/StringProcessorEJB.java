package com.example.ejb;

import jakarta.ejb.Stateless;

@Stateless // EJB không trạng thái, dùng xong là giải phóng
public class StringProcessorEJB {

    public String processName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Vui lòng nhập tham số ?name= trên URL!";
        }

        // 1. Chuyển thành in hoa
        String upperName = name.toUpperCase();

        // 2. Đếm số ký tự (loại bỏ dấu cách)
        long charCount = name.replace(" ", "").length();

        // 3. Trả về chuỗi kết quả
        return "Xin chào " + upperName + ", tên của bạn có " + charCount + " ký tự!";
    }
}