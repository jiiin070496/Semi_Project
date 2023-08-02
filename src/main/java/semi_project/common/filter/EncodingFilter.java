package semi_project.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("[냄궁필터] filter 진짜 들어옴?");
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		 //다음 filter 동작 또는 doGet()/ doPost() 호출
		chain.doFilter(request, response);
	}

}
