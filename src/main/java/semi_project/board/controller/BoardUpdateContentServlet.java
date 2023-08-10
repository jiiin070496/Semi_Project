package semi_project.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi_project.board.model.dto.BoardDto;
import semi_project.board.model.service.BoardService;


@WebServlet("/board/update")
public class BoardUpdateContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("bno")==null) {
			request.getRequestDispatcher("/WEB-INF/view/board/list").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/board/update");		
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----UpdateContent doPost-----");
		int bno = Integer.parseInt(request.getParameter("bno"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		BoardDto dto = new BoardDto(bno, bcontent, btitle);
		
		int result = service.updateContent(dto);
		if(result < 1) {
			request.getSession().setAttribute("msg", "오류가 발생했습니다");
			response.sendRedirect(request.getContextPath()+"/board/read");		

		}else {
			request.getSession().setAttribute("msg", "글 수정이 완료되었습니다.");
			response.sendRedirect(request.getContextPath()+"/board/list");		
		}
		
	}

}
