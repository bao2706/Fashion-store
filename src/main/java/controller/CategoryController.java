package controller;

import DAO.DAO;
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

@WebServlet("/category")
public class CategoryController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String cateID = request.getParameter("cateID");
        ProductService productService = new ProductService();
        CategoryService categoryService = new CategoryService();
        List<Product> listP = productService.getProductsByCateID(cateID);
        List<Category> listC = categoryService.getAllCategories();


        request.setAttribute("listProduct", listP);
        request.setAttribute("listCategory", listC);
        request.setAttribute("tag", cateID);



        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
