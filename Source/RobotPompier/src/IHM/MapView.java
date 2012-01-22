/**
 * 
 */
package IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.MapController;

public class MapView extends JPanel {
	private static final long serialVersionUID = -7235920432526423014L;
	private Vector<Vector<JLabel>>	_map;
	private MapController			_ctrl;
	
	MapView(int width, int height) {
		setLayout(new GridLayout(width, height));
		_map = new Vector<Vector<JLabel>>();
		for (int i = 0; i < width; ++i) {
			_map.addElement(new Vector<JLabel>());
		}
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < height; ++j) {
				JLabel lab = new JLabel("" + i + ";" + j);
				lab.setBackground(Color.green);
				lab.setOpaque(true);
				lab.setForeground(Color.red);
				lab.setBorder(BorderFactory.createLineBorder(Color.black));
				add(lab, i, j);
				_map.elementAt(i).add(j, lab);
			}
		}
	}
	
	public void setController(MapController ctrl) {
		_ctrl = ctrl;
	}
	
	public void refresh() {
		
	}
}