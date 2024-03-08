package member.service;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberServiceImpl implements MemberService{
	ComboBox<String> cmbAge;
	TextField fxName, fxId;
	PasswordField fxPwd, fxPwdChk;
	CheckBox chkMusic, chkMovie, chkMung;
	RadioButton rdoWoman;
	
	MemberDAO dao;
	Parent root;
	
	public MemberServiceImpl () {
		dao = new MemberDAO();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void registerFunc() {
		cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		fxId = (TextField)root.lookup("#fxId");
		fxName = (TextField)root.lookup("#fxName");
		
		fxPwd = (PasswordField)root.lookup("#fxPwd");
		fxPwdChk = (PasswordField)root.lookup("#fxPwdChk");
		
		chkMusic = (CheckBox)root.lookup("#chkMusic");
		chkMovie = (CheckBox)root.lookup("#chkMovie");
		chkMung = (CheckBox)root.lookup("#chkMung");
		
		rdoWoman = (RadioButton)root.lookup("#rdoWoman");
		

		System.out.println(cmbAge.getValue());
		String str = null;
		if(cmbAge.getValue() == null) {
			System.out.println("콤보박스를 선택하세요");
			str="콤보박스를 선택하세요";
			cmbAge.requestFocus();
			
		}else if(fxId.getText().isEmpty()) {
			str = "아이이 입력하세요";
			System.out.println("아이디를 입력하세요");
			fxId.requestFocus();
		}
		CommonService.myAlert(str);
		
		System.out.println("id : "+fxId.getText());
		System.out.println("name : "+fxName.getText());
		System.out.println("pwd : "+fxPwd.getText());
		System.out.println("pwd chk : "+fxPwdChk.getText());
		
		System.out.println("chkMusic : "+chkMusic.isSelected());
		System.out.println("chkMovie : "+chkMovie.isSelected());
		System.out.println("chkMung : "+chkMung.isSelected());
		//둘중 하나는 선택되어야 한다
		//woman이 선택되면 true, 아니면 false
		//false가 나오면 man선택되었다고 판단
		
		System.out.println("rdoWoman : "+rdoWoman.isSelected());
		
		MemberDTO dto = new MemberDTO();
		dto.setId(fxId.getText());
		dto.setName(fxName.getText());
		dto.setPwd(fxPwd.getText());
		//dto.setGender(rdoWoman.isSelected()? 1:0);//1:여성 0:남성
		//위에 한줄과 같다
		int num = 0;
		if(rdoWoman.isSelected()) {
			num=1;
		}else {
			num=0;
		}
		dto.setGender(num);
		
		dto.setAge(cmbAge.getValue());//음악: 1, 영화:2, 멍:4
		
		int hobby = 0;
		if(chkMusic.isSelected()) hobby += 1;
		if(chkMovie.isSelected()) hobby += 2;
		if(chkMung.isSelected()) hobby += 4;
		dto.setHobby(hobby);
		
		int result = dao.register(dto);
		String msg = null;
		if(result ==1) {
			System.out.println("저장 성공");
			msg= "저장성공";
			cancelFunc();
		}else {
			msg="문제발생";
			System.out.println("문제 발생");
		}
		CommonService.myAlert(msg);
	}
	public void cancelFunc() {
		//Stage stage = (Stage)root.getScene().getWindow();
		//stage.close();
		CommonService.cancelFunc(root);
		
	}
	
}









