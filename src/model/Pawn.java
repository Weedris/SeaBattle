package model;

import java.awt.Point;


public class Pawn extends Point{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7156855515158598340L;

	enum Direction { 
		South, East;
		private static Direction[] vals = values();
		public Direction next() {
			return vals[(this.ordinal() + 1) % vals.length];
			}
		}
	
	private int lenght;
	private Direction direction;
	
	
	public Pawn(int l, int x, int y) {
		super();
		this.setLenght(l);
		this.x = x;
		this.y = y;
		this.direction = Direction.South;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public Direction getDirection() {
		return direction;
	}

	public void rotate() {
		this.direction = direction.next();
	}
	
	
}
