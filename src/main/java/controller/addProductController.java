package controller;

import Sevice.CategoryService;
import Sevice.ProductService;
import entity.Account;
import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/manager/add")
public class addProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String name = request.getParameter("name");
        String priceInput = request.getParameter("price");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        String categoryId = request.getParameter("category");

        String error = null;
        int price = 0;

        if (name == null || name.trim().isEmpty()) {
            error = "Vui lòng nhập tên sản phẩm";

        } else if (priceInput == null || priceInput.trim().isEmpty()) {
            error = "Vui lòng nhập giá";

        } else {
            try {
                price = Integer.parseInt(priceInput.trim());

                if (price <= 0) {
                    error = "Giá phải lớn hơn 0";
                }
            } catch (NumberFormatException e) {
                error = "Giá phải là số nguyên trong phạm vi cho phép";
            }
        }
        if (error == null &&
                (description == null || description.trim().isEmpty())) {

            error = "Vui lòng nhập mô tả";
        }
        if (error == null) {
            if (categoryId == null || categoryId.trim().isEmpty()) {
                error = "Vui lòng chọn danh mục";

            } else {
                categoryId = categoryId.trim();

                CategoryService categoryService = new CategoryService();
                boolean categoryExists = false;

                for (Category cat : categoryService.getAllCategories()) {
                    if (categoryId.equals(cat.getCateID())) {
                        categoryExists = true;
                        break;
                    }
                }

                if (!categoryExists) {
                    error = "Danh mục không hợp lệ";
                }
            }
        }
        ProductService productService = new ProductService();

        if ( error != null) {
            CategoryService categoryService = new CategoryService();

            request.setAttribute("error", error);
            request.setAttribute(
                    "product",
                    productService.getProductsBySellId(user.getId())
            );
            request.setAttribute(
                    "categories",
                    categoryService.getAllCategories()
            );

            request.getRequestDispatcher(
                    "/views/asset/productManager.jsp"
            ).forward(request, response);

            return;
        }
        productService.addProduct(
                name.trim(),
                description,
                String.valueOf(price),
                image,
                categoryId,
                user.getId()
        );

        response.sendRedirect(request.getContextPath() + "/manager");
    }
}