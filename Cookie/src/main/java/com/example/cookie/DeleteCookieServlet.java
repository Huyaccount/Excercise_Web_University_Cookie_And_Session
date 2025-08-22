package com.example.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCookie")
public class DeleteCookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Tạo một cookie có CÙNG TÊN với cookie muốn xóa
        Cookie cookieToDelete = new Cookie("user_name", "");
        
        // Đặt thời gian sống của nó về 0
        cookieToDelete.setMaxAge(0);
        
        // Thêm cookie vào response để gửi lệnh xóa về trình duyệt
        response.addCookie(cookieToDelete);
        
        out.println("<h3>Đã gửi yêu cầu xóa cookie 'user_name'!</h3>");
        out.println("<a href='index.html'>Quay về trang chủ</a>");
    }
}