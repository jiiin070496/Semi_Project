package semi_project.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi_project.board.model.service.BoardService;


@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/board/insert |||doGet()|||" );
	
		String idxStr = request.getParameter("idx");
		int idx = 0;
		if(idxStr != null && !idxStr.equals("")) {
			try {
				idx = Integer.parseInt(idxStr);
				request.setAttribute("idx", idxStr);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("/WEB-INF/view/board/insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/board/insert Post!!!!!!");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String mid = request.getParameter("mid");
		
		String idxStr = request.getParameter("idx");
		System.out.println("idxStr : " + idxStr);
		int idx = 0;
		if(idxStr != null && !idxStr.equals("")) {
			try {
				idx = Integer.parseInt(idxStr);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		response.sendRedirect(request.getContextPath()+"/board/list");
	}

}
