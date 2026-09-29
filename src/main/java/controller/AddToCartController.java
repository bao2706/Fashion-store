package controller;

import DAO.DAO;
import Sevice.CartService;
import Sevice.ProductService;
import entity.Account;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/cart/add-to-cart")
public class AddToCartController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        Account user = session == null ? null : (Account) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String productId = req.getParameter("productId");
        Product product = new ProductService().getProductsByID(productId);
        if (product == null) {
            resp.sendError(404, "Không tìm thấy sản phẩm.");
            return;
        }

        String input = req.getParameter("quantity");
        Integer quantity = null;
        String error = null;

        try {
            quantity = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            error = "Số lượng phải là số nguyên.";
        }

        if (error == null && (quantity < 1 || quantity > 99)) {
            error = "Số lượng phải từ 1 đến 99.";
        }

        if (error != null) {
            req.setAttribute("product", product);
            req.setAttribute("error", error);
            req.getRequestDispatcher("/views/asset/mainPageProduct.jsp").forward(req, resp);
            return;
        }

        new CartService().add_to_cart(
                String.valueOf(user.getId()),
                productId,
                String.valueOf(quantity)
        );
        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
