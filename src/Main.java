import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass()
				.getResource("/visualise/screen/menu/menu.fxml"));
		
		Scene scene = new Scene(root);
		stage.setTitle("Tree Operation Visualisation");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}

