/**
 * 
 */
package IHM;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SimulationView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel timerPanel;
	private JLabel timer;
	public SimulationView() {
		this.setSize(50, 100);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS ));
		this.add(new JLabel("Statistiques"));
		showTimer();
	}
	
	public void showTimer()
	{
		timerPanel = new JPanel();
		this.add(timerPanel);
	}
}