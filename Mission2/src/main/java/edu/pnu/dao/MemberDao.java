package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.MemberVO;

@Service
public class MemberDao {
//	private Statement stmt = null;
//	private PreparedStatement psmt = null;
//	private ResultSet rs = null;
	private Connection con = null;
//	private List<MemberVO> list;
//	private MemberVO vo = null;
	public MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공(기본 생성자)");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<MemberVO> getMembers() {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		String query = "select * from member";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				list.add(MemberVO.builder().id(rs.getInt("id")).name(rs.getString("name")).pass(rs.getString("pass")).regidate(rs.getDate("regidate")).build());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

	public MemberVO getMember(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String query = "select * from member where id=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return MemberVO.builder().id(rs.getInt("id")).name(rs.getString("name")).pass(rs.getString("pass")).regidate(rs.getDate("regidate")).build();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs!=null) rs.close();
				if(psmt!=null) psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public int addMember(MemberVO member) {
		// TODO Auto-generated method stub
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String query = "insert into member(name,pass) values (?,?)";
		int result = 0;
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getPass());
			System.out.println(psmt.toString());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs!=null) rs.close();
				if(psmt!=null) psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateMembers(MemberVO member) {
		// TODO Auto-generated method stub
		PreparedStatement psmt = null;
		int result = 0;
		String query = "update member set name=?, pass=? where id=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getPass());
			psmt.setInt(3, member.getId());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(psmt!=null) psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int removeMember(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement psmt = null;
		int result = 0;
		String query = "delete from member where id=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			result = psmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(psmt!=null) psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}
