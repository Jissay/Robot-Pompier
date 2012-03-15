package IHM;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;

import Controller.RobotTypeController;
import Controller.SimulationController;
import IHM.DragNDrop.CustomTransferHandler;
import IHM.listeners.OpenAddRobotTypeListener;
import IHM.listeners.OpenModifyRobotTypeListener;
import Model.robot.type.RobotType;
import Observer.ARobotTypeObserver;

public class RobotModelView extends ARobotTypeObserver{

	private JPanel panelControlButton;
	private JButton buttonAddRobotType;
	private JList listRobotType;
	private JButton buttonAddRobotTYpe;
	private JButton buttonModifyRobotType;
	private JButton buttonDeleteTypeRobot;
	private JScrollPane scrollPaneList;
	private JPanel robotModelPanel;
	
	public JPanel getRobotModelPanel() {
		return robotModelPanel;
	}

	public void setRobotModelPanel(JPanel robotModelPanel) {
		this.robotModelPanel = robotModelPanel;
	}

	public JList getListRobotType() {
		return this.listRobotType;
	}
	
	public RobotModelView()
	{
		robotModelPanel = new JPanel();
		// panel used to create, modify or delete a robot type
		this.panelControlButton = new JPanel();
		
		// button used to add a new robot type
		this.buttonAddRobotType = new JButton("Ajouter");
		this.buttonAddRobotType.addActionListener(new OpenAddRobotTypeListener(new RobotTypeController()));
		
		// button used to modify a robot type
		this.buttonModifyRobotType = new JButton("Modifier");
		this.buttonModifyRobotType.addActionListener(new OpenModifyRobotTypeListener(new RobotTypeController(), this));
		
		// button used to delete a robot type
		this.buttonDeleteTypeRobot = new JButton("Supprimer");
		
		// add all buttons to panelControlButton
		this.panelControlButton.add(this.buttonAddRobotType);
		this.panelControlButton.add(this.buttonModifyRobotType);
		this.panelControlButton.add(this.buttonDeleteTypeRobot);
		
		// list used to show all the robot types : we use an array
		Set<RobotType> robotTypes = SimulationController.getInstance().getSimulation().getRobotModel();
		
		String[]listRobot = new String[robotTypes.size()];
		int i = 0;
		for (RobotType rt : robotTypes) {
			listRobot[i] = rt.getName();
			i++;
		}
		
		this.listRobotType = new JList(listRobot);
		this.listRobotType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listRobotType.setLayoutOrientation(JList.VERTICAL);

		this.scrollPaneList = new JScrollPane(this.listRobotType);
		robotModelPanel.setLayout(new BoxLayout(getRobotModelPanel(), BoxLayout.Y_AXIS));
		robotModelPanel.add(this.panelControlButton);
		robotModelPanel.add(this.scrollPaneList);
		
		// Drag n' drop
		final CustomTransferHandler cth = new CustomTransferHandler("text");
		//setTransferHandler(cth);
		MouseListener mouseListener = new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				JComponent jc = (JComponent)event.getSource();
				cth.exportAsDrag(jc, event, TransferHandler.COPY);
			}
		};
		listRobotType.addMouseListener(mouseListener);
		listRobotType.setDragEnabled(true);
	}
}