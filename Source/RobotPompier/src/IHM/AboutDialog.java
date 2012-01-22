/**
 * 
 */
package IHM;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Marc
 * @generated "UML vers Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class AboutDialog extends JOptionPane{
	private static final long serialVersionUID = 1L;
	JLabel aboutInformations;
	ImageIcon logoFDS;
	public AboutDialog()
	{
		this.logoFDS = new ImageIcon("images/fds2_Logo.png");
		this.showMessageDialog(null,"<html><font size=\"11\"><b>Fire Disaster Simulator</b></font></html>","information",JOptionPane.INFORMATION_MESSAGE,this.logoFDS);
	}
}