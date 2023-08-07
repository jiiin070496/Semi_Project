package semi_project.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi_project.member.model.dto.Member;
import semi_project.member.model.service.MemberService;

@WebServlet("/login.login")
public class LoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[ejkim ]login.login post");
		String mid=	request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		Member vo = new Member(mid, mpwd);
		String result = new MemberService().login(mid);
		String sendUrl = request.getContextPath(); 
		// TODO session
		if(mpwd == null) {
			// 아이디가 존재하지 않습니다.
		} else if(mpwd.equals(result)) {
			System.out.println("로그인 성공");
			request.setAttribute("loginId", mid);
			request.getSession().setAttribute("successFailMsg", "로그인성공");
			request.getSession().setAttribute("SsLoginId", mid);
			sendUrl += "/board/list"; 
		} else {
			System.out.println("로그인 실패");
			request.getSession().setAttribute("successFailMsg", "로그인 실패하였습니다.\n 아이디와 패스워드를 다시 확인하고 로그인 시도해주세요.");
			sendUrl += "/board/list";
		}
		response.sendRedirect(sendUrl);
	}

}
