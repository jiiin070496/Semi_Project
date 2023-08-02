package semi_project.member.service;

import static semi_project.common.jdbc.jdbcTemplate.*;

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
	public int login(MemberDto vo){
		int result = 0;
		Connection conn = getConnectionSemi();
		result = dao.login(conn, vo);
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
