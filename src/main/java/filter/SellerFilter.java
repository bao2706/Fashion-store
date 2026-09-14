package filter;

import entity.Account;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/manager/*")
public class SellerFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {

        HttpServletRequest request =
                (HttpServletRequest) servletRequest;

        HttpServletResponse response =
                (HttpServletResponse) servletResponse;

        // Không tạo session mới
        HttpSession session = request.getSession(false);

        // 1. Chưa login
        if (session == null) {
            response.sendRedirect(
                    request.getContextPath() + "/login"
            );
            return;
        }

        Account user =
                (Account) session.getAttribute("user");

        // 2. Session có nhưng chưa có user
        if (user == null) {
            response.sendRedirect(
                    request.getContextPath() + "/login"
            );
            return;
        }

        // 3. Login rồi nhưng không phải admin
        if (user.getIssell()  != 1) {

            request.setAttribute(
                    "error",
                    "権限がありません"
            );

            request.getRequestDispatcher("/login")
                    .forward(request, response);

            return;
        }

        // 4. Admin -> cho qua
        filterChain.doFilter(
                servletRequest,
                servletResponse
        );
    }
}