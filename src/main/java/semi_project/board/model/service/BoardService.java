package semi_project.board.model.service;

import semi_project.board.model.dao.BoardDao;
import semi_project.board.model.dto.AttachFileDto;
import semi_project.board.model.dto.BoardDto;

import static semi_project.common.jdbc.jdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

public class BoardService {
	private BoardDao dao = new BoardDao();
	
	public List<BoardDto> selectList(){
		List<BoardDto> result = null;
		Connection conn = getConnectionSemi();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	// 한 행 읽기 - PK로where조건
	public BoardDto selectOne(int bno){
		BoardDto result = null;
		Connection conn = getConnectionSemi();
		result = dao.selectOne(conn, bno);
		if(result != null) {
			// 첨부파일들 읽어서 result에 넣기
			List<AttachFileDto> fileList = dao.selectAttachFileList(conn, bno);
			result.setAttachFileList(fileList);
		}
		close(conn);
		return result;
	}
	// 한 행 삽입 - BoardDto 자료형을 받아와야 함.
	public int insert(BoardDto dto, List<AttachFileDto> fileList){
		int result = 0;
		Connection conn = getConnectionSemi();
		setAutoCommit(conn, false);
		int nextval = dao.getSeqBoardBnoNexVal(conn);
		if(dto.getBno() == 0) { // 원본글작성
			result = dao.insert(conn, dto, nextval);
			if(fileList!=null && fileList.size()>0) {
				result = dao.insertAttachFileList(conn, fileList, nextval);
			}
		}else {   // 답글작성
			result = dao.update(conn, dto);
			if(result > -1) {
				result = dao.insertReply(conn, dto, nextval);
			}
			if(fileList!=null && fileList.size()>0) {
				result = dao.insertAttachFileList(conn, fileList, nextval);
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
	// 한 행 수정 - BoardDto 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
	public int update(BoardDto dto){
		int result = 0;
		Connection conn = getConnectionSemi();
		result = dao.update(conn, dto);
		close(conn);
		return result;
	}
	// 한 행 삭제 - 주로 PK로 where조건
	public int delete(int bno){
		int result = 0;
		Connection conn = getConnectionSemi();
		result = dao.delete(conn, bno);
		close(conn);
		return result;
	}
	
	//// 추가 
	// 페이징 처리 + 검색
	public int getTotalCount(String searchWord) {
		int result = 0;
		Connection conn = getConnectionSemi();
		result = dao.getTotalCount(conn, searchWord);
		close(conn);
		return result;
	}
	public List<BoardDto> selectList(int currentPage, int pageSize, String searchWord){
		List<BoardDto> result = null;
		Connection conn = getConnectionSemi();
		int totalCount = getTotalCount(searchWord);
		result = dao.selectList(conn, currentPage, pageSize, totalCount, searchWord);
		close(conn);
		return result;
	}
}
