import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controls.Controls;
import model.Model;
import visuals.ButtonView;
import visuals.GridView;

public class Main extends Frame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4648172894076113183L;

	public static void main(String[] args) {
		
		new Main();		
	}
	
	public Main() {
		
		Model m = new Model();
		Controls ctrl = new Controls(m);
		
		this.setLayout(new BorderLayout());
		
		this.setTitle("Sea Battle of DOOM !");
		this.setBackground(Color.cyan);
		
		GridView gv = new GridView(m);
		this.add(gv, BorderLayout.CENTER);
		m.addObserver(gv);
		
		ButtonView bv = new ButtonView(ctrl);
		this.add(bv, BorderLayout.EAST);
		
		this.pack();
		this.setSize(1300, 600);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});	
		
	}
	
}
