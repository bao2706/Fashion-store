package controller;

import Sevice.CartService;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/cart/update")
public class QuanlityChangeController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Account user = session == null ? null : (Account) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        final int cartId;
        final int quantity;
        try {
            cartId = Integer.parseInt(req.getParameter("id"));
            quantity = Integer.parseInt(req.getParameter("quantity"));
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID giỏ hàng hoặc số lượng không hợp lệ.");
            return;
        }

        if (cartId <= 0 || quantity < 1 || quantity > 99) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Số lượng phải từ 1 đến 99.");
            return;
        }

        boolean updated = new CartService().quantityChange(quantity, cartId, user.getId());
        if (!updated) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy sản phẩm trong giỏ hàng của bạn.");
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
