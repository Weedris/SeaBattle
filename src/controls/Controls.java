package controls;

import java.awt.Button;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Board;
import model.Model;

public class Controls implements ActionListener{
	
	private Model mdl;
	
	public 	Controls(Model mdl) {
		this.mdl = mdl;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Button btn = (Button)e.getSource();
		String s = btn.getName();
		System.out.println(s);
		
		if (this.mdl.getState() == Model.State.Placing) {
			switch (s) {
			case "10":
				battleshipUp(0);
				break;
			case "11":
				battleshipRight(0);
				break;
			case "12":
				battleshipDown(0);
				break;
			case "13":
				battleshipLeft(0);
				break;
			case "14":
				battleshipRotate(0);
				break;
			case "20":
				battleshipUp(1);
				break;
			case "21":
				battleshipRight(1);
				break;
			case "22":
				battleshipDown(1);
				break;
			case "23":
				battleshipLeft(1);
				break;
			case "24":
				battleshipRotate(1);
				break;
			case "30":
				battleshipUp(2);
				break;
			case "31":
				battleshipRight(2);
				break;
			case "32":
				battleshipDown(2);
				break;
			case "33":
				battleshipLeft(2);
				break;
			case "34":
				battleshipRotate(2);
				break;
			case "40":
				battleshipUp(3);
				break;
			case "41":
				battleshipRight(3);
				break;
			case "42":
				battleshipDown(3);
				break;
			case "43":
				battleshipLeft(3);
				break;
			case "44":
				battleshipRotate(3);
				break;
			case "50":
				battleshipUp(4);
				break;
			case "51":
				battleshipRight(4);
				break;
			case "52":
				battleshipDown(4);
				break;
			case "53":
				battleshipLeft(4);
				break;
			case "54":
				battleshipRotate(4);
				break;
			case "Ready":
				this.mdl.ready();
			}
		}
		
		if (this.mdl.getState() == Model.State.Firing) {
			switch (s) {
			case "00":
				Point temp = this.mdl.getSelectedTile();
				if (0 <= temp.x - 1) {
					this.mdl.setSelectedTile(new Point(temp.x - 1, temp.y));
					this.mdl.update();
				}
				break;
			case "01":
				Point temp1 = this.mdl.getSelectedTile();
				if (temp1.y + 1 <= Board.size  - 1) {
					this.mdl.setSelectedTile(new Point(temp1.x, temp1.y + 1));
					this.mdl.update();
				}
				break;
			case "02":
				Point temp2 = this.mdl.getSelectedTile();
				if (temp2.x + 1 <= Board.size - 1) {
					this.mdl.setSelectedTile(new Point(temp2.x + 1, temp2.y));
					this.mdl.update();
				}
				break;
			case "03":
				Point temp3 = this.mdl.getSelectedTile();
				if (0 <= temp3.y - 1) {
					this.mdl.setSelectedTile(new Point(temp3.x, temp3.y - 1));
					this.mdl.update();
				}
				break;
			case "04":
				Point temp4 = this.mdl.getSelectedTile();
				if (this.mdl.getBoard().setfiredOn(temp4.x, temp4.y, 1)) {
					this.mdl.setState(Model.State.Win);
					System.out.println("bravo !");
				}
				this.mdl.update();
			}
		}
		
		
	}
	
	public void battleshipUp(int nbr) {
		int x = this.mdl.getBoard().getbattleship()[nbr].x;
		int y = this.mdl.getBoard().getbattleship()[nbr].y;
		this.mdl.getBoard().setbattleship(nbr, x - 1, y);
		this.mdl.update();
	}
	
	public void battleshipRight(int nbr) {
		int x = this.mdl.getBoard().getbattleship()[nbr].x;
		int y = this.mdl.getBoard().getbattleship()[nbr].y;
		this.mdl.getBoard().setbattleship(nbr, x, y + 1);
		this.mdl.update();
	}
	
	public void battleshipDown(int nbr) {
		int x = this.mdl.getBoard().getbattleship()[nbr].x;
		int y = this.mdl.getBoard().getbattleship()[nbr].y;
		this.mdl.getBoard().setbattleship(nbr, x + 1, y);
		this.mdl.update();
	}
	
	public void battleshipLeft(int nbr) {
		int x = this.mdl.getBoard().getbattleship()[nbr].x;
		int y = this.mdl.getBoard().getbattleship()[nbr].y;
		this.mdl.getBoard().setbattleship(nbr, x, y - 1);
		this.mdl.update();
	}
	
	public void battleshipRotate(int nbr) {
		this.mdl.getBoard().getbattleship()[nbr].rotate();
		this.mdl.getBoard().reshape();
		this.mdl.update();
	}

}
