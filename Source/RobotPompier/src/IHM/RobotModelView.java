/**
 * 
 */
package IHM;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class RobotModelView extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanel panelControlButton;
	private JList listRobotType;
	private JButton buttonAddRobotTYpe;
	private JButton buttonModifyRobotType;
	private JButton buttonDeleteTypeRobot;
	
	public RobotModelView()
	{
		
		this.panelControlButton = new JPanel();
		
		// button used to add a new robot type
		this.buttonAddRobotTYpe = new JButton("Ajouter");
		// button used to modify a robot type
		this.buttonModifyRobotType = new JButton("Modifier");
		// button used to delete a robot type
		this.buttonDeleteTypeRobot = new JButton("Supprimer");
		
		// add all buttons
		this.panelControlButton.add(this.buttonAddRobotTYpe);
		this.panelControlButton.add(this.buttonModifyRobotType);
		this.panelControlButton.add(this.buttonDeleteTypeRobot);
		
		
		// list used to show all the robot types
		this.listRobotType = new JList();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(this.panelControlButton);
		this.add(this.listRobotType);
		
	}
}