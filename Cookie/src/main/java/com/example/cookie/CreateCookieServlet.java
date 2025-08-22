package com.example.cookie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    // 1. Lấy giá trị từ form
    String userName = request.getParameter("username");

    // 2. Tạo một đối tượng Cookie
    Cookie userCookie = new Cookie("user_name", userName);

    // 3. Đặt thời gian sống cho cookie (1 ngày = 24 * 60 * 60 giây)
    userCookie.setMaxAge(24 * 60 * 60);

    // 4. Thêm cookie vào response để gửi về trình duyệt
    response.addCookie(userCookie);

    // 5. Phản hồi cho người dùng
    PrintWriter out = response.getWriter();
    out.println("<h3>Cookie với tên '" + userName + "' đã được tạo!</h3>");
    out.println("<a href='index.html'>Quay về trang chủ</a>");
}
}