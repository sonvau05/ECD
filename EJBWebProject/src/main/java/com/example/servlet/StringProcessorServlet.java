package com.example.servlet;

import com.example.ejb.StringProcessorEJB;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/process-string") // Đường dẫn URL truy cập
public class StringProcessorServlet extends HttpServlet {

    @EJB // Nhúng EJB vào Servlet tự động
    private StringProcessorEJB stringProcessorEJB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        // Lấy tham số 'name' từ URL (?name=...)
        String nameParam = req.getParameter("name");

        // Gọi EJB xử lý
        String result = stringProcessorEJB.processName(nameParam);

        // In kết quả ra trình duyệt
        resp.getWriter().println("<h2>" + result + "</h2>");
    }
}