package semi_project.member.dao;

import static semi_project.common.jdbc.jdbcTemplate.*;
import semi_project.member.dto.MemberDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

	public List<MemberDto> selectList(Connection conn){
		List<MemberDto> result = new ArrayList<MemberDto>();		
		String query = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()==true) {
				MemberDto dto = new MemberDto(
						rs.getString("MID"),
						rs.getString("MNAME"),
						rs.getString("MEMAIL")
						);
				result.add(dto);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public MemberDto selectOne(Connection conn, int idx) {
		System.out.println("[Member dao selectOne] idx" + idx);
		MemberDto result = null;
		//TODO
		System.out.println("[Member Dao selectOne] return:" + result);
		return result;
	}
	
	public int insert(Connection conn, MemberDto dto) {
		System.out.println("[Member dao insert] dto" + dto);
		int result = 0;
		//TODO
		String query = "";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			//TODO
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("[Member Dao insert] return:" + result);
		return result;
	}
	
	public int update(Connection conn, MemberDto dto) {
		System.out.println("[Member dao update] dto" + dto);
		int result = 0;
		//TODO
		String query = "";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			//TODO
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("[Member Dao update] return:" + result);
		return result;
	}
	
	public int delete(Connection conn, MemberDto dto) {
		System.out.println("[Member dao delete] dto" + dto);
		int result = 0;		
		//TODO
		System.out.println("[Member Dao delete] return:" + result);
		return result;
	}
	
	public int login(Connection conn, MemberDto vo ) {
		int result = 0;
		String query = "select count(*) cnt from member where mid=? and mpwd=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpwd());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
			
	public String login(Connection conn, String mid) {
		String result = null;
		String query = "select mpwd from member where mpwd=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString("mpwd");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
