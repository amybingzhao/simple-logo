package GUIPackage;

import Model.CommandDictionary;
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

/**
 * Creates TableView to display variables and allow editing of variables.
 *
 * @author David
 */
public class GUIObjectTableView implements IGUIObject {

    private static final int TABLE_COLUMN_WIDTH = 130;
    private ResourceBundle myResources;
    private TableView<TableVariable> myTableView;
    private VariableDictionary myVariables;
    private CommandDictionary commandDict;
    private VariableDictionary varDict;

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
        Callback<TableColumn<TableVariable, Double>, TableCell<TableVariable, Double>> cellFactory =
                new Callback<TableColumn<TableVariable, Double>, TableCell<TableVariable, Double>>() {
                    public TableCell<TableVariable, Double> call(TableColumn<TableVariable, Double> p) {
                        return new EditingCell();
                    }
                };

        TableColumn<TableVariable, String> variableCol =
                new TableColumn<TableVariable, String>(myResources.getString("VariablesColumn"));
        variableCol.setMinWidth(TABLE_COLUMN_WIDTH);
        variableCol.setCellValueFactory(new PropertyValueFactory<TableVariable, String>("variableName"));

        TableColumn<TableVariable, Double> valueCol =
                new TableColumn<TableVariable, Double>(myResources.getString("ValuesColumn"));
        valueCol.setMinWidth(TABLE_COLUMN_WIDTH);
        valueCol.setCellValueFactory(new PropertyValueFactory<TableVariable, Double>("variableValue"));
        valueCol.setCellFactory(cellFactory);
        valueCol.setOnEditCommit(
                new EventHandler<CellEditEvent<TableVariable, Double>>() {
                    @Override
                    public void handle(CellEditEvent<TableVariable, Double> t) {
                        ((TableVariable) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                                .setVariableValue(t.getNewValue());
                        myVariables.makeVariable(t.getTableView().getItems().get(t.getTablePosition().getRow())
                                .getVariableName(), t.getNewValue());
                    }
                }
        );

        myTableView.setItems(data);

        myTableView.getColumns().addAll(variableCol, valueCol);
        return myTableView;
    }

    /**
     * Updates node when new data is available.
     */
    @Override
    public void updateNode() {
        for (String s : varDict.getKeySet()) {
            data.add(new TableVariable(s, varDict.getNodeFor(s)));
        }
    }
}
