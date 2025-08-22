package com.example.session;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/readSession")
public class SessionReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("loggedInUser") != null) {
            String user = (String) session.getAttribute("loggedInUser");
            response.getWriter().println("<h3>Đọc từ Session: Chào mừng, " + user + "!</h3>");
        } else {
            response.getWriter().println("<h3>Không có session hoặc session không chứa thông tin người dùng.</h3>");
        }
        response.getWriter().println("<a href='session-example1.html'>Quay lại ví dụ 1</a>");
    }
}