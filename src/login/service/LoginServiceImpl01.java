package login.service;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import login.dao.LoginDAO;
import login.dto.LoginDTO;
import member.main.MemberMain;

public class LoginServiceImpl01 implements LoginService01{
	private LoginDAO dao;
	public LoginServiceImpl01() {
		dao= new LoginDAO();
	}
	
	public void loginFunc(TextField fxId, TextField fxPwd) {
		System.out.println("---서비스 로그인 확인 ---");
		System.out.println("id : "+fxId.getText());
		System.out.println("pwd : "+fxPwd.getText());
		//LoginDTO dto = LoginDAO.db.get(fxId.getText());
		
		LoginDTO dto = dao.getUser(fxId.getText());
		
		System.out.println("dto : "+dto);
		String msg = null;
		
		//Alert alert = new Alert(AlertType.INFORMATION);
		
		if(dto != null) {
			if(dto.getPwd().equals(fxPwd.getText())){
				msg = dto.getName()+"님 인증성공";
			}else {
				msg = "비밀번호 틀림!";
			}
		}else {
			msg= "존재하지 않는 아이디 입니다";
		}
		//alert.setContentText(msg);
		//alert.show();
		CommonService.myAlert(msg);
		System.out.println(msg);
	}
	public void cancelFunc(Parent root) {
		System.out.println("--- 서비스 창 닫기 ---");
		//Stage stage = (Stage)root.getScene().getWindow();
		//stage.close();
		CommonService.cancelFunc(root);
		
	}
	public void registerFunc() {
		System.out.println("서비스 쪽 회원가입 실행");
		MemberMain member = new MemberMain();
		member.viewFx();
		
	}
	public void registerFunc(Parent root) {
		System.out.println("서비스 쪽 회원가입 실행");
		MemberMain member = new MemberMain();
		member.viewFx(root);
		
	}



}
