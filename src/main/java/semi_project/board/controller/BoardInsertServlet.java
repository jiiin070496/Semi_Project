package semi_project.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/board/insert <<<<doget()>>>>");
		String idxStr = request.getParameter("idx");
		int idx = 0;
		if(idxStr!=null && idxStr.equals("")) {
			try {
				idx = Integer.parseInt(idxStr);
				request.setAttribute("idx", idxStr);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("/WEB-INF/board/insert.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/board/insert !!POST!!");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String mid = "jiin0191";
		
		String idxStr = request.getParameter("idx");
		int idx = 0;
		if(idxStr!=null && !idxStr.equals("")) {
			try {
				idx = Integer.parseInt(idxStr);
				
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}
		response.sendRedirect(request.getContextPath()+"/board/list");
	}

}
