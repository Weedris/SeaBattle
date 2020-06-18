package visuals;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import model.Board;
import model.Model;

public class GridView extends Canvas implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5063819392386455808L;
	
	private Model m;
	
	
	public GridView(Model m) {
		this.m = m;
	}
	
	
	public void paint(Graphics g) {
		
		g.clearRect(0, 0, 10000, 10000);
		
		
		if (this.m.getState() == Model.State.Win) {
			g.setColor(Color.blue);
			g.drawString("You WIN !", 0, 0);
		}
		else if (this.m.getState() == Model.State.Loose) {
			g.setColor(Color.red);
			g.drawString("You Loose !", 0, 0);
		}
		else {
			/* Pour dessiner la grille*/
			
			for (int i = 0; i < Board.size; i++) {
				for (int j = 0; j < Board.size; j++) {
					int tileValue = m.getBoard().getTile(i, j);
					int tileFiredOn = m.getBoard().getfiredOn(i, j);
					
					if (m.getState() == Model.State.Placing) {
						if (tileValue == 1) {
							g.setColor(Color.black);
						}
						else {
							g.setColor(Color.cyan);
						}
					}
					
					/* Si la case a été tirer dessu ou pas*/
					if (m.getState() == Model.State.Firing) {
						if (tileFiredOn == 1) {
							g.setColor(Color.white);
							if (tileValue == 1) {
								g.setColor(Color.black);
							}
						}
						else {
							g.setColor(Color.cyan);
						}
					}
					g.fillRect(50 + 50 * j, 50 + 50 * i, 50, 50);
					
					/* Affichage d'une case*/
					g.setColor(Color.black);
					g.drawRect(50 + 50 * j, 50 + 50 * i, 50, 50);
					
					if (i == this.m.getSelectedTile().x && j == this.m.getSelectedTile().y) {
						g.setColor(Color.red);
						g.drawRect(51 + 50 * j, 51 + 50 * i, 48, 48);
					}
					
				}
			}
			
		}
		
		
		
	}


	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	
}
