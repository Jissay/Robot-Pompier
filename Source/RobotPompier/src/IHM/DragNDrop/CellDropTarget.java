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

import Controller.MapController;
import IHM.CellView;

@SuppressWarnings("serial")
public class CellDropTarget extends DropTarget {
	private Color _previousForegroundColor;
	
	public CellDropTarget(Component component) {
		super();
		setComponent(component);
	}
	
	public CellDropTarget() {
		super();
	}

	@Override
	public void dragEnter(DropTargetDragEvent event) {
		Component component = getComponent();
		if (component instanceof CellView) {
			CellView cell = (CellView)component;
			_previousForegroundColor = cell.getForeground();
			
			if (MapController.getInstance().isCellBusy(cell.getX(), cell.getY()))
				cell.setForeground(Color.red);
			else
				cell.setForeground(Color.green);
		}
		System.out.println("Drag enter !");
	}
	
	@Override
	public void dragExit(DropTargetEvent event) {
		Component component = getComponent();
		if (component instanceof CellView) {
			((CellView)component).setForeground(_previousForegroundColor);
		}
		System.out.println("Drag exit !");
	}
	
	@Override
	public void drop(DropTargetDropEvent event) {
		Transferable transferable = event.getTransferable();
		try {
			Object data = transferable.getTransferData(DataFlavor.stringFlavor);
			if (data instanceof String) {
				Component component = getComponent();
				if (component instanceof CellView) {
					// Avertir le modèle
				} else
					System.out.println("Get data but something else went wrong ?");
			} else
				System.out.println("data is not a string ...");
				
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Drop da bass !");
	}
}
