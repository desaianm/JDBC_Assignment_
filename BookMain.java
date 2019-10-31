package Assignment;


import java.net.URL;   

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookMain extends javafx.application.Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		URL res = this.getClass().getResource("Design.fxml");
		Parent root = FXMLLoader.load(res);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Address Book Application");
		primaryStage.show();
		
		
		
	}

}
