package IHM;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AboutDialog extends JOptionPane{
	private static final long serialVersionUID = 1L;
	JLabel aboutInformations;
	ImageIcon logoFDS;
	public AboutDialog()
	{
		this.logoFDS = new ImageIcon("images/fds2_Logo.png");
		AboutDialog.showMessageDialog(null,"<html><font size=\"6\">" +
				"<p>Fire Disaster Simulator</p></font>" +
				"<font size=\"4\"><p><ul><li>Nicolas Buffon</li>" +
				"<li>Marc Plano-Lesay</li>" +
				"<li>Jean-Christophe Ricard</li>" +
				"<li>Adrien Vetillart</li></ul></p></font>" +
				"</html>","information",JOptionPane.INFORMATION_MESSAGE,this.logoFDS);
	}
}