/**
 * 
 */
package IHM;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapView extends JPanel {
	private static final long serialVersionUID = -7235920432526423014L;
	MapView() {
		setLayout(new GridLayout(10, 10));
		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				JLabel lab = new JLabel("" + i + ";" + j);
				lab.setBackground(Color.green);
				lab.setOpaque(true);
				lab.setForeground(Color.red);
				lab.setBorder(BorderFactory.createLineBorder(Color.black));
				add(lab, i, j);
			}
		}
	}
}