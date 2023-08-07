package semi_project.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi_project.member.dto.MemberDto;
import semi_project.member.service.MemberService;


@WebServlet("/login.login")
public class LoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[-----냄쿵login.login post-----]");
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		MemberDto dto = new MemberDto(mid, mpwd);
		String result = new MemberService().login(mid);
		String sendUrl = request.getContextPath();
		
		if(mpwd == null) {
			System.out.println("아이디를 다시 입력해주세요");
		} else if(mpwd.equals(result)) {
			System.out.println("로그인 성공");
			request.setAttribute("loginId", mid);
			request.getSession().setAttribute("successFailMsg", "로그인 성공");
			request.getSession().setAttribute("SsLoginId", mid);
			sendUrl += "/board/list";
		}
		response.sendRedirect(sendUrl);
	}

}
