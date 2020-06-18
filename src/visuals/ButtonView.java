package visuals;


import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

import controls.Controls;

public class ButtonView extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2974322937900927522L;
	
	public ButtonView(Controls ctrl) {
		super();
		setLayout(new GridLayout(7, 1, 5, 5));
		
		
		String[] label = {"Fire", "Porte-Avion", "Croiseur", "Sous-marin 1", "Sous-marin 2", "Torpilleur"};
		String[] secondLabel = {"up", "right", "down", "left", "rotate"};

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				Button btn = new Button();
				if (i == 0 && j == 4) {
					btn.setLabel(label[i]);
				}
				else {
					btn.setLabel(label[i] + " " + secondLabel[j]);
				}
				btn.setName(String.valueOf(i) + String.valueOf(j));
				btn.setBackground(Color.gray);
				btn.addActionListener(ctrl);
				this.add(btn);
			}
		}
		
		Button b6 = new Button("Ready !");
		b6.setName("Ready");
		b6.addActionListener(ctrl);
		this.add(b6);
	}	

}
