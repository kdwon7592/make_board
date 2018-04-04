package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() throws ClassNotFoundException, SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/BBS";
		String dbID = "root";
		String dbPassword = "rlaehdnjs123";
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dbURL, dbID, dbPassword);
	}
	
	
	public int login(String userId, String userPassword) throws SQLException {
		String SQL = "select userPassword FROM USER WHERE userId = ?";
		pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, userId);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			if(rs.getString(1).equals(userPassword)) {
				return 1; //로그인 성공
			}
			else {
				return 0; //비밀번호 불일치
			}
		}
		return -1; //아이디가 없음
	}

}
