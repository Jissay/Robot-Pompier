package IHM;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;

import IHM.DragNDrop.CustomTransferHandler;

import IHM.listeners.OpenAddRobotTypeListener;

public class RobotModelView extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanel panelControlButton;
	private JList listRobotType;
	private JButton buttonAddRobotType;
	private JButton buttonModifyRobotType;
	private JButton buttonDeleteTypeRobot;
	private JScrollPane scrollPaneList;
	
	public RobotModelView()
	{
		// panel used to create, modify or delete a robot type
		this.panelControlButton = new JPanel();
		
		// button used to add a new robot type
		this.buttonAddRobotType = new JButton("Ajouter");
		this.buttonAddRobotType.addActionListener(new OpenAddRobotTypeListener());
		
		// button used to modify a robot type
		this.buttonModifyRobotType = new JButton("Modifier");
		// button used to delete a robot type
		this.buttonDeleteTypeRobot = new JButton("Supprimer");
		
		// add all buttons to panelControlButton
		this.panelControlButton.add(this.buttonAddRobotType);
		this.panelControlButton.add(this.buttonModifyRobotType);
		this.panelControlButton.add(this.buttonDeleteTypeRobot);
		
		
		// list used to show all the robot types : we use an array
		String[]listRobot = {"Robot Model Test", "Robot Model 2 Test", "Robot Model 3 Test", "Robot Model 4 Test",
				"Robot Model 5 Test", "Robot Model 6 Test", "Robot Model 7 Test", "Robot Model 8 Test", "Robot Model 9 Test", 
				"Robot Model 10 Test", "Robot Model 11 Test", "Robot Model 12 Test", "Robot Model 13 Test", "Robot Model 14 Test", 
				"Robot Model 15 Test", "Robot Model 16 Test", "Robot Model 17 Test", "Robot Model 18 Test", "Robot Model 19 Test", 
				"Robot Model 20 Test", "Robot Model 21 Test", "Robot Model 22 Test", "Robot Model 23 Test", "Robot Model 24 Test"};
		this.listRobotType = new JList(listRobot);
		this.listRobotType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listRobotType.setLayoutOrientation(JList.VERTICAL);

		this.scrollPaneList = new JScrollPane(this.listRobotType);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(this.panelControlButton);
		this.add(this.scrollPaneList);
		
		// Drag n' drop
		final CustomTransferHandler cth = new CustomTransferHandler("text");
		setTransferHandler(cth);
		MouseListener mouseListener = new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				JComponent jc = (JComponent)event.getSource();
				cth.exportAsDrag(jc, event, TransferHandler.COPY);
			}
		};
		listRobotType.addMouseListener(mouseListener);
	}
}