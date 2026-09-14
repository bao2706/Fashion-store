package controller;

import DAO.CartDAO;
import Sevice.CartService;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/cart/remove")
public class RemoveCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Account user = (Account)session.getAttribute("user");
        String userid = String.valueOf(user.getId());
        CartService cartService = new CartService();
        cartService.remove(id,userid);

        response.sendRedirect(request.getContextPath()+"/cart");

    }
}
