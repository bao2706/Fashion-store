package controller;

import Sevice.CartService;
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

@WebServlet(urlPatterns = {"/home", ""})
public class HomeController extends HttpServlet {

    // Đã đổi tên hàm thành doGet để bắt chính xác request từ URL trình duyệ
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductService productService = new ProductService();
        CategoryService categoryService = new CategoryService();
        List<Product> listP = productService.getAllProducts();
        List<Category> listC = categoryService.getAllCategories();

        //set data to jsp
        request.setAttribute("listProduct", listP);
        request.setAttribute("listCategory", listC);
        request.getRequestDispatcher("/index.jsp").forward(request, response);    }

}