package GUIPackage;

import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Alert popups for error handling. 
 * @author AnnieTang
 *
 */
public class GUIAlert {
	private static final String ERROR_RESOURCE = "Errors";
	private ResourceBundle myErrorResources;
	
	public GUIAlert() {
		myErrorResources = ResourceBundle.getBundle(ERROR_RESOURCE);
	}
	
	public void displayAlert(String message) {
		String[] errorData = myErrorResources.getString(message).split(",");
		Alert myAlert = new Alert(AlertType.INFORMATION);
		myAlert.setTitle(errorData[0]);
		myAlert.setHeaderText(null);
		myAlert.setContentText(errorData[1]);
		myAlert.showAndWait();
	}

}
