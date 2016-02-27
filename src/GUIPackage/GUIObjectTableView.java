package GUIPackage;

import Controller.Controller;

import java.util.Map.Entry;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GUIObjectTableView implements GUIObject {

	private Controller myController;
	private ResourceBundle myResources;
	private TableView myTableView;
	
	public GUIObjectTableView(Controller c, ResourceBundle r) {
		myController = c;
		myResources = r;
	}

	@Override
	public Node createNode() {
		myTableView = new TableView();
		myTableView.setEditable(true);
		
		TableColumn variableCol = new TableColumn(myResources.getString("VariablesColumn"));
		variableCol.setMinWidth(100);
		TableColumn valueCol = new TableColumn(myResources.getString("ValuesColumn"));
		valueCol.setMinWidth(100);
		
		myTableView.getColumns().setAll(variableCol, valueCol);
		return myTableView;
	}

	@Override
	public void updateNode() {
		// TODO Auto-generated method stub
		
	}
}
