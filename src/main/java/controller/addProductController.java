package controller;

import DAO.DAO;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/add")
public class addProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("user");
        String id =String.valueOf(user.getId());
        String productname =request.getParameter("name");
        String price = request.getParameter("price");
        String description  =request.getParameter("description");
        String productImage =request.getParameter("image");
        String CatoID =request.getParameter("category");

        DAO dao = new DAO();
        dao.addProduct(productname,
                description,
                price,
                productImage,
                CatoID,
                id);
        response.sendRedirect("manager");
    }
}
