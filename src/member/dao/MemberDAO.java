package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.dto.MemberDTO;

public class MemberDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public MemberDAO() {
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
	
	public int register(MemberDTO dto) {
		int result = 0;
		String sql = "insert into member_fx(id, pwd, name, age, gender, hobby)"+"values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getAge());
			
			ps.setInt(5, dto.getGender());
			ps.setInt(6, dto.getHobby());
			
			result = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}







