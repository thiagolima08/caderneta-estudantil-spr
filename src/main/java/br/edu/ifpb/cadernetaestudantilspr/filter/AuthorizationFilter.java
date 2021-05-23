package br.edu.ifpb.cadernetaestudantilspr.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {
    public AuthorizationFilter() {

    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = req.getSession(false);
            String uri = req.getRequestURI();
            if ((uri.contains("/index.xhtml") || uri.contains("/cadastroprofessor.xhtml")) || (session != null
                    && session.getAttribute("professor") != null)) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(req.getContextPath() + "/index.xhtml");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
