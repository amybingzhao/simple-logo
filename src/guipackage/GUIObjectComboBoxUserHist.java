package guipackage;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.Controller;
import javafx.scene.control.TextInputDialog;
import model.Command;
import model.CommandDictionary;
import model.VariableDictionary;

/**
 * Create ComboBox to hold history of user defined commands.
 *
 * @author AnnieTang
 */

public class GUIObjectComboBoxUserHist extends GUIObjectComboBox {
    private CommandDictionary myUserDefinedCommands;
    private TextInputDialog dialog;
    private VariableDictionary varDict;

    public GUIObjectComboBoxUserHist(GUICanvas canvas, ResourceBundle myResources, Controller myController,
                                     String promptText, GUICommandLine cLine, CommandDictionary myComDict, VariableDictionary myVarDict) {
        super(canvas, myResources, myController, promptText, cLine);
        myUserDefinedCommands = myComDict;
        varDict = myVarDict;
    }

    @Override
    protected List<String> optionsList() {
        List<String> userDefinedCommands = new ArrayList<String>();
        for (String s : myUserDefinedCommands.getCommandKeySet()) {
            userDefinedCommands.add(s);
        }
        return userDefinedCommands;
    }

    @Override
    protected void setButtonAction() {
        comboButton.setOnAction(event -> {
            createDialog();
            dialog.showAndWait();
            myController.processCommand(getCommandToRun());
        });
    }

    private void createDialog() {
        Command command = myUserDefinedCommands.getCommandFor(comboBox.getValue());
        int numArgs = command.getParams().size();
        dialog = new TextInputDialog();
        dialog.setTitle(numArgs + " " + myResources.getString("ArgumentMessage") + " " + command);
        dialog.setHeaderText(myResources.getString("ArgumentsNeeded") + command.getParams());
        dialog.setContentText(myResources.getString("RequestArguments"));
    }

    private String getCommandToRun() {
        String commandToRun = comboBox.getValue();
        String[] parameters = dialog.getResult().split(" ");
        for (String parameter : parameters) {
            commandToRun = commandToRun + " " + parameter;
        }
        return commandToRun;
    }

	@Override
	protected void setCellFactory() {
	}
}
