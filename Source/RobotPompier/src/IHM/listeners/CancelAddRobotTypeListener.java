package IHM.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import IHM.RobotDetailDialog;


public class CancelAddRobotTypeListener implements ActionListener {

	private RobotDetailDialog _robotDetailsDialog;
	
	public CancelAddRobotTypeListener (RobotDetailDialog robotDetail) {
		super();
		_robotDetailsDialog = robotDetail;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_robotDetailsDialog.setVisible(false);
	}
}
