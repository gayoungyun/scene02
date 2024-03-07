package login.main;

import java.net.URL;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.controller.Controller;
import login.url.URLService;

public class MainClass extends Application{
	@Override
	public void start(Stage arg0) throws Exception {//try catch와같다
		System.out.println(getClass().getResource(""));//현재위치정보
		System.out.println("file:/"+(Paths.get("").toAbsolutePath().toString()));
		System.out.println("file:/"+(Paths.get("").toAbsolutePath().toString())+"/bin/login/fxml/Login.fxml");
		//패키지가 많을때 현재경로 불러온다, 기본-절대경로-문자로/ 앞에 파일도 써줘야함 뒤에도
		URL url= new URL(URLService.fxPath+"login/fxml/Login.fxml");//urlservice에서 경로를 가져온다
		
		FXMLLoader loader = new FXMLLoader(url);
		Parent root = loader.load();//controller생성 객체얻어옴(new사용x)
		
		Controller ctrl = loader.getController();
		ctrl.setRoot(root);
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
