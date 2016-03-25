// This entire file ispart of my masterpiece
// David Yang

/**
 * I chose to include this class in my masterpiece because it is one of the GUI elements
 * that implements the IGUIObject interface. It shows the IGUIObject interface in action
 * and how easy it is to add a new element to the GUI. This class also demonstrates the
 * use of lambda functions as well as following all the normal coding conventions such as
 * short methods, constants, and private instance variables.
 */
package guipackage;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import model.VariableDictionary;

/**
 * Creates TableView to display variables and allow editing of variables.
 *
 * @author David
 */
public class GUITableView implements IGUIObject {

	private ResourceBundle myResources;
    private TableView<GUITableViewVariable> myTableView;
    private TableColumn<GUITableViewVariable, String> myVariableColumn;
    private TableColumn<GUITableViewVariable, Double> myValueColumn;
    private VariableDictionary varDict;
    private ObservableList<GUITableViewVariable> data;
    private static final String VARIABLE_VALUE = "variableValue";
	private static final String VARIABLE_NAME = "variableName";
    private static final int TABLE_COLUMN_WIDTH = 130;
	private static final double PADDING_TOP = 0;
	private static final double PADDING_RIGHT = 0;
	private static final double PADDING_BOTTOM = 0;
	private static final double PADDING_LEFT = 10;

    public GUITableView(ResourceBundle r, VariableDictionary myVarDict) {
        myResources = r;
        varDict = myVarDict;
        data = FXCollections.observableArrayList();
    }

    /**
     * Creates TableVariable node and populates it with cells that are editable.
     */
    @SuppressWarnings("unchecked")
	@Override
    public Node createNode() {
        myTableView = new TableView<>();
        myTableView.setEditable(true);
        
        createVariableColumn();
        createValueColumn();

        myTableView.setItems(data);

        myTableView.getColumns().addAll(myVariableColumn, myValueColumn);
        
        HBox tableView = new HBox();
		tableView.getChildren().addAll(myTableView);
		tableView.setPadding(new Insets(PADDING_TOP, PADDING_RIGHT, PADDING_BOTTOM, PADDING_LEFT));
        return tableView;
    }
    /**
     * Create column to hold variable names.
     */
    private void createVariableColumn() {
        myVariableColumn =
                new TableColumn<>(myResources.getString("VariablesColumn"));
        myVariableColumn.setMinWidth(TABLE_COLUMN_WIDTH);
        myVariableColumn.setCellValueFactory(
        		new PropertyValueFactory<GUITableViewVariable, String>(VARIABLE_NAME));
    }
    
    /**
     * Create column to hold variable values. 
     */
    private void createValueColumn() {
        Callback<TableColumn<GUITableViewVariable, Double>, 
        TableCell<GUITableViewVariable, Double>> cellFactory =
                (event -> {
                	return new GUITableViewEditingCell();
                });
        myValueColumn =
                new TableColumn<>(myResources.getString("ValuesColumn"));
        myValueColumn.setMinWidth(TABLE_COLUMN_WIDTH);
        myValueColumn.setCellValueFactory(
        		new PropertyValueFactory<GUITableViewVariable, Double>(VARIABLE_VALUE));
        myValueColumn.setCellFactory(cellFactory);
        myValueColumn.setOnEditCommit(event -> {
        	event.getTableView().getItems().get(
        			event.getTablePosition().getRow()).setVariableValue(event.getNewValue());
        	varDict.makeVariable(event.getTableView().getItems().get(
        			event.getTablePosition().getRow()).getVariableName(), event.getNewValue());
        });
    }
    
    /**
     * Updates node when new data is available.
     */
    @Override
    public void updateNode() {
        data.clear();
        for (String s: varDict.getKeySet()) {
            data.add(new GUITableViewVariable(s, varDict.getNodeFor(s)));
        }
    }
}
