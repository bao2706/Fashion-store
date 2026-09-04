package controller;

import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cart/update")
public class QuanlityChangeController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String quantity = req.getParameter("quantity");
        int id =Integer.valueOf( req.getParameter("id"));



        DAO dao = new DAO();
        dao.quantityChange(quantity,id);



        resp.sendRedirect(req.getContextPath()+"/cart");
    }
}
