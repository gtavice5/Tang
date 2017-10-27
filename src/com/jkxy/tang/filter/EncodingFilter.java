package com.jkxy.tang.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class EncodingFilter implements Filter {

	private String characterEncoding;

    public EncodingFilter() {
    }


	public void init(FilterConfig fConfig) throws ServletException {
		characterEncoding=fConfig.getInitParameter("encoding");
		if(characterEncoding==null){
			throw new ServletException("字符编码设置为空！");
		}
	}

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(!characterEncoding.equalsIgnoreCase(request.getCharacterEncoding())){
			request.setCharacterEncoding(characterEncoding);
		}
		response.setCharacterEncoding(characterEncoding);
		chain.doFilter(request, response);
	}



}
