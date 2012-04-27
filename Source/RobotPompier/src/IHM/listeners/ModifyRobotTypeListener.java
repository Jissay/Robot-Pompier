package IHM.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import IHM.RobotDetailDialog;

public class ModifyRobotTypeListener implements ActionListener {

/* ATTRIBUTES */
	
	private RobotDetailDialog _robotDetailsDialog;
	private String _initialRobotTypeName;
	
	/* CONSTRUCTORS */
	
	public ModifyRobotTypeListener (String initialName, RobotDetailDialog robotDetail) {
		super();
		_robotDetailsDialog = robotDetail;
		_initialRobotTypeName = initialName;
	}
	
	/* PUBLIC METHODS */
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String typeName = _robotDetailsDialog.getTypeName().getText();
		float waterCapacity = _robotDetailsDialog.getWaterCapacity().getValue();
		String algorithm = _robotDetailsDialog.getAlgorithm().getSelectedItem().toString();
		String projectorType = _robotDetailsDialog.getProjectorType().getSelectedItem().toString();
		String moveType = _robotDetailsDialog.getMoveType().getSelectedItem().toString();
		
		_robotDetailsDialog.get_robotTypeController().modifyRobotType(_initialRobotTypeName, typeName, waterCapacity, algorithm, projectorType, moveType);
						
	}
}
