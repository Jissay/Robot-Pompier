package IHM.DragNDrop;

import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.io.IOException;

import javax.swing.JLabel;

import Controller.MapController;

@SuppressWarnings("serial")
public class CellDropTarget extends DropTarget {
	private int _x;
	private int _y;
	private Color _previousForegroundColor;
	
	public CellDropTarget(Component component) {
		super();
		setComponent(component);
	}
	
	public CellDropTarget(int x, int y) {
		super();
		_x = x;
		_y = y;
	}

	@Override
	public void dragEnter(DropTargetDragEvent event) {
		Component component = getComponent();
		if (component instanceof JLabel) {
			JLabel cell = (JLabel)component;
			_previousForegroundColor = cell.getForeground();
			
			if (MapController.getInstance().isCellBusy(_x, _y))
				cell.setForeground(Color.red);
			else
				cell.setForeground(Color.green);
		}
		System.out.println("Drag enter !");
	}
	
	@Override
	public void dragExit(DropTargetEvent event) {
		Component component = getComponent();
		if (component instanceof JLabel)
			((JLabel)component).setForeground(_previousForegroundColor);
		System.out.println("Drag exit !");
	}
	
	@Override
	public void drop(DropTargetDropEvent event) {
		Transferable transferable = event.getTransferable();
		try {
			Object data = transferable.getTransferData(DataFlavor.stringFlavor);
			if (data instanceof String) {
				Component component = getComponent();
				if (component instanceof JLabel) {
					System.out.println("Dropped " + (String)data);
					MapController.getInstance().setRobotAt(_x, _y, (String)data);
				} else
					System.out.println("Get data but something else went wrong ?");
			} else
				System.out.println("data is not a string ...");
				
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
