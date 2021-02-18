package application;

import java.util.ArrayList;

public class Maze {
	
	private static Maze mazeInstance = null; 
	private MazeNode nodes[][];
	
	private Maze() {
		nodes = new MazeNode[10][10];
		initMazeNodes();
		initNeighbors();
		System.out.println(nodes[5][5].getNeighbors());
		
	}
	
	public static Maze getInstance(){ 
        if (mazeInstance == null) 
            mazeInstance = new Maze(); 
        
        return mazeInstance; 
    } 
		
	public void initMazeNodes() {
		nodes[0][0] = new MazeNode(MazeController.pane00 , 0, 0, NodeStatus.START);
		nodes[0][1] = new MazeNode(MazeController.pane01 , 0, 1, NodeStatus.REGULAR);
		nodes[0][2] = new MazeNode(MazeController.pane02 , 0, 2, NodeStatus.REGULAR);
		nodes[0][3] = new MazeNode(MazeController.pane03 , 0, 3, NodeStatus.REGULAR);
		nodes[0][4] = new MazeNode(MazeController.pane04 , 0, 4, NodeStatus.REGULAR);
		nodes[0][5] = new MazeNode(MazeController.pane05 , 0, 5, NodeStatus.REGULAR);
		nodes[0][6] = new MazeNode(MazeController.pane06 , 0, 6, NodeStatus.REGULAR);
		nodes[0][7] = new MazeNode(MazeController.pane07 , 0, 7, NodeStatus.REGULAR);
		nodes[0][8] = new MazeNode(MazeController.pane08 , 0, 8, NodeStatus.REGULAR);
		nodes[0][9] = new MazeNode(MazeController.pane09 , 0, 9, NodeStatus.REGULAR);
		
		nodes[1][0] = new MazeNode(MazeController.pane10 , 1, 0, NodeStatus.REGULAR);
		nodes[1][1] = new MazeNode(MazeController.pane11 , 1, 1, NodeStatus.REGULAR);
		nodes[1][2] = new MazeNode(MazeController.pane12 , 1, 2, NodeStatus.REGULAR);
		nodes[1][3] = new MazeNode(MazeController.pane13 , 1, 3, NodeStatus.REGULAR);
		nodes[1][4] = new MazeNode(MazeController.pane14 , 1, 4, NodeStatus.REGULAR);
		nodes[1][5] = new MazeNode(MazeController.pane15 , 1, 5, NodeStatus.REGULAR);
		nodes[1][6] = new MazeNode(MazeController.pane16 , 1, 6, NodeStatus.REGULAR);
		nodes[1][7] = new MazeNode(MazeController.pane17 , 1, 7, NodeStatus.REGULAR);
		nodes[1][8] = new MazeNode(MazeController.pane18 , 1, 8, NodeStatus.REGULAR);
		nodes[1][9] = new MazeNode(MazeController.pane19 , 1, 9, NodeStatus.REGULAR);
		
		nodes[2][0] = new MazeNode(MazeController.pane20 , 2, 0, NodeStatus.REGULAR);
		nodes[2][1] = new MazeNode(MazeController.pane21 , 2, 1, NodeStatus.REGULAR);
		nodes[2][2] = new MazeNode(MazeController.pane22 , 2, 2, NodeStatus.REGULAR);
		nodes[2][3] = new MazeNode(MazeController.pane23 , 2, 3, NodeStatus.REGULAR);
		nodes[2][4] = new MazeNode(MazeController.pane24 , 2, 4, NodeStatus.REGULAR);
		nodes[2][5] = new MazeNode(MazeController.pane25 , 2, 5, NodeStatus.REGULAR);
		nodes[2][6] = new MazeNode(MazeController.pane26 , 2, 6, NodeStatus.REGULAR);
		nodes[2][7] = new MazeNode(MazeController.pane27 , 2, 7, NodeStatus.REGULAR);
		nodes[2][8] = new MazeNode(MazeController.pane28 , 2, 8, NodeStatus.REGULAR);
		nodes[2][9] = new MazeNode(MazeController.pane29 , 2, 9, NodeStatus.REGULAR);
		
		nodes[3][0] = new MazeNode(MazeController.pane30 , 3, 0, NodeStatus.REGULAR);
		nodes[3][1] = new MazeNode(MazeController.pane31 , 3, 1, NodeStatus.REGULAR);
		nodes[3][2] = new MazeNode(MazeController.pane32 , 3, 2, NodeStatus.REGULAR);
		nodes[3][3] = new MazeNode(MazeController.pane33 , 3, 3, NodeStatus.REGULAR);
		nodes[3][4] = new MazeNode(MazeController.pane34 , 3, 4, NodeStatus.REGULAR);
		nodes[3][5] = new MazeNode(MazeController.pane35 , 3, 5, NodeStatus.REGULAR);
		nodes[3][6] = new MazeNode(MazeController.pane36 , 3, 6, NodeStatus.REGULAR);
		nodes[3][7] = new MazeNode(MazeController.pane37 , 3, 7, NodeStatus.REGULAR);
		nodes[3][8] = new MazeNode(MazeController.pane38 , 3, 8, NodeStatus.REGULAR);
		nodes[3][9] = new MazeNode(MazeController.pane39 , 3, 9, NodeStatus.REGULAR);
		
		nodes[4][0] = new MazeNode(MazeController.pane40 , 4, 0, NodeStatus.REGULAR);
		nodes[4][1] = new MazeNode(MazeController.pane41 , 4, 1, NodeStatus.REGULAR);
		nodes[4][2] = new MazeNode(MazeController.pane42 , 4, 2, NodeStatus.REGULAR);
		nodes[4][3] = new MazeNode(MazeController.pane43 , 4, 3, NodeStatus.REGULAR);
		nodes[4][4] = new MazeNode(MazeController.pane44 , 4, 4, NodeStatus.REGULAR);
		nodes[4][5] = new MazeNode(MazeController.pane45 , 4, 5, NodeStatus.REGULAR);
		nodes[4][6] = new MazeNode(MazeController.pane46 , 4, 6, NodeStatus.REGULAR);
		nodes[4][7] = new MazeNode(MazeController.pane47 , 4, 7, NodeStatus.REGULAR);
		nodes[4][8] = new MazeNode(MazeController.pane48 , 4, 8, NodeStatus.REGULAR);
		nodes[4][9] = new MazeNode(MazeController.pane49 , 4, 9, NodeStatus.REGULAR);
		
		nodes[5][0] = new MazeNode(MazeController.pane50 , 5, 0, NodeStatus.REGULAR);
		nodes[5][1] = new MazeNode(MazeController.pane51 , 5, 1, NodeStatus.REGULAR);
		nodes[5][2] = new MazeNode(MazeController.pane52 , 5, 2, NodeStatus.REGULAR);
		nodes[5][3] = new MazeNode(MazeController.pane53 , 5, 3, NodeStatus.REGULAR);
		nodes[5][4] = new MazeNode(MazeController.pane54 , 5, 4, NodeStatus.REGULAR);
		nodes[5][5] = new MazeNode(MazeController.pane55 , 5, 5, NodeStatus.REGULAR);
		nodes[5][6] = new MazeNode(MazeController.pane56 , 5, 6, NodeStatus.REGULAR);
		nodes[5][7] = new MazeNode(MazeController.pane57 , 5, 7, NodeStatus.REGULAR);
		nodes[5][8] = new MazeNode(MazeController.pane58 , 5, 8, NodeStatus.REGULAR);
		nodes[5][9] = new MazeNode(MazeController.pane59 , 5, 9, NodeStatus.REGULAR);
		
		nodes[6][0] = new MazeNode(MazeController.pane60 , 6, 0, NodeStatus.REGULAR);
		nodes[6][1] = new MazeNode(MazeController.pane61 , 6, 1, NodeStatus.REGULAR);
		nodes[6][2] = new MazeNode(MazeController.pane62 , 6, 2, NodeStatus.REGULAR);
		nodes[6][3] = new MazeNode(MazeController.pane63 , 6, 3, NodeStatus.REGULAR);
		nodes[6][4] = new MazeNode(MazeController.pane64 , 6, 4, NodeStatus.REGULAR);
		nodes[6][5] = new MazeNode(MazeController.pane65 , 6, 5, NodeStatus.REGULAR);
		nodes[6][6] = new MazeNode(MazeController.pane66 , 6, 6, NodeStatus.REGULAR);
		nodes[6][7] = new MazeNode(MazeController.pane67 , 6, 7, NodeStatus.REGULAR);
		nodes[6][8] = new MazeNode(MazeController.pane68 , 6, 8, NodeStatus.REGULAR);
		nodes[6][9] = new MazeNode(MazeController.pane69 , 6, 9, NodeStatus.REGULAR);
		
		nodes[7][0] = new MazeNode(MazeController.pane70 , 7, 0, NodeStatus.REGULAR);
		nodes[7][1] = new MazeNode(MazeController.pane71 , 7, 1, NodeStatus.REGULAR);
		nodes[7][2] = new MazeNode(MazeController.pane72 , 7, 2, NodeStatus.REGULAR);
		nodes[7][3] = new MazeNode(MazeController.pane73 , 7, 3, NodeStatus.REGULAR);
		nodes[7][4] = new MazeNode(MazeController.pane74 , 7, 4, NodeStatus.REGULAR);
		nodes[7][5] = new MazeNode(MazeController.pane75 , 7, 5, NodeStatus.REGULAR);
		nodes[7][6] = new MazeNode(MazeController.pane76 , 7, 6, NodeStatus.REGULAR);
		nodes[7][7] = new MazeNode(MazeController.pane77 , 7, 7, NodeStatus.REGULAR);
		nodes[7][8] = new MazeNode(MazeController.pane78 , 7, 8, NodeStatus.REGULAR);
		nodes[7][9] = new MazeNode(MazeController.pane79 , 7, 9, NodeStatus.REGULAR);
		
		nodes[8][0] = new MazeNode(MazeController.pane80 , 8, 0, NodeStatus.REGULAR);
		nodes[8][1] = new MazeNode(MazeController.pane81 , 8, 1, NodeStatus.REGULAR);
		nodes[8][2] = new MazeNode(MazeController.pane82 , 8, 2, NodeStatus.REGULAR);
		nodes[8][3] = new MazeNode(MazeController.pane83 , 8, 3, NodeStatus.REGULAR);
		nodes[8][4] = new MazeNode(MazeController.pane84 , 8, 4, NodeStatus.REGULAR);
		nodes[8][5] = new MazeNode(MazeController.pane85 , 8, 5, NodeStatus.REGULAR);
		nodes[8][6] = new MazeNode(MazeController.pane86 , 8, 6, NodeStatus.REGULAR);
		nodes[8][7] = new MazeNode(MazeController.pane87 , 8, 7, NodeStatus.REGULAR);
		nodes[8][8] = new MazeNode(MazeController.pane88 , 8, 8, NodeStatus.REGULAR);
		nodes[8][9] = new MazeNode(MazeController.pane89 , 8, 9, NodeStatus.REGULAR);
		
		nodes[9][0] = new MazeNode(MazeController.pane90 , 9, 0, NodeStatus.REGULAR);
		nodes[9][1] = new MazeNode(MazeController.pane91 , 9, 1, NodeStatus.REGULAR);
		nodes[9][2] = new MazeNode(MazeController.pane92 , 9, 2, NodeStatus.REGULAR);
		nodes[9][3] = new MazeNode(MazeController.pane93 , 9, 3, NodeStatus.REGULAR);
		nodes[9][4] = new MazeNode(MazeController.pane94 , 9, 4, NodeStatus.REGULAR);
		nodes[9][5] = new MazeNode(MazeController.pane95 , 9, 5, NodeStatus.REGULAR);
		nodes[9][6] = new MazeNode(MazeController.pane96 , 9, 6, NodeStatus.REGULAR);
		nodes[9][7] = new MazeNode(MazeController.pane97 , 9, 7, NodeStatus.REGULAR);
		nodes[9][8] = new MazeNode(MazeController.pane98 , 9, 8, NodeStatus.REGULAR);
		nodes[9][9] = new MazeNode(MazeController.pane99 , 9, 9, NodeStatus.FINISH);
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
