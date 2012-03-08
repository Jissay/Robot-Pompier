package IHM.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import IHM.RobotDetailDialog;
import IHM.RobotModelView;

public class OpenAddRobotTypeListener implements ActionListener {

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		RobotDetailDialog robotDetailDialogFrame = new RobotDetailDialog(RobotDetailDialog.ADD_ROBOT_TYPE_DIALOG, null);
		robotDetailDialogFrame.setVisible(true);
	}
}
