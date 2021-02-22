package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.NodeList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MazeController implements Initializable{

	// Variables: 
	private MazeNode nodes[][];

	private String visitedColor = "rgb(170, 88, 57)";
	private String pathColor = "rgb(219, 64, 6)";
	private String finalPathColor = "rgb(1, 144, 1)";
	private Stack<MazeNode> path;
	private MazeNode current; // Head of the Stack
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nodes = new MazeNode[10][10];
		initMazeNodes();
		initNeighbors();
		path = new Stack<MazeNode>();
		goTo(nodes[0][0]);
	}


	@FXML
    void SolveMaze(ActionEvent event) {
		// Available neighbors of a certain node
		HashMap<Directions, MazeNode> availableNeighbors;
		
		// Azimuth from a certain node to the end of the maze
		float azimuth;
		
		// prioritized Directions for a node by his azimuth to the end
		ArrayList<Directions> prioritizeDirections; 
		
		solveBtn.setDisable(true);
		
		while(current.getStatus()!=NodeStatus.FINISH) {
			availableNeighbors = availableNeighbors(current);
			azimuth = calculateDirection(current.getRow(), current.getColumn()); 
			prioritizeDirections = prioritizeDirections(azimuth);
			prioritize(availableNeighbors, prioritizeDirections); // take a step in the maze	
		}			
	}
	
	
	public void prioritize(HashMap<Directions, MazeNode> availableNeighbors,
			ArrayList<Directions> prioritizeDirections) {
		if(availableNeighbors.size()==0) {
			goBack();
		}
		else {
			if(availableNeighbors.size()==1) {
				MazeNode onlyNeighbor = (MazeNode) availableNeighbors.values().toArray()[0];
				goTo(onlyNeighbor);
			}
			else {
				for(Directions d:prioritizeDirections) {
					if(availableNeighbors.get(d)!=null && !availableNeighbors.get(d).isVisited()) {
						goTo(current.getNeighbors().get(d));
						return;
					}
				}
			}
		}
	}
	
	public HashMap<Directions, MazeNode> availableNeighbors(MazeNode m) { // return the available neighbors of a node
		HashMap<Directions, MazeNode> neighbors = m.getNeighbors();
		HashMap<Directions, MazeNode> availableNeighbors = new HashMap<Directions, MazeNode>();
		
		if(neighbors.get(Directions.LEFT)!=null && !neighbors.get(Directions.LEFT).isVisited()) {
			availableNeighbors.put(Directions.LEFT, neighbors.get(Directions.LEFT));
		}
		if(neighbors.get(Directions.RIGHT)!=null &&  !neighbors.get(Directions.RIGHT).isVisited()) {
			availableNeighbors.put(Directions.RIGHT, neighbors.get(Directions.RIGHT));
		}
		if(neighbors.get(Directions.UP)!=null &&  !neighbors.get(Directions.UP).isVisited()) {
			availableNeighbors.put(Directions.UP, neighbors.get(Directions.UP));
		}
		if(neighbors.get(Directions.DOWN)!=null &&  !neighbors.get(Directions.DOWN).isVisited()) {
			availableNeighbors.put(Directions.DOWN, neighbors.get(Directions.DOWN));
		}
		
		return availableNeighbors;
	}
	
	public void updateCurrent() { // Update the current head of the Stack
		current = path.peek();
	}
	
	public void goTo(MazeNode m) { // Go to a Node
		m.setVisited(true);
		changeColor(m.getPane(), pathColor);
		path.push(m);
		updateCurrent();
		//delay();
	}
	
	public void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR while sleeping");
		}
	}
	
	public void goBack() { // Go back to the previous Node
		changeColor(path.peek().getPane(), visitedColor);
		path.pop();
		updateCurrent();
	}
	
	public float calculateDirection(int x, int y) { // calculate the azimuth from a node to the end of the maze
	    float angle = (float) Math.toDegrees(Math.atan2(9 - y, 9 - x));
	    
	    if(angle < 0){
	        angle += 360;
	    }

	    return angle;
	}
	
	public ArrayList<Directions> prioritizeDirections(float deg){ // Prioritize the directions for each Node
		float degree = deg;
		ArrayList<Directions> priorities = new ArrayList<Directions>();
		
		priorities.add(degreeToDirection(degree));
		priorities.add(degreeToDirection(degree+90));
		priorities.add(degreeToDirection(degree-90));
		priorities.add(degreeToDirection(degree-180));
		
		return priorities;
	}
	
	public Directions degreeToDirection(float deg) { // convert a degree to direction
		if(deg<0) {
			deg += 360;
		}
		if((deg>=315 && deg<=360) || (deg>=0 && deg<45)) {
			return Directions.RIGHT;
		}
		else {
			if(deg>=45 && deg<135) {
				return Directions.DOWN;
			}
			else {
				if(deg>=135 && deg<225) {
					return Directions.LEFT;
				}
				else {
					if(deg>=225 && deg<315) {
						return Directions.UP;
					}
				}
			}
		}
		return null;
	}
	
	public void changeColor(Pane p, String color) { // change the color of a node in the maze
		p.setStyle("-fx-background-color:" + color + ";");
	}
	
	@FXML
    private Button solveBtn;
    
	@FXML
	private Pane pane23;
	
	@FXML
	private Pane pane22;
	
	@FXML
	private Pane pane25;
	
	@FXML
	private Pane pane24;
	
	@FXML
	private Pane pane27;
	
	@FXML
	private Pane pane26;
	
	@FXML
	private Pane pane29;
	
	@FXML
	private Pane pane28;
	
	@FXML
	private Pane pane21;
	
	@FXML
	private Pane pane20;
	
	@FXML
	private Pane pane12;
	
	@FXML
	private Pane pane11;

	@FXML
	private Pane pane99;

	@FXML
	private Pane pane14;

	@FXML
	private Pane pane13;

	@FXML
	private Pane pane16;

	@FXML
	private Pane pane15;

	@FXML
	private Pane pane18;

	@FXML
	private Pane pane17;

	@FXML
	private Pane pane92;

	@FXML
	private Pane pane91;

	@FXML
	private Pane pane94;

	@FXML
	private Pane pane93;

	@FXML
	private Pane pane96;

	@FXML
	private Pane pane95;

	@FXML
	private Pane pane10;

	@FXML
	private Pane pane98;

	@FXML
	private Pane pane97;

	@FXML
	private Pane pane19;

	@FXML
	private Pane pane45;

	@FXML
	private Pane pane44;

	@FXML
	private Pane pane47;

	@FXML
	private Pane pane46;

	@FXML
	private Pane pane49;

	@FXML
	private Pane pane48;

	@FXML
	private Pane pane41;

	@FXML
	private Pane pane40;

	@FXML
	private Pane pane43;

	@FXML
	private Pane pane42;

	@FXML
	private GridPane mazeGrid;

	@FXML
	private Pane pane34;

	@FXML
	private Pane pane33;

	@FXML
	private Pane pane36;

	@FXML
	private Pane pane35;

	@FXML
	private Pane pane38;

	@FXML
	private Pane pane37;

	@FXML
	private Pane pane39;

	@FXML
	private Pane pane30;

	@FXML
	private Pane pane32;

	@FXML
	private Pane pane31;

	@FXML
	private Pane pane67;

	@FXML
	private Pane pane66;

	@FXML
	private Pane pane69;

	@FXML
	private Pane pane68;

	@FXML
	private Pane pane61;

	@FXML
	private Pane pane60;

	@FXML
	private Pane pane63;

	@FXML
	private Pane pane62;

	@FXML
	private Pane pane65;

	@FXML
	private Pane pane64;

	@FXML
	private Pane pane56;

	@FXML
	private Pane pane55;

	@FXML
	private Pane pane58;

	@FXML
	private Pane pane57;

	@FXML
	private Pane pane59;

	@FXML
	private Pane pane50;

	@FXML
	private Pane pane52;

	@FXML
	private Pane pane51;

	@FXML
	private Pane pane54;

	@FXML
	private Pane pane53;

	@FXML
	private Pane pane01;

	@FXML
	private Pane pane89;

	@FXML
	private Pane pane06;

	@FXML
	private Pane pane00;

	@FXML
	private Pane pane88;

	@FXML
	private Pane pane03;

	@FXML
	private Pane pane02;

	@FXML
	private Pane pane05;

	@FXML
	private Pane pane04;

	@FXML
	private Pane pane07;

	@FXML
	private Pane pane81;

	@FXML
	private Pane pane80;

	@FXML
	private Pane pane83;

	@FXML
	private Pane pane82;

	@FXML
	private Pane pane85;

	@FXML
	private Pane pane84;

	@FXML
	private Pane pane87;

	@FXML
	private Pane pane86;

	@FXML
	private Pane pane90;

	@FXML
	private Pane pane09;

	@FXML
	private Pane pane08;

	@FXML
	private Pane pane78;

	@FXML
	private Pane pane77;

	@FXML
	private Pane pane79;

	@FXML
	private Pane pane70;

	@FXML
	private Pane pane72;

	@FXML
	private Pane pane71;

	@FXML
	private Pane pane74;

	@FXML
	private Pane pane73;

	@FXML
	private Pane pane76;

	@FXML
	private Pane pane75;


	public void initMazeNodes() {
		nodes[0][0] = new MazeNode(pane00 , 0, 0, NodeStatus.START);
		nodes[0][1] = new MazeNode(pane01 , 0, 1, NodeStatus.REGULAR);
		nodes[0][2] = new MazeNode(pane02 , 0, 2, NodeStatus.REGULAR);
		nodes[0][3] = new MazeNode(pane03 , 0, 3, NodeStatus.REGULAR);
		nodes[0][4] = new MazeNode(pane04 , 0, 4, NodeStatus.REGULAR);
		nodes[0][5] = new MazeNode(pane05 , 0, 5, NodeStatus.REGULAR);
		nodes[0][6] = new MazeNode(pane06 , 0, 6, NodeStatus.REGULAR);
		nodes[0][7] = new MazeNode(pane07 , 0, 7, NodeStatus.REGULAR);
		nodes[0][8] = new MazeNode(pane08 , 0, 8, NodeStatus.REGULAR);
		nodes[0][9] = new MazeNode(pane09 , 0, 9, NodeStatus.REGULAR);

		nodes[1][0] = new MazeNode(pane10 , 1, 0, NodeStatus.REGULAR);
		nodes[1][1] = new MazeNode(pane11 , 1, 1, NodeStatus.REGULAR);
		nodes[1][2] = new MazeNode(pane12 , 1, 2, NodeStatus.REGULAR);
		nodes[1][3] = new MazeNode(pane13 , 1, 3, NodeStatus.REGULAR);
		nodes[1][4] = new MazeNode(pane14 , 1, 4, NodeStatus.REGULAR);
		nodes[1][5] = new MazeNode(pane15 , 1, 5, NodeStatus.REGULAR);
		nodes[1][6] = new MazeNode(pane16 , 1, 6, NodeStatus.REGULAR);
		nodes[1][7] = new MazeNode(pane17 , 1, 7, NodeStatus.REGULAR);
		nodes[1][8] = new MazeNode(pane18 , 1, 8, NodeStatus.REGULAR);
		nodes[1][9] = new MazeNode(pane19 , 1, 9, NodeStatus.REGULAR);

		nodes[2][0] = new MazeNode(pane20 , 2, 0, NodeStatus.REGULAR);
		nodes[2][1] = new MazeNode(pane21 , 2, 1, NodeStatus.REGULAR);
		nodes[2][2] = new MazeNode(pane22 , 2, 2, NodeStatus.REGULAR);
		nodes[2][3] = new MazeNode(pane23 , 2, 3, NodeStatus.REGULAR);
		nodes[2][4] = new MazeNode(pane24 , 2, 4, NodeStatus.REGULAR);
		nodes[2][5] = new MazeNode(pane25 , 2, 5, NodeStatus.REGULAR);
		nodes[2][6] = new MazeNode(pane26 , 2, 6, NodeStatus.REGULAR);
		nodes[2][7] = new MazeNode(pane27 , 2, 7, NodeStatus.REGULAR);
		nodes[2][8] = new MazeNode(pane28 , 2, 8, NodeStatus.REGULAR);
		nodes[2][9] = new MazeNode(pane29 , 2, 9, NodeStatus.REGULAR);

		nodes[3][0] = new MazeNode(pane30 , 3, 0, NodeStatus.REGULAR);
		nodes[3][1] = new MazeNode(pane31 , 3, 1, NodeStatus.REGULAR);
		nodes[3][2] = new MazeNode(pane32 , 3, 2, NodeStatus.REGULAR);
		nodes[3][3] = new MazeNode(pane33 , 3, 3, NodeStatus.REGULAR);
		nodes[3][4] = new MazeNode(pane34 , 3, 4, NodeStatus.REGULAR);
		nodes[3][5] = new MazeNode(pane35 , 3, 5, NodeStatus.REGULAR);
		nodes[3][6] = new MazeNode(pane36 , 3, 6, NodeStatus.REGULAR);
		nodes[3][7] = new MazeNode(pane37 , 3, 7, NodeStatus.REGULAR);
		nodes[3][8] = new MazeNode(pane38 , 3, 8, NodeStatus.REGULAR);
		nodes[3][9] = new MazeNode(pane39 , 3, 9, NodeStatus.REGULAR);

		nodes[4][0] = new MazeNode(pane40 , 4, 0, NodeStatus.REGULAR);
		nodes[4][1] = new MazeNode(pane41 , 4, 1, NodeStatus.REGULAR);
		nodes[4][2] = new MazeNode(pane42 , 4, 2, NodeStatus.REGULAR);
		nodes[4][3] = new MazeNode(pane43 , 4, 3, NodeStatus.REGULAR);
		nodes[4][4] = new MazeNode(pane44 , 4, 4, NodeStatus.REGULAR);
		nodes[4][5] = new MazeNode(pane45 , 4, 5, NodeStatus.REGULAR);
		nodes[4][6] = new MazeNode(pane46 , 4, 6, NodeStatus.REGULAR);
		nodes[4][7] = new MazeNode(pane47 , 4, 7, NodeStatus.REGULAR);
		nodes[4][8] = new MazeNode(pane48 , 4, 8, NodeStatus.REGULAR);
		nodes[4][9] = new MazeNode(pane49 , 4, 9, NodeStatus.REGULAR);

		nodes[5][0] = new MazeNode(pane50 , 5, 0, NodeStatus.REGULAR);
		nodes[5][1] = new MazeNode(pane51 , 5, 1, NodeStatus.REGULAR);
		nodes[5][2] = new MazeNode(pane52 , 5, 2, NodeStatus.REGULAR);
		nodes[5][3] = new MazeNode(pane53 , 5, 3, NodeStatus.REGULAR);
		nodes[5][4] = new MazeNode(pane54 , 5, 4, NodeStatus.REGULAR);
		nodes[5][5] = new MazeNode(pane55 , 5, 5, NodeStatus.REGULAR);
		nodes[5][6] = new MazeNode(pane56 , 5, 6, NodeStatus.REGULAR);
		nodes[5][7] = new MazeNode(pane57 , 5, 7, NodeStatus.REGULAR);
		nodes[5][8] = new MazeNode(pane58 , 5, 8, NodeStatus.REGULAR);
		nodes[5][9] = new MazeNode(pane59 , 5, 9, NodeStatus.REGULAR);

		nodes[6][0] = new MazeNode(pane60 , 6, 0, NodeStatus.REGULAR);
		nodes[6][1] = new MazeNode(pane61 , 6, 1, NodeStatus.REGULAR);
		nodes[6][2] = new MazeNode(pane62 , 6, 2, NodeStatus.REGULAR);
		nodes[6][3] = new MazeNode(pane63 , 6, 3, NodeStatus.REGULAR);
		nodes[6][4] = new MazeNode(pane64 , 6, 4, NodeStatus.REGULAR);
		nodes[6][5] = new MazeNode(pane65 , 6, 5, NodeStatus.REGULAR);
		nodes[6][6] = new MazeNode(pane66 , 6, 6, NodeStatus.REGULAR);
		nodes[6][7] = new MazeNode(pane67 , 6, 7, NodeStatus.REGULAR);
		nodes[6][8] = new MazeNode(pane68 , 6, 8, NodeStatus.REGULAR);
		nodes[6][9] = new MazeNode(pane69 , 6, 9, NodeStatus.REGULAR);

		nodes[7][0] = new MazeNode(pane70 , 7, 0, NodeStatus.REGULAR);
		nodes[7][1] = new MazeNode(pane71 , 7, 1, NodeStatus.REGULAR);
		nodes[7][2] = new MazeNode(pane72 , 7, 2, NodeStatus.REGULAR);
		nodes[7][3] = new MazeNode(pane73 , 7, 3, NodeStatus.REGULAR);
		nodes[7][4] = new MazeNode(pane74 , 7, 4, NodeStatus.REGULAR);
		nodes[7][5] = new MazeNode(pane75 , 7, 5, NodeStatus.REGULAR);
		nodes[7][6] = new MazeNode(pane76 , 7, 6, NodeStatus.REGULAR);
		nodes[7][7] = new MazeNode(pane77 , 7, 7, NodeStatus.REGULAR);
		nodes[7][8] = new MazeNode(pane78 , 7, 8, NodeStatus.REGULAR);
		nodes[7][9] = new MazeNode(pane79 , 7, 9, NodeStatus.REGULAR);

		nodes[8][0] = new MazeNode(pane80 , 8, 0, NodeStatus.REGULAR);
		nodes[8][1] = new MazeNode(pane81 , 8, 1, NodeStatus.REGULAR);
		nodes[8][2] = new MazeNode(pane82 , 8, 2, NodeStatus.REGULAR);
		nodes[8][3] = new MazeNode(pane83 , 8, 3, NodeStatus.REGULAR);
		nodes[8][4] = new MazeNode(pane84 , 8, 4, NodeStatus.REGULAR);
		nodes[8][5] = new MazeNode(pane85 , 8, 5, NodeStatus.REGULAR);
		nodes[8][6] = new MazeNode(pane86 , 8, 6, NodeStatus.REGULAR);
		nodes[8][7] = new MazeNode(pane87 , 8, 7, NodeStatus.REGULAR);
		nodes[8][8] = new MazeNode(pane88 , 8, 8, NodeStatus.REGULAR);
		nodes[8][9] = new MazeNode(pane89 , 8, 9, NodeStatus.REGULAR);

		nodes[9][0] = new MazeNode(pane90 , 9, 0, NodeStatus.REGULAR);
		nodes[9][1] = new MazeNode(pane91 , 9, 1, NodeStatus.REGULAR);
		nodes[9][2] = new MazeNode(pane92 , 9, 2, NodeStatus.REGULAR);
		nodes[9][3] = new MazeNode(pane93 , 9, 3, NodeStatus.REGULAR);
		nodes[9][4] = new MazeNode(pane94 , 9, 4, NodeStatus.REGULAR);
		nodes[9][5] = new MazeNode(pane95 , 9, 5, NodeStatus.REGULAR);
		nodes[9][6] = new MazeNode(pane96 , 9, 6, NodeStatus.REGULAR);
		nodes[9][7] = new MazeNode(pane97 , 9, 7, NodeStatus.REGULAR);
		nodes[9][8] = new MazeNode(pane98 , 9, 8, NodeStatus.REGULAR);
		nodes[9][9] = new MazeNode(pane99 , 9, 9, NodeStatus.FINISH);
	}

	public void initNeighbors() {
		nodes[0][0].addNeighbor(Directions.DOWN, nodes[1][0]);

		nodes[0][1].addNeighbor(Directions.DOWN, nodes[1][1]);

		nodes[0][2].addNeighbor(Directions.RIGHT, nodes[0][3]);
		nodes[0][2].addNeighbor(Directions.DOWN, nodes[1][2]);

		nodes[0][3].addNeighbor(Directions.LEFT, nodes[0][2]);
		nodes[0][3].addNeighbor(Directions.RIGHT, nodes[0][4]);

		nodes[0][4].addNeighbor(Directions.LEFT, nodes[0][3]);
		nodes[0][4].addNeighbor(Directions.RIGHT, nodes[0][5]);
		nodes[0][4].addNeighbor(Directions.DOWN, nodes[1][4]);

		nodes[0][5].addNeighbor(Directions.LEFT, nodes[0][4]);
		nodes[0][5].addNeighbor(Directions.RIGHT, nodes[0][6]);

		nodes[0][6].addNeighbor(Directions.LEFT, nodes[0][5]);
		nodes[0][6].addNeighbor(Directions.DOWN, nodes[1][6]);

		nodes[0][7].addNeighbor(Directions.RIGHT, nodes[0][8]);
		nodes[0][7].addNeighbor(Directions.DOWN, nodes[1][7]);

		nodes[0][8].addNeighbor(Directions.LEFT, nodes[0][7]);
		nodes[0][8].addNeighbor(Directions.RIGHT, nodes[0][9]);

		nodes[0][9].addNeighbor(Directions.LEFT, nodes[0][8]);
		nodes[0][9].addNeighbor(Directions.DOWN, nodes[1][9]);

		nodes[1][0].addNeighbor(Directions.RIGHT, nodes[1][1]);
		nodes[1][0].addNeighbor(Directions.UP, nodes[0][0]);
		nodes[1][0].addNeighbor(Directions.DOWN, nodes[2][0]);
		
		nodes[1][1].addNeighbor(Directions.LEFT, nodes[1][0]);
		nodes[1][1].addNeighbor(Directions.UP, nodes[0][1]);

		nodes[1][2].addNeighbor(Directions.RIGHT, nodes[1][3]);
		nodes[1][2].addNeighbor(Directions.UP, nodes[0][2]);

		nodes[1][3].addNeighbor(Directions.LEFT, nodes[1][2]);
		nodes[1][3].addNeighbor(Directions.DOWN, nodes[2][3]);

		nodes[1][4].addNeighbor(Directions.UP, nodes[0][4]);
		nodes[1][4].addNeighbor(Directions.DOWN, nodes[2][4]);

		nodes[1][5].addNeighbor(Directions.DOWN, nodes[2][5]);

		nodes[1][6].addNeighbor(Directions.UP, nodes[0][6]);
		nodes[1][6].addNeighbor(Directions.DOWN, nodes[2][6]);

		nodes[1][7].addNeighbor(Directions.UP, nodes[0][7]);
		nodes[1][7].addNeighbor(Directions.DOWN, nodes[2][7]);

		nodes[1][8].addNeighbor(Directions.UP, nodes[2][8]);

		nodes[1][9].addNeighbor(Directions.UP, nodes[0][9]);
		nodes[1][9].addNeighbor(Directions.DOWN, nodes[2][9]);

		nodes[2][0].addNeighbor(Directions.UP, nodes[1][0]);
		nodes[2][0].addNeighbor(Directions.DOWN, nodes[3][0]);

		nodes[2][1].addNeighbor(Directions.RIGHT, nodes[2][2]);
		nodes[2][1].addNeighbor(Directions.DOWN, nodes[3][1]);

		nodes[2][2].addNeighbor(Directions.LEFT, nodes[2][1]);
		nodes[2][2].addNeighbor(Directions.RIGHT, nodes[2][3]);
		nodes[2][2].addNeighbor(Directions.DOWN, nodes[3][2]);

		nodes[2][3].addNeighbor(Directions.LEFT, nodes[2][2]);
		nodes[2][3].addNeighbor(Directions.UP, nodes[1][3]);

		nodes[2][4].addNeighbor(Directions.RIGHT, nodes[2][5]);
		nodes[2][4].addNeighbor(Directions.UP, nodes[1][4]);

		nodes[2][5].addNeighbor(Directions.LEFT, nodes[2][4]);
		nodes[2][5].addNeighbor(Directions.UP, nodes[1][5]);

		nodes[2][6].addNeighbor(Directions.UP, nodes[1][6]);
		nodes[2][6].addNeighbor(Directions.DOWN, nodes[3][6]);

		nodes[2][7].addNeighbor(Directions.RIGHT, nodes[2][8]);
		nodes[2][7].addNeighbor(Directions.UP, nodes[1][7]);

		nodes[2][8].addNeighbor(Directions.LEFT, nodes[2][7]);
		nodes[2][8].addNeighbor(Directions.UP, nodes[1][8]);

		nodes[2][9].addNeighbor(Directions.UP, nodes[1][9]);
		nodes[2][9].addNeighbor(Directions.DOWN, nodes[3][9]);

		nodes[3][0].addNeighbor(Directions.UP, nodes[2][0]);
		nodes[3][0].addNeighbor(Directions.DOWN, nodes[4][0]);

		nodes[3][1].addNeighbor(Directions.UP, nodes[2][1]);
		nodes[3][1].addNeighbor(Directions.DOWN, nodes[4][1]);

		nodes[3][2].addNeighbor(Directions.UP, nodes[2][2]);

		nodes[3][3].addNeighbor(Directions.RIGHT, nodes[3][4]);

		nodes[3][4].addNeighbor(Directions.LEFT, nodes[3][3]);
		nodes[3][4].addNeighbor(Directions.RIGHT, nodes[3][5]);

		nodes[3][5].addNeighbor(Directions.LEFT, nodes[3][4]);
		nodes[3][5].addNeighbor(Directions.RIGHT, nodes[3][6]);

		nodes[3][6].addNeighbor(Directions.LEFT, nodes[3][5]);
		nodes[3][6].addNeighbor(Directions.UP, nodes[2][6]);
		nodes[3][6].addNeighbor(Directions.DOWN, nodes[4][6]);

		nodes[3][7].addNeighbor(Directions.DOWN, nodes[4][7]);

		nodes[3][8].addNeighbor(Directions.UP, nodes[2][8]);
		nodes[3][8].addNeighbor(Directions.DOWN, nodes[4][8]);

		nodes[3][9].addNeighbor(Directions.UP, nodes[2][9]);
		nodes[3][9].addNeighbor(Directions.DOWN, nodes[4][9]);

		nodes[4][0].addNeighbor(Directions.RIGHT, nodes[4][1]);
		nodes[4][0].addNeighbor(Directions.UP, nodes[3][0]);
		nodes[4][0].addNeighbor(Directions.DOWN, nodes[5][0]);

		nodes[4][1].addNeighbor(Directions.LEFT, nodes[4][0]);
		nodes[4][1].addNeighbor(Directions.UP, nodes[3][1]);
		nodes[4][1].addNeighbor(Directions.DOWN, nodes[5][1]);

		nodes[4][2].addNeighbor(Directions.RIGHT, nodes[4][3]);
		nodes[4][2].addNeighbor(Directions.DOWN, nodes[5][2]);

		nodes[4][3].addNeighbor(Directions.LEFT, nodes[4][2]);

		nodes[4][4].addNeighbor(Directions.RIGHT, nodes[4][5]);
		nodes[4][4].addNeighbor(Directions.DOWN, nodes[5][4]);

		nodes[4][5].addNeighbor(Directions.LEFT, nodes[4][4]);
		nodes[4][5].addNeighbor(Directions.RIGHT, nodes[4][6]);

		nodes[4][6].addNeighbor(Directions.LEFT, nodes[4][5]);
		nodes[4][6].addNeighbor(Directions.UP, nodes[3][6]);

		nodes[4][7].addNeighbor(Directions.RIGHT, nodes[4][8]);
		nodes[4][7].addNeighbor(Directions.UP, nodes[3][7]);
		nodes[4][7].addNeighbor(Directions.DOWN, nodes[5][7]);

		nodes[4][8].addNeighbor(Directions.LEFT, nodes[4][7]);
		nodes[4][8].addNeighbor(Directions.UP, nodes[3][8]);
		nodes[4][8].addNeighbor(Directions.DOWN, nodes[5][8]);

		nodes[4][9].addNeighbor(Directions.UP, nodes[3][9]);
		nodes[4][9].addNeighbor(Directions.DOWN, nodes[5][9]);

		nodes[5][0].addNeighbor(Directions.UP, nodes[4][0]);
		nodes[5][0].addNeighbor(Directions.DOWN, nodes[6][0]);

		nodes[5][1].addNeighbor(Directions.RIGHT, nodes[5][2]);
		nodes[5][1].addNeighbor(Directions.UP, nodes[5][1]);

		nodes[5][2].addNeighbor(Directions.LEFT, nodes[5][1]);
		nodes[5][2].addNeighbor(Directions.UP, nodes[4][2]);

		nodes[5][3].addNeighbor(Directions.RIGHT, nodes[5][4]);
		nodes[5][3].addNeighbor(Directions.DOWN, nodes[6][3]);

		nodes[5][4].addNeighbor(Directions.LEFT, nodes[5][3]);
		nodes[5][4].addNeighbor(Directions.UP, nodes[4][4]);

		nodes[5][5].addNeighbor(Directions.RIGHT, nodes[5][6]);
		nodes[5][5].addNeighbor(Directions.DOWN, nodes[6][5]);

		nodes[5][6].addNeighbor(Directions.LEFT, nodes[5][5]);
		nodes[5][6].addNeighbor(Directions.RIGHT, nodes[5][7]);

		nodes[5][7].addNeighbor(Directions.LEFT, nodes[5][6]);
		nodes[5][7].addNeighbor(Directions.UP, nodes[4][7]);

		nodes[5][8].addNeighbor(Directions.UP, nodes[4][8]);

		nodes[5][9].addNeighbor(Directions.UP, nodes[4][9]);
		nodes[5][9].addNeighbor(Directions.DOWN, nodes[6][9]);

		nodes[6][0].addNeighbor(Directions.UP, nodes[5][0]);

		nodes[6][1].addNeighbor(Directions.RIGHT, nodes[6][2]);

		nodes[6][2].addNeighbor(Directions.LEFT, nodes[6][1]);
		nodes[6][2].addNeighbor(Directions.DOWN, nodes[7][2]);

		nodes[6][3].addNeighbor(Directions.UP, nodes[5][3]);
		nodes[6][3].addNeighbor(Directions.DOWN, nodes[7][3]);

		nodes[6][4].addNeighbor(Directions.DOWN, nodes[7][4]);

		nodes[6][5].addNeighbor(Directions.LEFT, nodes[6][6]);
		nodes[6][5].addNeighbor(Directions.UP, nodes[5][5]);

		nodes[6][6].addNeighbor(Directions.LEFT, nodes[6][5]);
		nodes[6][6].addNeighbor(Directions.RIGHT, nodes[6][7]);

		nodes[6][7].addNeighbor(Directions.LEFT, nodes[6][6]);
		nodes[6][7].addNeighbor(Directions.DOWN, nodes[7][7]);

		nodes[6][8].addNeighbor(Directions.RIGHT, nodes[6][9]);
		nodes[6][8].addNeighbor(Directions.DOWN, nodes[7][8]);

		nodes[6][9].addNeighbor(Directions.LEFT, nodes[6][8]);
		nodes[6][9].addNeighbor(Directions.UP, nodes[5][9]);

		nodes[7][0].addNeighbor(Directions.RIGHT, nodes[7][1]);
		nodes[7][0].addNeighbor(Directions.DOWN, nodes[8][0]);

		nodes[7][1].addNeighbor(Directions.LEFT, nodes[7][0]);
		nodes[7][1].addNeighbor(Directions.RIGHT, nodes[7][2]);

		nodes[7][2].addNeighbor(Directions.LEFT, nodes[7][1]);
		nodes[7][2].addNeighbor(Directions.RIGHT, nodes[7][3]);
		nodes[7][2].addNeighbor(Directions.UP, nodes[6][2]);

		nodes[7][3].addNeighbor(Directions.LEFT, nodes[7][2]);
		nodes[7][3].addNeighbor(Directions.RIGHT, nodes[7][4]);
		nodes[7][3].addNeighbor(Directions.UP, nodes[6][3]);

		nodes[7][4].addNeighbor(Directions.LEFT, nodes[7][3]);
		nodes[7][4].addNeighbor(Directions.RIGHT, nodes[7][5]);
		nodes[7][4].addNeighbor(Directions.UP, nodes[6][4]);

		nodes[7][5].addNeighbor(Directions.LEFT, nodes[7][4]);
		nodes[7][5].addNeighbor(Directions.DOWN, nodes[8][5]);

		nodes[7][6].addNeighbor(Directions.RIGHT, nodes[7][7]);

		nodes[7][7].addNeighbor(Directions.LEFT, nodes[7][6]);
		nodes[7][7].addNeighbor(Directions.UP, nodes[6][7]);
		nodes[7][7].addNeighbor(Directions.DOWN, nodes[8][7]);

		nodes[7][8].addNeighbor(Directions.UP, nodes[6][8]);
		nodes[7][8].addNeighbor(Directions.DOWN, nodes[8][8]);

		nodes[7][9].addNeighbor(Directions.DOWN, nodes[8][9]);

		nodes[8][0].addNeighbor(Directions.UP, nodes[7][0]);
		nodes[8][0].addNeighbor(Directions.DOWN, nodes[9][0]);

		nodes[8][1].addNeighbor(Directions.DOWN, nodes[9][1]);

		nodes[8][2].addNeighbor(Directions.RIGHT, nodes[8][3]);

		nodes[8][3].addNeighbor(Directions.LEFT, nodes[8][2]);
		nodes[8][3].addNeighbor(Directions.RIGHT, nodes[8][4]);

		nodes[8][4].addNeighbor(Directions.LEFT, nodes[8][3]);
		nodes[8][4].addNeighbor(Directions.DOWN, nodes[9][4]);

		nodes[8][5].addNeighbor(Directions.RIGHT, nodes[8][6]);
		nodes[8][5].addNeighbor(Directions.UP, nodes[7][5]);

		nodes[8][6].addNeighbor(Directions.LEFT, nodes[8][5]);
		nodes[8][6].addNeighbor(Directions.RIGHT, nodes[8][7]);

		nodes[8][7].addNeighbor(Directions.LEFT, nodes[8][6]);
		nodes[8][7].addNeighbor(Directions.UP, nodes[7][7]);

		nodes[8][8].addNeighbor(Directions.RIGHT, nodes[8][9]);
		nodes[8][8].addNeighbor(Directions.UP, nodes[7][8]);

		nodes[8][9].addNeighbor(Directions.UP, nodes[7][9]);
		nodes[8][9].addNeighbor(Directions.DOWN, nodes[9][9]);

		nodes[9][0].addNeighbor(Directions.RIGHT, nodes[9][1]);
		nodes[9][0].addNeighbor(Directions.UP, nodes[8][0]);

		nodes[9][1].addNeighbor(Directions.LEFT, nodes[9][0]);
		nodes[9][1].addNeighbor(Directions.RIGHT, nodes[9][2]);
		nodes[9][1].addNeighbor(Directions.UP, nodes[8][1]);

		nodes[9][2].addNeighbor(Directions.LEFT, nodes[9][1]);
		nodes[9][2].addNeighbor(Directions.RIGHT, nodes[9][3]);

		nodes[9][3].addNeighbor(Directions.LEFT, nodes[9][2]);

		nodes[9][4].addNeighbor(Directions.RIGHT, nodes[9][5]);
		nodes[9][4].addNeighbor(Directions.UP, nodes[8][4]);

		nodes[9][5].addNeighbor(Directions.LEFT, nodes[9][4]);
		nodes[9][5].addNeighbor(Directions.RIGHT, nodes[9][6]);

		nodes[9][6].addNeighbor(Directions.LEFT, nodes[9][5]);
		nodes[9][6].addNeighbor(Directions.RIGHT, nodes[9][7]);

		nodes[9][7].addNeighbor(Directions.LEFT, nodes[9][6]);
		nodes[9][7].addNeighbor(Directions.RIGHT, nodes[9][8]);

		nodes[9][8].addNeighbor(Directions.LEFT, nodes[9][7]);
		nodes[9][8].addNeighbor(Directions.RIGHT, nodes[9][9]);

		nodes[9][9].addNeighbor(Directions.LEFT, nodes[9][8]);
		nodes[9][9].addNeighbor(Directions.UP, nodes[8][9]);
	}

}
