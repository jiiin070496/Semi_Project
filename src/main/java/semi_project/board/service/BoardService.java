package semi_project.board.service;

import java.sql.Connection;
import java.util.List;

import semi_project.board.model.dao.BoardDao;
import semi_project.board.model.dto.BoardDto;

public class BoardService {
	private BoardDao dao = new BoardDao();
	
	public List<BoardDto> result = null;
	Connection conn = getConnectionSemi();
			
	
}
