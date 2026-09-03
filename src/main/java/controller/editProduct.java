package controller;

import DAO.DAO;
import entity.Category;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/edit")
public class editProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getParameter("id");

        DAO dao = new DAO();
        Product product = dao.getProductsByID(user_id);
        List<Category> category = dao.getAllCategori();

        req.setAttribute("product", product);
        req.setAttribute("categories", category);

        req.getRequestDispatcher("/views/asset/editform.jsp").forward(req,resp);

    }
}
