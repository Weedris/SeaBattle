package model;

public class Tile {
	
	
	private Boolean occupied;
	private Boolean firedOn;
	
	
	public Tile() {
		occupied = false;
		firedOn = false;
	}
	

	public Boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}

	public Boolean isFiredOn() {
		return firedOn;
	}

	public void setFiredOn(Boolean firedOn) {
		this.firedOn = firedOn;
	}
	
	
	public String toString() {
		String out = occupied.toString();
		out += "--";
		out += firedOn.toString();
		return out;
	}	
	
}
