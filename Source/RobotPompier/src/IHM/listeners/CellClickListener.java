package IHM.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Controller.MapController;

public class CellClickListener implements MouseListener {
	private int	_x;
	private int	_y;
	public CellClickListener(int x, int y) {
		_x = x;
		_y = y;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int fireLevel = MapController.getInstance().getCellFireLevel(_x, _y);
		boolean containsRobot = MapController.getInstance().containsRobot(_x, _y);
		if (e.getButton() == MouseEvent.BUTTON1 && !containsRobot)
			MapController.getInstance().setOnFireAt(_x, _y, fireLevel + 1);
		else if (e.getButton() == MouseEvent.BUTTON3) {
			if (fireLevel > 0)
				MapController.getInstance().setOnFireAt(_x, _y, fireLevel - 1);
			else if (containsRobot)
				MapController.getInstance().removeRobotAt(_x, _y);
				
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
