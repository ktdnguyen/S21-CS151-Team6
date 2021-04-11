package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		System.out.println(getClass());
    	Parent root = FXMLLoader.load(getClass().getResource("/application/Registration.fxml"));
        stage.setTitle("Registration");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
	}

}
