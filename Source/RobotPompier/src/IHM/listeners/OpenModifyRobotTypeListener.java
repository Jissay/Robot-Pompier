package IHM.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.RobotTypeController;
import Controller.SimulationController;
import IHM.RobotDetailDialog;
import IHM.RobotModelView;
import Model.robot.type.RobotType;

public class OpenModifyRobotTypeListener implements ActionListener {

	/* ATTRIBUTES */
	
	private RobotTypeController _robotTypeController;
	private RobotType _robotTypeSelected;
	private RobotModelView _robotModelView;
	
	/* CONSTRUCTORS */
	
	public OpenModifyRobotTypeListener(RobotTypeController robotTypeController, RobotModelView robotModelView) {
		super();
		_robotTypeController = robotTypeController;
		_robotModelView = robotModelView;
	}
	
	/* PUBLICS METHODS */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!_robotModelView.getListRobotType().getSelectedValue().equals(null)) {
			String robotTypeName = _robotModelView.getListRobotType().getSelectedValue().toString();
			_robotTypeSelected = SimulationController.getInstance().getRobotTypeFromName(robotTypeName);
			RobotDetailDialog robotDetailDialogFrame = new RobotDetailDialog(RobotDetailDialog.MODIFY_ROBOT_TYPE_DIALOG, _robotTypeSelected, _robotTypeController, _robotModelView);
			robotDetailDialogFrame.setVisible(true);
		}
	}
}
