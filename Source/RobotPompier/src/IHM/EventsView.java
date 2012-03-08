package IHM;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Observer.AMapObserver;

public class EventsView extends AMapObserver {
	private JPanel eventsPanel;
	public JPanel getEventsPanel() {
		return eventsPanel;
	}
	public void setEventsPanel(JPanel eventsPanel) {
		this.eventsPanel = eventsPanel;
	}
	EventsView() {
		eventsPanel = new JPanel();
		eventsPanel.add(new JLabel("EventsView"));
	}
}