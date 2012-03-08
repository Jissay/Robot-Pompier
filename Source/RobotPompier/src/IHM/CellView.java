package IHM;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CellView extends JLabel {
	private int _x;
	private int _y;
	
	public CellView(int x, int y) {
		super();
		_x = x;
		_y = y;
	}
	
	public int getX() {
		return _x;
	}
	
	public int getY() {
		return _y;
	}
}
