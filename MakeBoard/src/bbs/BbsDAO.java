package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BbsDAO {
	private Connection con;
	private ResultSet rs;
	
	public BbsDAO() throws ClassNotFoundException, SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/BBS";
		String dbID = "root";
		String dbPassword = "rlaehdnjs123";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dbURL, dbID, dbPassword);
	}
	public String getDate() {
		String SQL = "select now()";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getString(1);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return " ";
	}
	public int getNext() {
		String SQL = "select bbsId from bbs order by bbsId desc";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1) + 1;
			return 1; //첫번째 게시물
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public int write(String bbsTitle, String userId, String bbsContent) {
		String SQL = "insert into bbs values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userId);
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<Bbs> getList(int pageNumber){
		String SQL = "select * from bbs where bbsId < ? AND bbsAvailable = 1 order by bbsId desc limit 10";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber -1) * 10);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsId(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserId(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				list.add(bbs);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean nextPage(int pageNumber) {
		String SQL = "select * from bbs where bbsId < ? AND bbsAvailable = 1 order by bbsId desc limit 10";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber -1) * 10);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
