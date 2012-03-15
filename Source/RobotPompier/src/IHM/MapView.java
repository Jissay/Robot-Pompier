package IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.MapController;
import Model.Cell;
import Model.Map;
import Observer.AMapObserver;

public class MapView extends AMapObserver{
	private Vector<Vector<JLabel>>		_map;
	private int							_width;
	private int							_height;
	private JPanel 						_mainPanel;
	
	public JPanel getMainPanel() {
		return _mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		_mainPanel = mainPanel;
	}

	MapView() {
		_mainPanel = new JPanel();
		_width = 0;
		_height = 0;
		_map = new Vector<Vector<JLabel>>();
	}
	
	public void refresh() {
		Map map = MapController.getInstance().getModel();
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
	
	@Override
	protected void mapLoading() {
		
	}
	
	@Override
	protected void mapLoadingFailed() {
		
	}
	
	@Override
	protected void mapLoaded() {
		_width = MapController.getInstance().getModel().getLongueur();
		_height = MapController.getInstance().getModel().getLargeur();
		_mainPanel.setLayout(new GridLayout(_width, _height));
		_map = new Vector<Vector<JLabel>>();
		for (int i = 0; i < _width; ++i)
			_map.addElement(new Vector<JLabel>());
		
		ArrayList<ArrayList<Cell>> cells = MapController.getInstance().getModel().getCell();
		for (int i = 0; i < _width; ++i) {
			for (int j = 0; j < _height; ++j) {
				JLabel lab = new JLabel();
				switch (cells.get(i).get(j).getTerrainType()) {
				case GRASS:
					lab.setBackground(Color.green);
					break;
				case SNOW:
					lab.setBackground(Color.white);
					break;
				case WATER:
					lab.setBackground(Color.blue);
					break;
				case FOREST:
					lab.setBackground(Color.green.darker().darker());
					break;
				case ROCK:
					lab.setBackground(Color.pink.darker());
					break;
				case SWAMP:
					lab.setBackground(Color.green.darker());
					break;
				case SAND:
					lab.setBackground(Color.yellow.brighter().brighter());
					break;
				case AIR:
					lab.setBackground(Color.white);
					break;
				}
				lab.setOpaque(true);
				_mainPanel.add(lab, i, j);
				_map.elementAt(i).add(j, lab);
			}
		}
		refresh();
	}

	@Override
	protected void mapSetRobot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mapSetFire() {
		// TODO Auto-generated method stub
		
	}
}