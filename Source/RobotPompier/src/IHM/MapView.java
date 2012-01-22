/**
 * 
 */
package IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.MapController;
import Model.Cell;
import Model.Map;
import Model.Robot;

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
				JLabel lab = new JLabel();
				lab.setBackground(Color.green);
				lab.setOpaque(true);
				lab.setBorder(BorderFactory.createLineBorder(Color.black));
				add(lab, i, j);
				_map.elementAt(i).add(j, lab);
			}
		}
	}
	
	public MapController getMapController() {
		return _ctrl;
	}
	
	public void setController(MapController ctrl) {
		_ctrl = ctrl;
	}
	
	public void refresh() {
		Map map = _ctrl.getModel();
		int r = 0;
		int c = 0;
		for (ArrayList<Cell> v: map.getCell()) {
			for (Cell cell: v) {
				updateLabel(cell, r, c);
				c++;
			}
			c = 0;
			r++;
		}
	}
	
	/** Code prototype **/
	public void protoRefresh() {
		Map map = _ctrl.getModel();
		int r = 0;
		int c = 0;
		for (ArrayList<Cell> v: map.getCell()) {
			for (Cell cell: v) {
				/** Code prototype **/
				if (r == 3) {
					if (c == 1)
						cell.setRobot(new Robot());
					else if (c == 4)
						cell.setOnFire(2);
				} else if (r == 6)
					if (c == 2)
						cell.setRobot(new Robot());
				/********************/
				updateLabel(cell, r, c);
				c++;
			}
			c = 0;
			r++;
		}
	}
	/*******************/
	
	private void updateLabel(Cell c, int row, int col) {
		System.out.println("=+>" + row + " " + col);
		if (c.isOnFire() > 0) {
			_map.elementAt(row).elementAt(col).setText("<html><font size=\"12\">F</font></html>");
			_map.elementAt(row).elementAt(col).setForeground(Color.red);
		} else if (c.getRobot() != null) {
			_map.elementAt(row).elementAt(col).setText("<html><font size=\"12\">R</font></html>");
			_map.elementAt(row).elementAt(col).setForeground(Color.blue);
		} else {
			_map.elementAt(row).elementAt(col).setText("");
		}
		_map.elementAt(row).elementAt(col).updateUI();
	}
}