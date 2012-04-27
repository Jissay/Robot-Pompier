package IHM.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.RobotTypeController;
import IHM.RobotModelView;

public class DeleteRobotTypeListener implements ActionListener {

	/* ATTRIBUTES */

	private RobotTypeController _robotTypeController;
	private RobotModelView _robotModelView;
	
	/* CONSTRUCTORS */
	
	public DeleteRobotTypeListener(RobotModelView robotModelView, RobotTypeController robotTypeController) {
		super();
		_robotModelView = robotModelView;
		_robotTypeController = robotTypeController;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!_robotModelView.getListRobotType().getSelectedValue().equals(null)) {
			_robotTypeController.deleteRobotType(_robotModelView.getListRobotType().getSelectedValue().toString());
			_robotModelView.refreshListOfRobotTypes();
		}
	}

}
