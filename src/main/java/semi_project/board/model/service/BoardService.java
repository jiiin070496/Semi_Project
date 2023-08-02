package semi_project.board.model.service;

import static semi_project.common.jdbc.jdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import semi_project.board.model.dao.BoardDao;
import semi_project.board.model.dto.BoardDto;

public class BoardService {
	private BoardDao dao = new BoardDao();
	
	public List<BoardDto> selectList(){
		List<BoardDto> result = null;
		Connection conn = getConnectionSemi();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	public BoardDto selectOne(int idx){
		BoardDto result = null;
		Connection conn = getConnectionSemi();
		result = dao.selectOne(conn, idx);
		close(conn);
		return result;
	}

	
}
