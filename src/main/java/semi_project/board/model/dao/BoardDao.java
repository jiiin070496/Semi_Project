package semi_project.board.model.dao;

import static semi_project.common.jdbc.jdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi_project.board.model.dto.AttachFileDto;
import semi_project.board.model.dto.BoardDto;



public class BoardDao {
	public List<BoardDto> selectList(Connection conn) {
		System.out.println("[Board Dao selectList]");
		List<BoardDto> result = new ArrayList<BoardDto>();

		String query = " select BNO, BTITLE, to_char(BWRITE_DATE, 'yyyy-mm-dd hh24:mi:ss') BWRITE_DATE, MID, BREF, BRE_LEVEL, BRE_STEP from BOARD ";
		query += " order by BREF desc, BRE_STEP asc"; // 정렬순서

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				BoardDto dto = new BoardDto(
						rs.getInt("BNO"),
						rs.getString("BTITLE"),
						rs.getString("BWRITE_DATE"),
						rs.getString("MID"),
						rs.getInt("BREF"),
						rs.getInt("BRE_LEVEL"),
						rs.getInt("BRE_STEP")					
						);
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
//		System.out.println("[Board Dao selectList] return:" + result);
		return result;
	}

	public BoardDto selectOne(Connection conn, int bno) {
		System.out.println("[Board Dao selectOne] bno:" + bno);
		BoardDto result = null;
		String query = " select BNO, BTITLE, BCONTENT, to_char(BWRITE_DATE, 'yyyy-mm-dd hh24:mi:ss') BWRITE_DATE, MID, BREF, BRE_LEVEL, BRE_STEP from BOARD ";
		query += " where BNO=?"; 

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				result = new BoardDto(
						rs.getInt("BNO"),
						rs.getString("BTITLE"),
						rs.getString("BCONTENT"),
						rs.getString("BWRITE_DATE"),
						rs.getString("MID"),
						rs.getInt("BREF"),
						rs.getInt("BRE_LEVEL"),
						rs.getInt("BRE_STEP")					
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[Board Dao selectOne] return:" + result);
		return result;
	}

	public int insert(Connection conn, BoardDto dto, int nextval) {
		System.out.println("[Board Dao insert] dto:" + dto + ", "+ nextval);
		int result = 0;
		String query = "";
		query = "insert into BOARD values (?, ?, ?, default, ?    ,?, 0,0)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, nextval);
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getMid());
			pstmt.setInt(5, nextval);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[Board Dao insert] return:" + result);
		return result;
	}
	//답글
	public int insertReply(Connection conn, BoardDto dto, int nextval) {
		System.out.println("[Board Dao insertReply] dto:" + ", "+ nextval);
		int result = 0;
		String query = "insert into BOARD values (?, ?, ?, default, ?    , (select bref from board where bno=?)    , (select bre_level+1 from board where bno=?)    , (select bre_step+1 from board where bno=?)    )";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, nextval);
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getMid());
			pstmt.setInt(5, dto.getBno());
			pstmt.setInt(6, dto.getBno());
			pstmt.setInt(7, dto.getBno());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[Board Dao insertReply] return:" + result);
		return result;
	}

	public int update(Connection conn, BoardDto dto) {
		System.out.println("[Board Dao update] dto:" + dto);
		int result = -1;  // update 경우 0도 정상 결과값일 수 있으므로 -1을 초기값
		String query = "update board set BRE_STEP = BRE_STEP + 1 where BRE_STEP > (select bre_step from board where bno=?)  and BREF = (select bref from board where bno=?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dto.getBno());
			pstmt.setInt(2, dto.getBno());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[Board Dao update] return:" + result);
		return result;
	}

//	public int updateContent(Connection conn, int bno, String btitle, String bcontent) {
//		System.out.println("[Board Dao updateContent] bno:" + bno);
//		int result = -1;
//		String query = "update board set btitle = ?, bcontent = ? where bno = ?";
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, btitle);
//			pstmt.setString(2, bcontent);
//			pstmt.setInt(3, bno);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//		}
//		return result;
//	}

	public int updateContent(Connection conn, BoardDto dto) {
		System.out.println("[Board Dao updateContent] dto:" + dto);
		int result = -1;
		String query = "update board set btitle = ?, bcontent = ? where bno = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setInt(3, dto.getBno());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("[Board Dao updateContent] return:" + result);
		return result;
	}
	
	public int delete(Connection conn, int bno) {
		System.out.println("[Board Dao delete] bno:" + bno);
		int result = 0;
		String query = "delete from board where bno=? ";
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("[Board Dao delete] return:" + result);
		return result;
	}	
	
	// 첨부파일들 저장
	public int insertAttachFileList(Connection conn, List<AttachFileDto> dtoList, int bno) {
		System.out.println("[Board Dao insertAttachFileList] dto:" + dtoList+", bno:"+bno);
		int result = 0;
		String query = "";
		query = "insert all ";
		for(int i=0; i<dtoList.size(); i++) {
			query += " into ATTACH_FILE (FILEPATH, BNO) values (?, ?) ";
		}
		query += " select * from dual ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			for(int i=0; i<dtoList.size(); i++) {
				pstmt.setString((2*i)+1, dtoList.get(i).getFilepath());
				pstmt.setInt((2*i)+2, bno);
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[Board Dao insertAttachFileList] return:" + result);
		return result;
	}
	
	public int getSeqBoardBnoNexVal(Connection conn) {
		System.out.println("[Board Dao getSeqBoardBnoNexVal] ");
		int result = 0;
		String query ="select SEQ_BOARD_BNO.nextval bnonextval from dual";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("bnonextval");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[Board Dao getSeqBoardBnoNexVal] return:" + result);
		return result;
	}
	
	// 첨부파일들 읽기
	public List<AttachFileDto> selectAttachFileList(Connection conn, int bno) {
		System.out.println("[Board Dao selectOne] bno:" + bno);
		List<AttachFileDto> result = new ArrayList<AttachFileDto>();
		String query = " select filepath from Attach_File ";
		query += " where BNO=?"; 

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				AttachFileDto dto = new AttachFileDto(rs.getString("filepath"));
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[Board Dao selectOne] return:" + result);
		return result;
	}

}
