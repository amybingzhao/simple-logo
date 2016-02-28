package GUIPackage;

import Controller.Controller;
import Model.VariableDictionary;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class GUIObjectTableView implements GUIObject {

	private static final int TABLE_COLUMN_WIDTH = 130;
	private Controller myController;
	private ResourceBundle myResources;
	private TableView<TableVariable> myTableView;
	private VariableDictionary myVariables;
	
	private ObservableList<TableVariable> data = FXCollections.observableArrayList();
	
	public GUIObjectTableView(Controller c, ResourceBundle r) {
		myController = c;
		myResources = r;
	}

	@Override
	public Node createNode() {
		myTableView = new TableView<TableVariable>();
		myTableView.setEditable(true);
		
		TableColumn variableCol = new TableColumn(myResources.getString("VariablesColumn"));
		variableCol.setMinWidth(TABLE_COLUMN_WIDTH);
		variableCol.setCellValueFactory(new PropertyValueFactory<TableVariable, String>("variableName"));
		
		TableColumn valueCol = new TableColumn(myResources.getString("ValuesColumn"));
		valueCol.setMinWidth(TABLE_COLUMN_WIDTH);
		valueCol.setCellValueFactory(new PropertyValueFactory<TableVariable, Double>("variableValue"));
		
		myTableView.setItems(data);
		
		myTableView.getColumns().addAll(variableCol, valueCol);
		return myTableView;
	}

	@Override
	public void updateNode() {
		myVariables = VariableDictionary.getInstance();
		data.clear();
		for (String s: myVariables.getKeySet()) {
			data.add(new TableVariable(s, myVariables.getNodeFor(s)));
		}
	}
}
