package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.UserVO;

public class UserDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;

	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";

	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "passwd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public UserVO read(String strId) {
		connect();
		UserVO user = new UserVO();
		String sql = "select * from users where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			user.setId(rs.getString("id"));
			user.setPasswd(rs.getString("passwd"));
			user.setUsername(rs.getString("username"));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return user;
	}

	public UserVO isRegisteredUser(String strId, String strPw) {
		connect();
		UserVO user = new UserVO();
		String sql = "select * from users where id=? and passwd=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			pstmt.setString(2, strPw);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setPasswd(rs.getString("passwd"));
				user.setUsername(rs.getString("username"));
			} else return null;
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return user;
	}

	public boolean add(UserVO vo) {
		connect();
		String sql = "insert into users values (?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getUsername());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public boolean delete(String strId) {
		connect();
		String sql = "delete from users where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public ArrayList<UserVO> getUsersList() {
		connect();
		ArrayList<UserVO> userslist = new ArrayList<UserVO>();
		String sql = "select * from users";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				UserVO vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setUsername(rs.getString("username"));
				userslist.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return userslist;
	}

}
