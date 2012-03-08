import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Controller.MapController;
import IHM.MainWindow;
import Model.Cell;
import Model.Map;
import Model.Robot;
import Model.algorithms.Algorithm;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.json.JSONArray;
import org.json.JSONException;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		// Lecture de la carte
		String mapFile = "";
		
		JFileChooser fileChooser = new JFileChooser();
		int retour = fileChooser.showOpenDialog(null);
		if (retour != JFileChooser.APPROVE_OPTION) {
			System.exit(1);
		}
		
		//lecture du fichier texte	
		try {
			InputStream ips = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath()); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String line;
			while ((line = br.readLine()) != null) {
				mapFile += line+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		MapController ctrl = new MapController();
		Map map = null;
		try {
			map = new Map(new JSONArray(mapFile));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		MainWindow w = new MainWindow(map.getLargeur(), map.getLongueur());
		w.setExtendedState(w.getExtendedState() | Frame.MAXIMIZED_BOTH);
		w.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		ctrl.setModel(map);
		w.getMapView().setController(ctrl);
		ctrl.setView(w.getMapView());
		w.setVisible(true);
		
		// Test algo move forward
		Robot robot = new Robot();
		robot.setCell(new Cell(8, 5, 0));
		Cell cellToReach = new Cell(1,1, 0);
		ArrayList<Cell> test = Algorithm.findBestWay(map, robot, cellToReach);

		System.out.println(test.toString());
	}
}
