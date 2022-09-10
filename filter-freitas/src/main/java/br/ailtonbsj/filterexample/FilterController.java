package br.ailtonbsj.filterexample;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class FilterController implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Filter controller");

        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getMethod().equals("GET")) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).setStatus(500);
            response.getOutputStream().write("Erro no spring".getBytes());
        }
    }
}
