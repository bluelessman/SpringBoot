package edu.pnu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	private Connection con;

	public MemberDao(DataSource dataSource) throws SQLException {
		// TODO Auto-generated constructor stub
		System.out.println("memberdao 생성");
		con = dataSource.getConnection();
	}

	public List<MemberVO> getMembers() {
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		String query = "select * from member";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				list.add(MemberVO.builder().id(rs.getInt("id")).pass(rs.getString("pass")).name(rs.getString("name"))
						.regidate(rs.getDate("regidate")).build());
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
	
	public MemberVO getMember(int id) {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String query = "select * from member where id=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return MemberVO.builder().id(rs.getInt("id")).pass(rs.getString("pass")).name(rs.getString("name"))
						.regidate(rs.getDate("regidate")).build();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}

	public int addMember(MemberVO member) {
		// TODO Auto-generated method stub
		PreparedStatement psmt = null;
		int result = 0;
		String query = "insert into member (name,pass) values (?,?)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getPass());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(psmt!=null) {
					psmt.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	public int updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		PreparedStatement psmt = null;
		int result = 0;
		String query = "update member set ";

		try {
			if(member.getName()!=null&&member.getPass()!=null) {
				query += "name=?, pass=? where id=?";
				psmt = con.prepareStatement(query);
				psmt.setString(1, member.getName());
				psmt.setString(2, member.getPass());
				psmt.setInt(3, member.getId());
			}else if(member.getName()!=null) {
				query += "name=? where id=?";
				psmt = con.prepareStatement(query);
				psmt.setString(1, member.getName());
				psmt.setInt(2, member.getId());
			}else if(member.getPass()!=null) {
				query += "pass=? where id=?";
				psmt = con.prepareStatement(query);
				psmt.setString(1, member.getPass());
				psmt.setInt(2, member.getId());
			}else {
				return result;
			}
			result = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(psmt!=null) psmt.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}

	public int deleteMember(int id) {
		// TODO Auto-generated method stub
		PreparedStatement psmt = null;
		int result = 0;
		String query = "delete from member where id=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1,id);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(psmt!=null) {
					psmt.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
}
