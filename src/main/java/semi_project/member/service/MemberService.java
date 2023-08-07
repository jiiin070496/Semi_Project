package semi_project.member.service;

import static semi_project.common.jdbc.jdbcTemplate.close;
import static semi_project.common.jdbc.jdbcTemplate.getConnectionSemi;


import java.sql.Connection;
import java.util.List;

import semi_project.member.dao.MemberDao;
import semi_project.member.dto.MemberDto;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public List<MemberDto> selectList(){
		List<MemberDto> result = null;
		Connection conn = getConnectionSemi();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	public MemberDto selectOne(int idx) {
		MemberDto result = null;
		Connection conn = getConnectionSemi();
		result = dao.selectOne(conn, idx);
		close(conn);
		return result;
	}
	
	public int insert(MemberDto dto) {
		int result = 0;
		Connection conn = getConnectionSemi();
		result = dao.insert(conn, dto);
		close(conn);
		return result;
	}
	public int update(MemberDto dto) {
		int result = 0;
		Connection conn = getConnectionSemi();
		result = dao.update(conn, dto);
		close(conn);
		return result;
	}
	public int delete(MemberDto dto) {
		int result = 0;
		Connection conn = getConnectionSemi();
		result = dao.delete(conn, dto);
		close(conn);
		return result;
	}
	
	
	public int login(MemberDto dto){
		int result = 0;
		Connection conn = getConnectionSemi();
		result = dao.login(conn, dto);
		close(conn);
		return result;
	}
	
	public String login(String mid){
		String result = null;
		Connection conn = getConnectionSemi();
		result = dao.login(conn, mid);
		close(conn);
		return result;
	}
}
