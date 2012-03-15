package IHM;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Observer.AMapObserver;

public class EventsView extends AMapObserver {
	private JPanel eventsPanel;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	public JPanel getEventsPanel() {
		return eventsPanel;
	}
	public void setEventsPanel(JPanel eventsPanel) {
		this.eventsPanel = eventsPanel;
	}
	
	EventsView() {
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int widthTextArea = dim.width;
		
		textArea = new JTextArea();
		textArea.setRows(5);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(widthTextArea,100));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		eventsPanel = new JPanel();
		eventsPanel.add(scrollPane);
	}
	
	@Override
	protected void mapLoading() {
		textArea.append("Chargement de la map en cours ...\n");
	}
	
	@Override
	protected void mapLoadingFailed() {
		textArea.append("Error : le chargement de la map a échoué\n");
	}
	
	@Override
	protected void mapLoaded() {
		textArea.append("Chargement de la map effectué\n");
	}
	@Override
	protected void mapSetRobot() {
		textArea.append("Ajout d'un nouveau robot à la map\n");
	}
	@Override
	protected void mapSetFire() {
		textArea.append("Ajout d'un nouveau feu à la map\n");
	}
}