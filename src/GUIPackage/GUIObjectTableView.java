package GUIPackage;

import Model.CommandDictionary;
import Model.VariableDictionary;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/**
 * Creates TableView to display variables and allow editing of variables.
 *
 * @author David
 */
public class GUIObjectTableView implements IGUIObject {

    private static final int TABLE_COLUMN_WIDTH = 130;
    private ResourceBundle myResources;
    private TableView<TableVariable> myTableView;
    private TableColumn<TableVariable, String> myVariableColumn;
    private TableColumn<TableVariable, Double> myValueColumn;
    private CommandDictionary commandDict;
    private VariableDictionary varDict;
	private static final double PADDING_TOP = 0;
	private static final double PADDING_RIGHT = 0;
	private static final double PADDING_BOTTOM = 0;
	private static final double PADDING_LEFT = 10;

    private ObservableList<TableVariable> data = FXCollections.observableArrayList();

    public GUIObjectTableView(ResourceBundle r, CommandDictionary myComDict, VariableDictionary myVarDict) {
        myResources = r;
        commandDict = myComDict;
        varDict = myVarDict;
    }

    /**
     * Creates TableVariable node and populates it with cells that are editable.
     */
    @Override
    public Node createNode() {
        myTableView = new TableView<TableVariable>();
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
    
    public void createVariableColumn() {
        myVariableColumn =
                new TableColumn<TableVariable, String>(myResources.getString("VariablesColumn"));
        myVariableColumn.setMinWidth(TABLE_COLUMN_WIDTH);
        myVariableColumn.setCellValueFactory(new PropertyValueFactory<TableVariable, String>("variableName"));
    }
    
    
    public void createValueColumn() {
        Callback<TableColumn<TableVariable, Double>, TableCell<TableVariable, Double>> cellFactory =
                new Callback<TableColumn<TableVariable, Double>, TableCell<TableVariable, Double>>() {
                    public TableCell<TableVariable, Double> call(TableColumn<TableVariable, Double> p) {
                        return new EditingCell();
                    }
                };
        myValueColumn =
                new TableColumn<TableVariable, Double>(myResources.getString("ValuesColumn"));
        myValueColumn.setMinWidth(TABLE_COLUMN_WIDTH);
        myValueColumn.setCellValueFactory(new PropertyValueFactory<TableVariable, Double>("variableValue"));
        myValueColumn.setCellFactory(cellFactory);
        myValueColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<TableVariable, Double>>() {
                    @Override
                    public void handle(CellEditEvent<TableVariable, Double> t) {
                        ((TableVariable) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                                .setVariableValue(t.getNewValue());
                        varDict.makeVariable(t.getTableView().getItems().get(t.getTablePosition().getRow())
                                .getVariableName(), t.getNewValue());
                    }
                }
        );
    }
    /**
     * Updates node when new data is available.
     */
    @Override
    public void updateNode() {
        data.clear();
        for (String s : varDict.getKeySet()) {
            data.add(new TableVariable(s, varDict.getNodeFor(s)));
        }
    }
}
