package controller;

import Sevice.CategoryService;
import Sevice.ProductService;
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
public class EditProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getParameter("id");

        ProductService productService = new ProductService();
        CategoryService categoryService = new CategoryService();
        Product product = productService.getProductsByID(user_id);
        List<Category> category = categoryService.getAllCategories();

        req.setAttribute("product", product);
        req.setAttribute("categories", category);

        req.getRequestDispatcher("/views/asset/editform.jsp").forward(req,resp);

    }
}
