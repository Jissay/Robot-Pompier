package IHM.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.RobotTypeController;
import IHM.RobotDetailDialog;
import IHM.RobotModelView;

public class OpenAddRobotTypeListener implements ActionListener {

	/* ATTRIBUTES */
	
	private RobotTypeController _robotTypeController;
	private RobotModelView _robotModelView;

	/* CONSTRUCTORS */
	
	public OpenAddRobotTypeListener(RobotTypeController robotTypeController, RobotModelView robotModelView) {
		super();
		_robotTypeController = robotTypeController;
		_robotModelView = robotModelView;
	}
	
	/* PUBLICS METHODS */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		RobotDetailDialog robotDetailDialogFrame = new RobotDetailDialog(RobotDetailDialog.ADD_ROBOT_TYPE_DIALOG, null, _robotTypeController, _robotModelView);
		robotDetailDialogFrame.setVisible(true);
	}
}
