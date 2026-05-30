package com.example.servlet;

import com.example.ejb.VisitorCounterEJB;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home") // Đường dẫn URL truy cập trang chủ
public class HomeServlet extends HttpServlet {

    @EJB
    private VisitorCounterEJB visitorCounterEJB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        // Tăng biến đếm và lấy giá trị mới từ Singleton EJB
        int currentCount = visitorCounterEJB.incrementAndGet();

        // Hiển thị ra màn hình
        resp.getWriter().println("<h1>Bạn là người thứ [" + currentCount + "] truy cập vào trang web này.</h1>");
    }
}