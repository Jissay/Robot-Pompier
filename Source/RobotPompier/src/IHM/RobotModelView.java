/**
 * 
 */
package IHM;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RobotModelView extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanel panelControlButton;
	private JList listRobotType;
	private JButton buttonAddRobotTYpe;
	private JButton buttonModifyRobotType;
	private JButton buttonDeleteTypeRobot;
	
	public RobotModelView()
	{
		// panel used to create, modify or delete a robot type
		this.panelControlButton = new JPanel();
		
		// button used to add a new robot type
		this.buttonAddRobotTYpe = new JButton("Ajouter");
		// button used to modify a robot type
		this.buttonModifyRobotType = new JButton("Modifier");
		// button used to delete a robot type
		this.buttonDeleteTypeRobot = new JButton("Supprimer");
		
		// add all buttons to panelControlButton
		this.panelControlButton.add(this.buttonAddRobotTYpe);
		this.panelControlButton.add(this.buttonModifyRobotType);
		this.panelControlButton.add(this.buttonDeleteTypeRobot);
		
		
		// list used to show all the robot types : we use an array
		String[]listRobot = {"Robot 1 Test", "Robot 2 Test", "Robot 3 Test", "Robot 4 Test", "Robot 5 Test", "Robot 6 Test"};
		this.listRobotType = new JList(listRobot);
		JScrollPane scrollPane = new JScrollPane(this.listRobotType);
		this.listRobotType.setVisibleRowCount(3);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(this.panelControlButton);
		this.add(this.listRobotType);
		
	}
}