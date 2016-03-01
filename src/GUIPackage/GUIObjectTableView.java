package GUIPackage;

import Controller.Controller;
import Model.VariableDictionary;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class GUIObjectTableView implements IGUIObject {

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
		Callback<TableColumn, TableCell> cellFactory =
	             new Callback<TableColumn, TableCell>() {
	                 public TableCell call(TableColumn p) {
	                    return new EditingCell();
	                 }
	             };
		
		TableColumn variableCol = new TableColumn(myResources.getString("VariablesColumn"));
		variableCol.setMinWidth(TABLE_COLUMN_WIDTH);
		variableCol.setCellValueFactory(new PropertyValueFactory<TableVariable, String>("variableName"));
		
		TableColumn valueCol = new TableColumn(myResources.getString("ValuesColumn"));
		valueCol.setMinWidth(TABLE_COLUMN_WIDTH);
		valueCol.setCellValueFactory(new PropertyValueFactory<TableVariable, Double>("variableValue"));
		valueCol.setCellFactory(cellFactory);
		valueCol.setOnEditCommit(
				new EventHandler<CellEditEvent<TableVariable, Double>>() {
	                @Override
	                public void handle(CellEditEvent<TableVariable, Double> t) {
	                    ((TableVariable) t.getTableView().getItems().get(t.getTablePosition().getRow()))
	                    .setVariableValue(t.getNewValue());
	                }
	            }
		);
		
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
