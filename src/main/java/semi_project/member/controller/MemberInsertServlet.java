package semi_project.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/insert")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 객체에 실린 msg 처리
		if(request.getSession().getAttribute("sfMsg") instanceof String) {
			String msg = (String)request.getSession().getAttribute("sfMsg");
			request.getSession().removeAttribute("sfMsg");
			request.setAttribute("sfMsg", msg);
		}
		request.getRequestDispatcher("/WEB-INF/view/member/insert.jsp").forward(request, response);
	}
}
