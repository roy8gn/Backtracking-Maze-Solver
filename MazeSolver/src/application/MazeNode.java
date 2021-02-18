package application;


import java.util.HashMap;

import javafx.scene.layout.Pane;

public class MazeNode {
	private Pane pane;
	private int row;
	private int column;
	private HashMap<Directions, MazeNode> neighbors;
	private NodeStatus status; // Start/Finish/Regular Node
	private boolean visited;
	
	public MazeNode(Pane pane, int row, int column, NodeStatus status) {
		super();
		this.pane = pane;
		this.row = row;
		this.column = column;
		this.status = status;
		this.visited = false;
		this.neighbors = new HashMap<Directions, MazeNode>();
	}
	
	public void addNeighbor(Directions dir, MazeNode mn) {
		neighbors.put(dir, mn);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Pane getPane() {
		return pane;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public HashMap<Directions, MazeNode> getNeighbors() {
		return neighbors;
	}

	public NodeStatus getStatus() {
		return status;
	}
	
	
}


