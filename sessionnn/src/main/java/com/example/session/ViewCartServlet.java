package com.example.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewCart")
public class ViewCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        out.println("<h2>Giỏ hàng của bạn</h2>");
        if (session != null) {
            List<String> cart = (List<String>) session.getAttribute("cart");
            if (cart != null && !cart.isEmpty()) {
                out.println("<ul>");
                for (String item : cart) {
                    out.println("<li>" + item + "</li>");
                }
                out.println("</ul>");
            } else {
                out.println("<p>Giỏ hàng của bạn đang trống.</p>");
            }
        } else {
            out.println("<p>Giỏ hàng của bạn đang trống.</p>");
        }
        out.println("<a href='shopping.html'>Tiếp tục mua sắm</a>");
    }
}