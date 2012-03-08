package IHM.DragNDrop;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.TransferHandler;

import IHM.RobotModelView;

@SuppressWarnings("serial")
public class CustomTransferHandler extends TransferHandler {
private CustomTransferable _data = new CustomTransferable("Nothing");
	
	public CustomTransferHandler() {
		super();
	}
	
	public CustomTransferHandler(String property) {
		super(property);
	}
	
	@Override
	public void exportAsDrag(JComponent component, InputEvent inputEvent, int action) {
		super.exportAsDrag(component, inputEvent, action);
		if (component instanceof JList)
			_data.setValue((String) ((JList)component).getSelectedValue());
		else
			_data.setValue("I dragged someting ...");
		
		System.out.println(_data);
	}
	
	@Override
	protected Transferable createTransferable(JComponent component) {
		return _data;
	}
	
	protected class CustomTransferable implements Transferable {
		public String _value;
		
		public CustomTransferable(String data) {
			_value = data;
		}
		
		public void setValue(String value) {
			_value = value;
		}
		
		@Override
		public Object getTransferData(DataFlavor arg0)
				throws UnsupportedFlavorException, IOException {
			return _value;
		}

		@Override
		public DataFlavor[] getTransferDataFlavors() {
			return new DataFlavor[] {DataFlavor.stringFlavor};
		}

		@Override
		public boolean isDataFlavorSupported(DataFlavor flavor) {
			if (flavor.match(DataFlavor.stringFlavor))
				return true;
			return false;
		}
		
		@Override
		public String toString() {
			return _value;
		}
	}
}
