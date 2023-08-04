package semi_project.board.model.dao;

import static semi_project.common.jdbc.jdbcTemplate.*;

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
		
		String subquery = "select IDX, TITLE, to_char(WRITE_DATE, 'yyyy-mm-dd hh24:mi:ss') WRITE_DATE, MID, BREF, BRE_LEVEL, BRE_STEP from BOARD";
		subquery += " order by BREF desc, BRE_STEP asc ";
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
		System.out.println("[Board Dao selectList] return: " + result);
		return result;
	}
	
	//한 행 읽기
	public BoardDto selectOne(Connection conn, int idx) {
		BoardDto result = null;
		String query = "select IDX, TITLE, to_char(WRITE_DATE, 'yyyy-mm-dd hh24:mi:ss') WRITE_DATE, MID, BREF, BRE_LEVEL, BRE_STEP from BOARD"
					+ " where idx = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	//한 행 삽입
	public int insert(Connection conn, BoardDto dto) {
		System.out.println("[Board Dao insert] dto: " + dto);
		int result = 0;
		String query = "";
		
		if(dto.getIdx()==0) { // 원본글 작성
			query = "insert into BOARD values(SEQ_BOARD_IDX.nextval, ?, ?, defalut, ?, SEQ_BOARD_IDX.nextval, 0, 0)";
		}else { // 답글 작성
			query = "insert into BOARD values(SEQ_BOARD-IDX.nextval, ?, ?, default, ?, (select bref from board where idx=?), (select bre_level+1 from board where idx=?), (select bre_step+1 from board where idx=?))";
		}
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getMid());
			
			if(dto.getIdx()!=0) {
				pstmt.setInt(1, dto.getIdx());
				pstmt.setInt(2, dto.getIdx());
				pstmt.setInt(3, dto.getIdx());
			}
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		System.out.println("[Board Dao insert] return: " + result);
		return result;
	}
	
	//한 행 수정 dto나 경우에 따라 특정 컬럼값 받아옴.
	public int update(Connection conn, BoardDto dto) {
		System.out.println("[Board Dao update] dto: " + dto);
		int result = -1; // 0도 정상 값일 수 있으므로 초기값은 -1
		String query = "update board set BRE_STEP = BRE_STEP + 1 where BRE_STEP > (select bre_step from board where idx=?) and BREF = (select bref from board where idx=?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dto.getIdx());
			pstmt.setInt(2, dto.getIdx());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
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
