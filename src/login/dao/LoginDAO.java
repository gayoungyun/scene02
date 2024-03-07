package login.dao;

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

}
