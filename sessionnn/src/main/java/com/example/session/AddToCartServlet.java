package com.example.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Lấy giỏ hàng từ session.
        List<String> cart = (List<String>) session.getAttribute("cart");
        
        // Nếu chưa có giỏ hàng (lần đầu thêm), tạo mới.
        if (cart == null) {
            cart = new ArrayList<>(); 
        }

        // Thêm sản phẩm mới vào đối tượng cart trong bộ nhớ.
        String newItem = request.getParameter("item");
        if (newItem != null && !newItem.isEmpty()) {
            cart.add(newItem);
        }

        // QUAN TRỌNG: Lưu lại đối tượng cart đã được cập nhật vào session.
        session.setAttribute("cart", cart);

        // Chuyển hướng người dùng đến trang xem giỏ hàng.
        response.sendRedirect("viewCart");
    }
}