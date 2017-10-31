package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MemberVO;

public class MemberDao {
	private static MemberDao instance;
	private Connection conn;
		
	private MemberDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/member_db", "root", "mysql");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static MemberDao getInstance() {
		if (instance == null)
			instance = new MemberDao();
		return instance;
	}
	
	public int insertMember(MemberVO meVo) {
		String sql = "INSERT INTO member VALUES(0,?,?,?,?,?,?)";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, meVo.getId());
			pstmt.setString(2, meVo.getMe_pwd());
			pstmt.setString(3, meVo.getSns());
			pstmt.setString(4, meVo.getMe_genre());
			pstmt.setString(5, meVo.getEmail());
			pstmt.setTimestamp(6, meVo.getP_date());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<MemberVO> selectAllMembers(){
		String sql = "SELECT * FROM member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> memberlist = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO meVo = new MemberVO();
				meVo.setMe_code(rs.getInt("me_code"));
				meVo.setId(rs.getString("id"));
				meVo.setMe_pwd(rs.getString("me_pwd"));
				meVo.setSns(rs.getString("sns"));
				meVo.setMe_genre(rs.getString("me_genre"));
				meVo.setEmail(rs.getString("email"));
				meVo.setP_date(rs.getTimestamp("p_date"));
				memberlist.add(meVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return memberlist;
	}
	
	public int deleteMember(int me_code) {
		String sql = "delete from member where me_code=?";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, me_code);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMember(int me_code) {
		
		String sql = "update member set id=?, me_pwd=?, sns=?, me_genre=?, email=? where me_code=?";
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			MemberVO meVo = new MemberVO();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, meVo.getId());
			pstmt.setString(2, meVo.getMe_pwd());
			pstmt.setString(3, meVo.getSns());
			pstmt.setString(4, meVo.getMe_genre());
			pstmt.setString(5, meVo.getEmail());
			pstmt.setInt(6, meVo.getMe_code());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int selectMember(String id) {
		int result = 0;
		String sql = "SELECT * FROM member WHERE id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberVO meVo = new MemberVO();
				meVo.setMe_code(rs.getInt("me_code"));
				meVo.setId(rs.getString("id"));
				meVo.setMe_pwd(rs.getString("me_pwd"));
				meVo.setSns(rs.getString("sns"));
				meVo.setMe_genre(rs.getString("me_genre"));
				meVo.setEmail(rs.getString("email"));
				result =pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	public int userCheck(String id, String me_pwd) {
		int result = -1;
		String sql = "select me_pwd from member where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("me_pwd")!=null && rs.getString("me_pwd").equals(me_pwd)) {
					result = 1;
				} else {
					result = -1;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
