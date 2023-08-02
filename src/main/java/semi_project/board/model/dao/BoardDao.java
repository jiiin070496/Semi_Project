package semi_project.board.model.dao;

import static semi_project.common.jdbc.jdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi_project.board.model.dto.BoardDto;

public class BoardDao {
	//모든 행 읽기
	public List<BoardDto> selectList(Connection conn){
		System.out.println("[Board Dao selectList]: ");
		List<BoardDto> result = new ArrayList<BoardDto>();
		
		String subquery = "select IDX, TITLE, to_char(WRITE_DATE, 'yyyy-mm-dd hh24:mi:ss') BWRITE_DATE, MID, BREF, BRE_LEVEL, BRE_STEP from BOARD";
		subquery += "order by BREF desc, BRE_STEP asc";
		String query = subquery;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()==true) {
				BoardDto dto = new BoardDto(
					rs.getInt("IDX"),
					rs.getString("TITLE"),
					rs.getString("WRITE_DATE"),
					rs.getString("MID"),
					rs.getInt("BREF"),
					rs.getInt("BRE_LEVEL"),
					rs.getInt("BRE_STEP")					
				);
				result.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	//한 행 읽기
	public BoardDto selectOne(Connection conn, int idx) {
		System.out.println("[Board Dao selectOne] idx: " + idx);
		BoardDto result = null;
		//TODO
		System.out.println("[Board Dao selectOne] return: " + result);
		return result;
	}
	
	//한 행 삽입
	public int insert(Connection conn, BoardDto dto) {
		System.out.println("[Board Dao insert] dto: " + dto);
		int result = 0;
		//TODO
		System.out.println("[Board Dao insert] return: " + result);
		return result;
	}
	
	//한 행 수정
	public int update(Connection conn, BoardDto dto) {
		System.out.println("[Board Dao update] dto: " + dto);
		int result = 0;
		//TODO
		System.out.println("[Board Dao update] return: " + result);
		return result;
	}
	
	//한 행 삭제
	public int delete(Connection conn, int idx) {
		System.out.println("[Board Dao delete] idx: " + idx);
		int result = 0;
		//TODO
		System.out.println("[Board Dao delete] return: " + result);
		return result;
	}
}