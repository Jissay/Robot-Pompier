package IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

import Controller.MapController;
import IHM.DragNDrop.CellDropTarget;
import Model.Cell;
import Model.Map;
import Observer.AMapObserver;

public class MapView extends AMapObserver{
	private Vector<Vector<CellView>>	_map;
	private int						_width;
	private int						_height;
	private JPanel 					_mainPanel;
	
	public JPanel get_mainPanel() {
		return _mainPanel;
	}

	public void set_mainPanel(JPanel _mainPanel) {
		this._mainPanel = _mainPanel;
	}

	MapView(int width, int height) {
		_mainPanel = new JPanel();
		_width = width;
		_height = height;
		_mainPanel.setLayout(new GridLayout(width, height));
		_map = new Vector<Vector<CellView>>();
		for (int i = 0; i < width; ++i)
			_map.addElement(new Vector<CellView>());
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
			try {
				_map.elementAt(row).elementAt(col).setText("");
			} catch(ArrayIndexOutOfBoundsException e) {
			}
		}
		try {
			_map.elementAt(row).elementAt(col).updateUI();
		} catch(ArrayIndexOutOfBoundsException e) {
		}
	}
	
	@Override
	protected void mapLoaded() {
		_width = MapController.getInstance().getModel().getLargeur();
		_height = MapController.getInstance().getModel().getLongueur();
		_mainPanel.setLayout(new GridLayout(_width, _height));
		_map = new Vector<Vector<CellView>>();
		for (int i = 0; i < _width; ++i)
			_map.addElement(new Vector<CellView>());
		
		ArrayList<ArrayList<Cell>> cells = MapController.getInstance().getModel().getCell();
		for (int i = 0; i < _width; ++i) {
			for (int j = 0; j < _height; ++j) {
				CellView lab = new CellView(i, j);
				lab.setDropTarget(new CellDropTarget());
				switch (cells.get(j).get(i).getTerrainType()) {
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
}