package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	
	static Scene mazeScene;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("MazeGUI.fxml"));
			mazeScene = new Scene(root,488,480);
			
			mazeScene.getStylesheets().add(getClass().getResource("mazeStyle.css").toExternalForm());
			primaryStage.setTitle("Maze Solver");
			primaryStage.setScene(mazeScene);
			primaryStage.setResizable(false);
			primaryStage.show();
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
