package Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerLabel extends JLabel
{
private static final long serialVersionUID = 1L;
	Timer timer;
	int valueTimer;
 
	public TimerLabel (int value) 
	{
	    super (String.valueOf(value));
	    this.valueTimer=0;
	    timer = createTimer ();
	}
  
	private Timer createTimer ()
	{
		ActionListener action = new ActionListener ()
		{
			public void actionPerformed (ActionEvent event)
			{
				valueTimer += 1000;
				setText(String.valueOf(valueTimer/1000)+"s");
			}
		};
		return new Timer (1000, action);
	}
  
	public void startTimerLabel()
	{
		timer.start();
	}
	
	public void stopTimerLabel()
	{
		timer.stop();
	}
}