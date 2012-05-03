package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import Controller.RobotTypeController;
import Controller.SimulationController;
import IHM.listeners.AddRobotTypeListener;
import IHM.listeners.CancelAddRobotTypeListener;
import IHM.listeners.ModifyRobotTypeListener;
import Model.algorithms.Algorithm;
import Model.robot.type.MoveType;
import Model.robot.type.ProjectorType;
import Model.robot.type.RobotType;

public class RobotDetailDialog extends JFrame {

	/* STATIC VALUES */
	
	private static final long serialVersionUID = 2823881730967892937L;

	public static int ADD_ROBOT_TYPE_DIALOG = 0;
	public static int MODIFY_ROBOT_TYPE_DIALOG = 1;
	public static int SHOW_ROBOT_TYPE_DIALOG = 2;
	
	/* ATTRIBUTES */
	
	private int _type;
	private RobotTypeController _robotTypeController;
	private RobotModelView _robotModelView;
	
	/* IHM COMPONENTS */
	private JPanel _northPanel; // Panel with title
	private JPanel _centralPanel; // Panel with informations
	private JPanel _southPanel; // Panel with buttons
	
	// North panel
	private JLabel _title;
	
	// Central panel
	private JLabel _typeName_label;
	private JLabel _waterCapacity_label;
	private JLabel _algorithm_label;
	private JLabel _projectorType_label;
	private JLabel _moveType_label;
	
	private JTextField _typeName;
	
	private JSlider _waterCapacity;
	
	private JComboBox _algorithm;
	private JComboBox _projectorType;
	private JComboBox _moveType;
	
	// South panel
	private JButton _addRobotType_button;
	private JButton _cancelAddRobotType_button;
	
	
	/* CONSTRUCTORS */
	public RobotDetailDialog(int type, RobotType robotType, RobotTypeController robotTypeController, RobotModelView robotModelView) {
		super();
		_type = type;
		_robotTypeController = robotTypeController;
		setRobotModelView(robotModelView);
		
		// Construct north panel, with title
		_northPanel = new JPanel();
		
		if (type == ADD_ROBOT_TYPE_DIALOG) {
			_title = new JLabel("Ajouter un Type de Robot");
		} else if (type == MODIFY_ROBOT_TYPE_DIALOG) {
			_title = new JLabel("Modifier un Type de Robot");
		} else if (type == SHOW_ROBOT_TYPE_DIALOG) {
			_title = new JLabel("Voir un Type de Robot");
		}
		_northPanel.add(_title);
		
		// Construct central panel, with fields
		_centralPanel = new JPanel(new GridLayout(5,2));
	
		// Labels
		_typeName_label = new JLabel("Nom :");
		_waterCapacity_label = new JLabel("Capacité en eau :");
		_algorithm_label = new JLabel("Algorithme :");
		_projectorType_label = new JLabel("Type de projecteur :");
		_moveType_label = new JLabel("Type de moyen de déplacement : ");
		
		// Text fields
		_typeName = new JTextField();
		
		// Slider
		_waterCapacity = new JSlider(RobotType.MINIMUM_WATER_CAPACITY, RobotType.MAXIMUM_WATER_CAPACITY);
		_waterCapacity.setMajorTickSpacing(5);
		_waterCapacity.setMinorTickSpacing(1);
		_waterCapacity.setPaintTicks(true);
		_waterCapacity.setPaintLabels(true);
		_waterCapacity.setPaintTrack(true);
		
		// Combo boxes
		ArrayList<String> algorithms = new ArrayList<String>();
		for (Algorithm al : SimulationController.getInstance().getSimulation().getListAlgorithms()) {
			algorithms.add(al.getName());
		}
		_algorithm = new JComboBox(algorithms.toArray());
		
		ArrayList<String> projectorTypes = new ArrayList<String>();
		for (ProjectorType pj : SimulationController.getInstance().getSimulation().getListProjectorTypes()) {
			projectorTypes.add(pj.getName());
		}
		_projectorType = new JComboBox(projectorTypes.toArray());
		
		ArrayList<String> moveTypes = new ArrayList<String>();
		for (MoveType mv : SimulationController.getInstance().getSimulation().getListMoveTypes()) {
			moveTypes.add(mv.getName());
		}
		_moveType = new JComboBox(moveTypes.toArray());
		
		// If MODIFYING or SHOWING a robot type 
		if (type != ADD_ROBOT_TYPE_DIALOG) {
			_typeName.setText(robotType.getName());
			_waterCapacity.setValue(Math.round(robotType.getWaterCapacity()));
			_algorithm.setSelectedItem(robotType.getAlgorithm().getName());
			_projectorType.setSelectedItem(robotType.getProjectorType().getName());
			_moveType.setSelectedItem(robotType.getMoveType().getName());
		}
		
		// If SHOWING a robot type
		if (type == SHOW_ROBOT_TYPE_DIALOG) {
			_typeName.setEditable(false);
			_waterCapacity.setEnabled(false);
			_algorithm.setEnabled(false);
			_moveType.setEnabled(false);
			_projectorType.setEnabled(false);
		}
				
		_centralPanel.add(_typeName_label);
		_centralPanel.add(_typeName);
		_centralPanel.add(_waterCapacity_label);
		_centralPanel.add(_waterCapacity);
		_centralPanel.add(_algorithm_label);
		_centralPanel.add(_algorithm);
		_centralPanel.add(_projectorType_label);
		_centralPanel.add(_projectorType);
		_centralPanel.add(_moveType_label);
		_centralPanel.add(_moveType);
		
		// Construct south panel with add buttons
		_southPanel = new JPanel(new GridLayout(1,2));
		
		if (type == ADD_ROBOT_TYPE_DIALOG) {
			_addRobotType_button = new JButton("Ajouter");
			_addRobotType_button.addActionListener(new AddRobotTypeListener(this));
		} else if (type == MODIFY_ROBOT_TYPE_DIALOG) {
			_addRobotType_button = new JButton("Modifier");
			_addRobotType_button.addActionListener(new ModifyRobotTypeListener(robotType.getName(), this));
		}
		_cancelAddRobotType_button = new JButton("Annuler");
		_cancelAddRobotType_button.addActionListener(new CancelAddRobotTypeListener(this));
		
		_southPanel.add(_cancelAddRobotType_button);
		_southPanel.add(_addRobotType_button);
		
		this.setLayout(new BorderLayout());
		this.add(_northPanel, BorderLayout.NORTH);
		this.add(_centralPanel, BorderLayout.CENTER);
		this.add(_southPanel, BorderLayout.SOUTH);
		
		this.pack();
	}


	public int getType() {
		return _type;
	}


	public void setType(int type) {
		_type = type;
	}

	public JPanel getNorthPanel() {
		return _northPanel;
	}

	public void setNorthPanel(JPanel northPanel) {
		_northPanel = northPanel;
	}

	public JPanel getCentralPanel() {
		return _centralPanel;
	}

	public void setCentralPanel(JPanel centralPanel) {
		_centralPanel = centralPanel;
	}

	public JPanel getSouthPanel() {
		return _southPanel;
	}

	public void setSouthPanel(JPanel southPanel) {
		_southPanel = southPanel;
	}

	public JLabel getTitleLabel() {
		return _title;
	}

	public void setTitle(JLabel title) {
		_title = title;
	}

	public JLabel getTypeName_label() {
		return _typeName_label;
	}

	public void setTypeName_label(JLabel typeName_label) {
		_typeName_label = typeName_label;
	}

	public JLabel getWaterCapacity_label() {
		return _waterCapacity_label;
	}

	public void setWaterCapacity_label(JLabel waterCapacity_label) {
		_waterCapacity_label = waterCapacity_label;
	}

	public JLabel getAlgorithm_label() {
		return _algorithm_label;
	}

	public void setAlgorithm_label(JLabel algorithm_label) {
		_algorithm_label = algorithm_label;
	}

	public JLabel getProjectorType_label() {
		return _projectorType_label;
	}

	public void setProjectorType_label(JLabel projectorType_label) {
		_projectorType_label = projectorType_label;
	}

	public JLabel getMoveType_label() {
		return _moveType_label;
	}

	public void setMoveType_label(JLabel moveType_label) {
		_moveType_label = moveType_label;
	}

	public JTextField getTypeName() {
		return _typeName;
	}

	public void setTypeName(JTextField typeName) {
		_typeName = typeName;
	}

	public JSlider getWaterCapacity() {
		return _waterCapacity;
	}

	public void setWaterCapacity(JSlider waterCapacity) {
		_waterCapacity = waterCapacity;
	}

	public JComboBox getAlgorithm() {
		return _algorithm;
	}

	public void setAlgorithm(JComboBox algorithm) {
		_algorithm = algorithm;
	}

	public JComboBox getProjectorType() {
		return _projectorType;
	}

	public void setProjectorType(JComboBox projectorType) {
		_projectorType = projectorType;
	}

	public JComboBox getMoveType() {
		return _moveType;
	}

	public void setMoveType(JComboBox moveType) {
		_moveType = moveType;
	}

	public JButton getAddRobotType_button() {
		return _addRobotType_button;
	}

	public void setAddRobotType_button(JButton addRobotType_button) {
		_addRobotType_button = addRobotType_button;
	}

	public JButton getCancelAddRobotType_button() {
		return _cancelAddRobotType_button;
	}

	public void setCancelAddRobotType_button(JButton cancelAddRobotType_button) {
		_cancelAddRobotType_button = cancelAddRobotType_button;
	}

	public RobotTypeController getRobotTypeController() {
		return _robotTypeController;
	}

	public void setRobotTypeController(RobotTypeController robotTypeController) {
		_robotTypeController = robotTypeController;
	}

	public RobotModelView getRobotModelView() {
		return _robotModelView;
	}

	public void setRobotModelView(RobotModelView robotModelView) {
		_robotModelView = robotModelView;
	}
}