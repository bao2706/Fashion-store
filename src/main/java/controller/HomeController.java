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

@WebServlet(urlPatterns = {"/home", ""})
public class HomeController extends HttpServlet {

    // Đã đổi tên hàm thành doGet để bắt chính xác request từ URL trình duyệ
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // get data
        DAO dao = new DAO();
        List<Product> listP = dao.getAllProducts();
        List<Category> listC = dao.getAllCategori();

        //set data to jsp
        request.setAttribute("listProduct", listP);
        request.setAttribute("listCategory", listC);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        List<Product> listP = dao.getAllProducts();
        List<Category> listC = dao.getAllCategori();

        //set data to jsp
        request.setAttribute("listProduct", listP);
        request.setAttribute("listCategory", listC);
        request.getRequestDispatcher("/index.jsp").forward(request, response);    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}