package controller;

import DAO.DAO;
import Sevice.CartService;
import entity.Account;
import entity.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/cart")
public class cartController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account user =(Account) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login");
            return;
        }
        int id = Integer.valueOf(user.getId());
        CartService cartService = new CartService();
        List<Cart> listCart = cartService.getProductInCart(id);

        req.setAttribute("cart",listCart);
        req.getRequestDispatcher("/views/asset/cart.jsp").forward(req,resp);
    }
}
