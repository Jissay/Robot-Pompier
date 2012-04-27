package IHM.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import IHM.RobotDetailDialog;

public class AddRobotTypeListener implements ActionListener {

	/* ATTRIBUTES */
	
	private RobotDetailDialog _robotDetailsDialog;
	
	/* CONSTRUCTORS */
	
	public AddRobotTypeListener (RobotDetailDialog robotDetail) {
		super();
		_robotDetailsDialog = robotDetail;
	}
	
	/* PUBLIC METHODS */
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String typeName = _robotDetailsDialog.getTypeName().getText();
		float waterCapacity = _robotDetailsDialog.getWaterCapacity().getValue();
		String algorithm = _robotDetailsDialog.getAlgorithm().getSelectedItem().toString();
		String projectorType = _robotDetailsDialog.getProjectorType().getSelectedItem().toString();
		String moveType = _robotDetailsDialog.getMoveType().getSelectedItem().toString();
		
		_robotDetailsDialog.getRobotTypeController().addRobotType(typeName, waterCapacity, algorithm, projectorType, moveType);
		_robotDetailsDialog.setVisible(false);
		_robotDetailsDialog.getRobotModelView().refreshListOfRobotTypes();
	}

}
