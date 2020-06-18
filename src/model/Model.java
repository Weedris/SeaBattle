package model;

import java.awt.Point;
import java.util.Observable;

public class Model extends Observable{
	
	public enum State { Placing, Firing, Win, Loose}
	
	private Board board;
	private State state;
	private Point selectedTile;
	
	
	/*Nouveau Model*/
	public Model() {
		this.board = new Board();
		this.state = State.Placing;
		this.selectedTile = new Point(0, 0);
		
		board.afficher();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
		update();
	}
	
	public void ready() {
		if(this.board.allGood()) {
			setState(Model.State.Firing);
		}
	}
	
	/**
	 * @return the selectedTile
	 */
	public Point getSelectedTile() {
		return selectedTile;
	}

	/**
	 * @param selectedTile the selectedTile to set
	 */
	public void setSelectedTile(Point selectedTile) {
		this.selectedTile = selectedTile;
	}

	public void update() {
		this.setChanged();
		this.notifyObservers();
	}
	
}
