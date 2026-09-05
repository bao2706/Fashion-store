package controller;

import DAO.DAO;
import Sevice.CartService;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/add-to-cart")
public class AddToCartController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account user =(Account) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login");
            return;
        }
        String id =String.valueOf(user.getId()) ;
        String quality = req.getParameter("quantity");
        String productId = req.getParameter("productId");
        CartService cartService = new CartService();
        cartService.add_to_cart(id,productId,quality);

        resp.sendRedirect("cart");

    }
}
