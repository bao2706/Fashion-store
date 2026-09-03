package controller;

import DAO.DAO;
import entity.Account;
import entity.Category;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet("/manager")
public class ProductManagerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account user = (Account) session.getAttribute("user");
        int id = user.getId();
        DAO dao = new DAO();
        List<Product> listProduct = dao.getProductBySellId(id);
       List<Category> listCategory = dao.getAllCategori();

        req.setAttribute("product", listProduct);
        req.setAttribute("categories", listCategory);
        req.getRequestDispatcher("views/asset/productManager.jsp").forward(req, resp);
    }
}
