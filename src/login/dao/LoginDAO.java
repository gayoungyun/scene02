package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import login.dto.LoginDTO;

public class LoginDAO {
	public static Map<String, LoginDTO>db;
	static {
		db = new HashMap<>();
		for(int i=0; i<3;i++) {
			String id = "aaa"+i;
			LoginDTO dto = new LoginDTO(id, id, "홍길동"+i);
			db.put(id, dto);
		}
	}
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public LoginDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java", pwd = "1234";
		try {
			Class.forName(driver);
			System.out.println("드라이브 로드 성공");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("디비 연결 성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LoginDTO getUser(String id) {
		LoginDTO dto = null;
		String sql = "select * from member_fx where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs= ps.executeQuery();
			if(rs.next()) {
				dto = new LoginDTO(rs.getString("id"), rs.getString("pwd"), rs.getString("name"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}





