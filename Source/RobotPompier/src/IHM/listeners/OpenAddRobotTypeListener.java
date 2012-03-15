package IHM.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.RobotTypeController;
import IHM.RobotDetailDialog;

public class OpenAddRobotTypeListener implements ActionListener {

	/* ATTRIBUTES */
	
	private RobotTypeController _robotTypeController;

	/* CONSTRUCTORS */
	
	public OpenAddRobotTypeListener(RobotTypeController robotTypeController) {
		super();
		_robotTypeController = robotTypeController;
	}
	
	/* PUBLICS METHODS */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		RobotDetailDialog robotDetailDialogFrame = new RobotDetailDialog(RobotDetailDialog.ADD_ROBOT_TYPE_DIALOG, null, _robotTypeController);
		robotDetailDialogFrame.setVisible(true);
	}
}
