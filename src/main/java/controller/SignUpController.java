package controller;

import DAO.DAO;
import Sevice.UserService;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {

    // Chỉ dùng doGet để hiển thị giao diện trang đăng ký
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/asset/signUp.jsp").forward(req, resp);
    }

    // Xử lý dữ liệu form gửi lên ở doPost
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String user = req.getParameter("user");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        // 1. Kiểm tra dữ liệu rỗng để tránh lỗi sập web
        if (user == null || password == null || confirmPassword == null) {
            req.setAttribute("message", "Vui lòng nhập đầy đủ thông tin.");
            req.getRequestDispatcher("/views/asset/signUp.jsp").forward(req, resp);
            return; // Dừng chạy code bên dưới
        }

        // 2. Kiểm tra mật khẩu nhập lại
        if (!password.equals(confirmPassword)) {
            // Dùng forward để giữ lại thông báo lỗi trên giao diện
            req.setAttribute("message", "Mật khẩu và Xác nhận mật khẩu không khớp.");
            req.getRequestDispatcher("/views/asset/signUp.jsp").forward(req, resp);
            return;
        }

        // 3. Tương tác với Database
        UserService userService = new UserService();
        Account account = userService.checkAccount(user);

        if (account == null) {
            // Tài khoản chưa tồn tại -> Cho phép tạo mới
            userService.signUp(user, password);
            resp.sendRedirect("home");
            // Chuyển hướng về trang chủ khi thành công
        } else {
            // Tài khoản đã tồn tại -> Báo lỗi
            req.setAttribute("message", "Tên tài khoản đã tồn tại. Vui lòng chọn tên khác.");
            req.getRequestDispatcher("/views/asset/signUp.jsp").forward(req, resp);
        }
    }
}