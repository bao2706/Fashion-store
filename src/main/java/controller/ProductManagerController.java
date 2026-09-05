package controller;

import DAO.DAO;
import Sevice.CategoryService;
import Sevice.ProductService;
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
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();
        Account user = (Account) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login");
            return;
        }
        int id = user.getId();
        ProductService productService = new ProductService();
        CategoryService categoryService = new CategoryService();
        List<Product> listProduct = productService.getProductsBySellId(id);


        List<Category> listCategory = categoryService.getAllCategories();

        req.setAttribute("product", listProduct);
        req.setAttribute("categories", listCategory);
        req.getRequestDispatcher("views/asset/productManager.jsp").forward(req, resp);
    }
}
