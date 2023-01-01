package codegym.vn.demo.filter;

import codegym.vn.demo.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
@Component
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpSession session = ((HttpServletRequest) req).getSession();
//        User user = (User) session.getAttribute("user");
//        System.out.println(((HttpServletRequest) req).getRequestURI());
//        if ((user != null && user.getUsername() != null)
//                || ((HttpServletRequest) req).getRequestURI().contains("login")
//                || ((HttpServletRequest) req).getRequestURI().contains("/api/")) {
            chain.doFilter(req, resp);
//            return;
//        }
//        ((HttpServletResponse) resp).sendRedirect("/login");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
