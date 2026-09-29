package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/validate-demo")
public class ValidateDemoServlet extends HttpServlet {
    private static final String PAGE = "/views/asset/validate-demo.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String input = req.getParameter("quantity");

        try {
            int quantity = Integer.parseInt(input);

            if (quantity < 1 || quantity > 99) {
                req.setAttribute("error", "Số lượng phải từ 1 đến 99.");
            } else {
                req.setAttribute("success", "Hợp lệ! Số lượng: " + quantity);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Hãy nhập một số nguyên.");
        }

        req.getRequestDispatcher(PAGE).forward(req, resp);
    }
}