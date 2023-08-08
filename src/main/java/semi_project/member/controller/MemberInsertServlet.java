package semi_project.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/member/insert")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 객체에 실린 msg 처리
		if(request.getSession().getAttribute("msg") instanceof String) {
			String msg = (String)request.getSession().getAttribute("msg");
			request.getSession().removeAttribute("msg");
			request.setAttribute("msg", msg);
		}
		request.getRequestDispatcher("/WEB-INF/view/member/insert.jsp").forward(request, response);
	}
}
