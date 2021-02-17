package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.NodeList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MazeController implements Initializable{
	
	// Variables: 
	
	private String visitedColor = "rgb(170, 88, 57)";
	private String pathColor = "rgb(219, 64, 6)";
	private String finalPathColor = "rgb(1, 144, 1)";
	

    @FXML
    protected static Pane pane23;
    @FXML
    protected static Pane pane22;
    @FXML
    protected static Pane pane25;
    @FXML
    protected static Pane pane24;
    @FXML
    protected static Pane pane27;
    @FXML
    protected static Pane pane26;
    @FXML
    protected static Pane pane29;
    @FXML
    protected static Pane pane28;
    @FXML
    protected static Pane pane21;
    @FXML
    protected static Pane pane20;
    @FXML
    protected static Pane pane12;
    @FXML
    protected static Pane pane11;

    @FXML
    protected static Pane pane99;

    @FXML
    protected static Pane pane14;

    @FXML
    protected static Pane pane13;

    @FXML
    protected static Pane pane16;

    @FXML
    protected static Pane pane15;

    @FXML
    protected static Pane pane18;

    @FXML
    protected static Pane pane17;

    @FXML
    protected static Pane pane92;

    @FXML
    protected static Pane pane91;

    @FXML
    protected static Pane pane94;

    @FXML
    protected static Pane pane93;

    @FXML
    protected static Pane pane96;

    @FXML
    protected static Pane pane95;

    @FXML
    protected static Pane pane10;

    @FXML
    protected static Pane pane98;

    @FXML
    protected static Pane pane97;

    @FXML
    protected static Pane pane19;

    @FXML
    protected static Pane pane45;

    @FXML
    protected static Pane pane44;

    @FXML
    protected static Pane pane47;

    @FXML
    protected static Pane pane46;

    @FXML
    protected static Pane pane49;

    @FXML
    protected static Pane pane48;

    @FXML
    protected static Pane pane41;

    @FXML
    protected static Pane pane40;

    @FXML
    protected static Pane pane43;

    @FXML
    protected static Pane pane42;

    @FXML
    private GridPane mazeGrid;

    @FXML
    protected static Pane pane34;

    @FXML
    protected static Pane pane33;

    @FXML
    protected static Pane pane36;

    @FXML
    protected static Pane pane35;

    @FXML
    protected static Pane pane38;

    @FXML
    protected static Pane pane37;

    @FXML
    protected static Pane pane39;

    @FXML
    protected static Pane pane30;

    @FXML
    protected static Pane pane32;

    @FXML
    protected static Pane pane31;

    @FXML
    protected static Pane pane67;

    @FXML
    protected static Pane pane66;

    @FXML
    protected static Pane pane69;

    @FXML
    protected static Pane pane68;

    @FXML
    protected static Pane pane61;

    @FXML
    protected static Pane pane60;

    @FXML
    protected static Pane pane63;

    @FXML
    protected static Pane pane62;

    @FXML
    protected static Pane pane65;

    @FXML
    protected static Pane pane64;

    @FXML
    protected static Pane pane56;

    @FXML
    protected static Pane pane55;

    @FXML
    protected static Pane pane58;

    @FXML
    protected static Pane pane57;

    @FXML
    protected static Pane pane59;

    @FXML
    protected static Pane pane50;

    @FXML
    protected static Pane pane52;

    @FXML
    protected static Pane pane51;

    @FXML
    protected static Pane pane54;

    @FXML
    protected static Pane pane53;

    @FXML
    protected static Pane pane01;

    @FXML
    protected static Pane pane89;

    @FXML
    protected static Pane pane06;
    
    @FXML
    protected static Pane pane00;

    @FXML
    protected static Pane pane88;

    @FXML
    protected static Pane pane03;

    @FXML
    protected static Pane pane02;

    @FXML
    protected static Pane pane05;

    @FXML
    protected static Pane pane04;

    @FXML
    protected static Pane pane07;

    @FXML
    protected static Pane pane81;

    @FXML
    protected static Pane pane80;

    @FXML
    protected static Pane pane83;

    @FXML
    protected static Pane pane82;

    @FXML
    protected static Pane pane85;

    @FXML
    protected static Pane pane84;

    @FXML
    protected static Pane pane87;

    @FXML
    protected static Pane pane86;

    @FXML
    protected static Pane pane90;

    @FXML
    protected static Pane pane09;

    @FXML
    protected static Pane pane08;

    @FXML
    protected static Pane pane78;

    @FXML
    protected static Pane pane77;

    @FXML
    protected static Pane pane79;

    @FXML
    protected static Pane pane70;

    @FXML
    protected static Pane pane72;

    @FXML
    protected static Pane pane71;

    @FXML
    protected static Pane pane74;

    @FXML
    protected static Pane pane73;

    @FXML
    protected static Pane pane76;

    @FXML
    protected static Pane pane75;

	
	public void changeColor(Pane p, String color) {
		p.setStyle("-fx-background-color:" + color + ";");
	}
	
	public void sleep(){
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	@FXML
	void startMazeSolving(KeyEvent event) throws InterruptedException{
	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
