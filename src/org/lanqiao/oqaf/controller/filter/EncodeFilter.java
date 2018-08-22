package org.lanqiao.oqaf.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class EncodeFilter implements Filter {
    private String contextType;
    private String characterEncoding;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(characterEncoding);
        resp.setCharacterEncoding(characterEncoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        contextType = config.getInitParameter("contextType");
        characterEncoding =config.getInitParameter("characterEncoding");
    }

}
