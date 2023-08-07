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
	
	public int insert(BoardDto dto){
		int result = 0;
		Connection conn = getConnectionSemi();
		setAutoCommit(conn, false);
		if(dto.getIdx() == 0) { // 원본글작성
			result = dao.insert(conn, dto);
		}else {   // 답글작성
			result = dao.update(conn, dto);
			if(result > -1) {
				result = dao.insert(conn, dto);
			}
		}
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	//한 행 수정
	public int update(BoardDto dto) {
		int result = 0;
		Connection conn = getConnectionSemi();
		result = dao.update(conn, dto);
		close(conn);
		return result;
	}
	
	public int delete(int idx) {
		int result = 0;
		Connection conn = getConnectionSemi();
		result = dao.delete(conn, idx);
		close(conn);
		return result;
	}
}
