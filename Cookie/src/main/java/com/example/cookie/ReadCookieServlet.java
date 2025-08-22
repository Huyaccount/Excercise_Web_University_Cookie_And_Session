
package com.example.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Lấy mảng tất cả các cookie từ request
        Cookie[] cookies = request.getCookies();
        String userName = null;

        if (cookies != null) {
            // Lặp qua mảng để tìm cookie có tên là "user_name"
            for (Cookie c : cookies) {
                if (c.getName().equals("user_name")) {
                    userName = c.getValue();
                    break;
                }
            }
        }

        if (userName != null) {
            out.println("<h2>Xin chào, " + userName + "!</h2>");
            out.println("<p>Thông tin này được đọc từ cookie.</p>");
        } else {
            out.println("<h2>Không tìm thấy cookie 'user_name'!</h2>");
            out.println("<p>Vui lòng quay lại trang trước để tạo cookie.</p>");
        }
        out.println("<a href='index.html'>Quay về trang chủ</a>");
    }
}