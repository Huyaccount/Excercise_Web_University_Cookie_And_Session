package com.example.session;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/destroySession")
public class SessionDestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            session.invalidate();
            response.getWriter().println("<h3>Session đã được hủy.</h3>");
        } else {
            response.getWriter().println("<h3>Không có session nào để hủy.</h3>");
        }
        response.getWriter().println("<a href='session-example1.html'>Quay lại ví dụ 1</a>");
    }
}