package IHM;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.MapController;
import IHM.DragNDrop.CellDropTarget;
import IHM.listeners.CellClickListener;
import Model.Cell;
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
		MapController ctrl = MapController.getInstance();
		int r = ctrl.getLongueur();
		int c = ctrl.getLargeur();
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				updateLabel(i, j, ctrl.containsRobot(i, j), ctrl.isOnFire(i, j));
			}
		}
		_mainPanel.updateUI();
	}
	
	private void updateLabel(int row, int col, boolean hasRobot, boolean isOnFire) {
		if (isOnFire) {
			_map.elementAt(row).elementAt(col).setText("<html><font size=\"12\">F</font></html>");
			_map.elementAt(row).elementAt(col).setForeground(Color.red);
		} else if (hasRobot) {
			_map.elementAt(row).elementAt(col).setText("<html><font size=\"12\">R</font></html>");
			_map.elementAt(row).elementAt(col).setForeground(Color.blue);
		} else {
			_map.elementAt(row).elementAt(col).setText("");
		}
		//_map.elementAt(row).elementAt(col).updateUI();
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
				lab.setDropTarget(new CellDropTarget(i, j));
				lab.addMouseListener(new CellClickListener(i, j));
				switch (cells.get(i).get(j).getTerrainType()) {
				case GRASS:
					lab.setBackground(Color.green);
					break;
				case SNOW:
					lab.setBackground(Color.gray);
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
	protected void mapSetRobot(int x, int y, String url) {
		JLabel cell = _map.get(x).get(y);
		if (url != null) {
			ImageIcon image = new ImageIcon(Class.class.getResource(url));
			image.setImage(image.getImage().getScaledInstance(cell.getWidth(), cell.getHeight(), Image.SCALE_DEFAULT));
			cell.setIcon(image);
		} else
			cell.setIcon(null);
	}

	@Override
	protected void mapSetFire(int x, int y, int oldLevel, int fireLevel) {
		JLabel cell = _map.get(x).get(y);
		if (fireLevel > 0) {
			ImageIcon image = new ImageIcon(Class.class.getResource("/images/flamme.png"));
			image.setImage(image.getImage().getScaledInstance(cell.getWidth(), cell.getHeight(), Image.SCALE_DEFAULT));
			cell.setIcon(image);
		} else
			cell.setIcon(null);
	}

	@Override
	protected void mapReloading() {
		 for (Vector<JLabel> vectorLabel : _map)
			 for (JLabel label : vectorLabel)
			 {
				 label.setIcon(null);
			 }
	}
}