package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.robot.type.RobotType;

public class RobotDetailDialog extends JFrame {

	/* STATIC VALUES */
	
	private static final long serialVersionUID = 2823881730967892937L;

	public static int ADD_ROBOT_TYPE_DIALOG = 0;
	public static int MODIFY_ROBOT_TYPE_DIALOG = 1;
	public static int SHOW_ROBOT_TYPE_DIALOG = 2;
	
	/* ATTRIBUTES */
	
	private int _type;
	
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
	private JTextField _waterCapacity;
	
	private JComboBox _algorithm;
	private JComboBox _projectorType;
	private JComboBox _moveType;
	
	// South panel
	private JButton _addRobotType_button;
	private JButton _cancelAddRobotType_button;
	
	
	/* CONSTRUCTORS */
	public RobotDetailDialog(int type, RobotType rt) {
		super();
		_type = type;
		
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
		_waterCapacity = new JTextField();
		
		// Combo boxes
		String[] algorithms = {"A-star", "Pathfinder", "Test"};
		_algorithm = new JComboBox(algorithms);
		
		String[] projectorTypes = {"Lance à eau", "Arrosoir", "Extincteur", "Arrosage à pompe"};
		_projectorType = new JComboBox(projectorTypes);
		
		String[] moveTypes = {"Chenilles", "Ventouses"};
		_moveType = new JComboBox(moveTypes);
				
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
		
		_addRobotType_button = new JButton("Ajouter");
		_cancelAddRobotType_button = new JButton("Annuler");
		
		_southPanel.add(_cancelAddRobotType_button);
		_southPanel.add(_addRobotType_button);
		
		this.setLayout(new BorderLayout());
		this.add(_northPanel, BorderLayout.NORTH);
		this.add(_centralPanel, BorderLayout.CENTER);
		this.add(_southPanel, BorderLayout.SOUTH);
	}


	public int get_type() {
		return _type;
	}


	public void set_type(int _type) {
		this._type = _type;
	}
}