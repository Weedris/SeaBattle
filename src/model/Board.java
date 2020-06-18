package model;


public class Board {
	
	public static int size = 10;
	
	private int[][] tiles = new int[Board.size][Board.size];
	private int[][] firedOn = new int[Board.size][Board.size];
	private Pawn[] battleship = {new Pawn(5, 5, 0), new Pawn(4, 0, 1), new Pawn(3, 0, 2), new Pawn(3, 0, 3), new Pawn(2, 0, 4)};

	/*Nouveau Board*/
	public Board() {
		reshape();
	}
	
	public int getTile(int x, int y) {
		return tiles[x][y];
	}

	public void setTile(int x, int y, int a) {
		tiles[x][y] = a;
	}
	
	public int getfiredOn(int x, int y) {
		return firedOn[x][y];
	}

	public Boolean setfiredOn(int x, int y, int a) {
		firedOn[x][y] = a;
		
		for (int i = 0; i < Board.size; i++) {
			for (int j = 0; j < Board.size; j++) {
				if (getTile(i, j) == 1) {
					if (getfiredOn(i, j) == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public Pawn[] getbattleship() {
		return battleship;
	}


	public void setbattleship(int nbr, int x, int y) {
		
		this.battleship[nbr].x = x;
		this.battleship[nbr].y = y;
		if (this.battleship[nbr].x < 0) {
			this.battleship[nbr].x = 0;
		}
		else if (this.battleship[nbr].x  + this.battleship[nbr].getLenght() > Board.size && this.battleship[nbr].getDirection() == Pawn.Direction.South) {
			this.battleship[nbr].x = Board.size - this.battleship[nbr].getLenght();
		}
		if (this.battleship[nbr].y < 0) {
			this.battleship[nbr].y = 0;
		}
		else if (this.battleship[nbr].y  + this.battleship[nbr].getLenght() > Board.size && this.battleship[nbr].getDirection() == Pawn.Direction.East) {
			this.battleship[nbr].y = Board.size - this.battleship[nbr].getLenght();
		}
		reshape();
	}
	
	public Boolean boatHere(int x, int y) {
		for (Pawn boat : this.battleship) {
			
			if (boat.getDirection() == Pawn.Direction.South && boat.y == y) {
				for (int i = boat.x; i < boat.getLenght() + boat.x; i++) {
					if (i == x) {
						return true;
					}
				}
			}
			
			else if (boat.getDirection() == Pawn.Direction.East && boat.x == x){
				for (int i = boat.y; i < boat.getLenght() + boat.y; i++) {
					if (i == y) {
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	public void reshape() {
		for (int i = 0; i < Board.size; i++) {
			for (int j = 0; j < Board.size; j++) {
				tiles[i][j] = 0;
				firedOn[i][j] = 0;
				if (boatHere(i, j)) {
					tiles[i][j] = 1;
				}
			}
		}
	}
	
	public Boolean allGood() {
		int temp = 0;
		for (int i = 0; i < Board.size; i++) {
			for (int j = 0; j < Board.size; j++) {
				if (tiles[i][j] == 1) {
					temp++;
				}
			}
		}
		return temp == 17;
	}
	
	public void afficher() {
		for (int i = 0; i < Board.size; i++) {
			for (int j = 0; j < Board.size; j++) {
				System.out.print("_" + tiles[i][j] + "-" +  firedOn[i][j] + "_");
			}
			System.out.println();
		}
	}

	
}
