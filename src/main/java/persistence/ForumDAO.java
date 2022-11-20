package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.ForumVO;

public class ForumDAO {
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

	public ForumVO read(String creator) {
		connect();
		ForumVO forum = new ForumVO();
		String sql = "select * from forums where creator=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, creator);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			forum.setCreator(rs.getString("creator"));
			forum.setCategory(rs.getString("category"));
			forum.setUser_id(rs.getString("user_id"));
			forum.setContent(rs.getString("content"));
			forum.setUpload_date(rs.getString("upload_date"));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return forum;
	}

	public boolean add(ForumVO vo) {
		connect();
		String sql = "insert into forums values (?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCreator());;
			pstmt.setString(2, vo.getCategory());
			pstmt.setString(3, vo.getUser_id());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getUpload_date());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public boolean delete(String creator, String user_id) {
		connect();
		String sql = "delete from forums where creator=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, creator);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public boolean update(ForumVO vo) {
		connect();
		String sql = "update forums set creator=?,category=?,user_id=?,content=?,upload_date=? where creator=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCreator());
			pstmt.setString(2, vo.getCategory());
			pstmt.setString(3, vo.getUser_id());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getUpload_date());
			pstmt.setString(6, vo.getCreator());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public ArrayList<ForumVO> getForumsList() {
		connect();
		ArrayList<ForumVO> forumslist = new ArrayList<ForumVO>();
		String sql = "select * from forums";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ForumVO vo = new ForumVO();
				vo.setCreator(rs.getString("creator"));
				vo.setCategory(rs.getString("category"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setContent(rs.getString("content"));
				vo.setUpload_date(rs.getString("upload_date"));
				forumslist.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return forumslist;
	}
}
