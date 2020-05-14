package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.MainSponsor;

public class Main extends Application {

	private MainSponsor mainSponsor;
	private ControllerSponsor controllerSponsor;
	
	public Main() {
		mainSponsor = new MainSponsor();
		controllerSponsor = new ControllerSponsor(mainSponsor);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	@Override
	public void start(Stage stage) throws Exception {
	 		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ControllerSpon.fxml"));
		loader.setController(controllerSponsor);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Basic Algorithms Race");
		stage.show();
		
	}

}
