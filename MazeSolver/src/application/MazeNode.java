package application;


import java.util.ArrayList;

import javafx.scene.layout.Pane;

public class MazeNode {
	private Pane pane;
	private int row;
	private int column;
	private ArrayList<MazeNode> neighboors;
	private NodeStatus status; // Start/Finish/Regular Node
	private boolean visited;
	
	public MazeNode(Pane pane, int row, int column, NodeStatus status) {
		super();
		this.pane = pane;
		this.row = row;
		this.column = column;
		this.status = status;
		this.visited = false;
	}
	
	public void addNeighboor(MazeNode mn) {
		neighboors.add(mn);
	}
}
