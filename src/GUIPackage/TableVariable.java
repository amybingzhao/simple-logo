package GUIPackage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Class to store data for each variable in the TableView.
 * @author David
 *
 */
public class TableVariable {
	private final SimpleStringProperty variableName;
	private final SimpleDoubleProperty variableValue;
	
	protected TableVariable (String name, Double value) {
		this.variableName = new SimpleStringProperty(name);
		this.variableValue = new SimpleDoubleProperty(value);
	}
	
	/**
	 * Returns variable name as a String.
	 * @return Variable name
	 */
	protected String getVariableName() {
		return variableName.get();
	}
	
	/**
	 * Sets the variable name as specified String
	 * @param variableName
	 */
	protected void setVariableName(String variableName) {
		this.variableName.set(variableName);
	}
	
	/**
	 * Returns variable value as a String.
	 * @return Variable value
	 */
	protected double getVariableValue() {
		return variableValue.get();
	}

	/**
	 * Sets the variable value as specified String
	 * @param variableValue
	 */
	protected void setVariableValue(Double variableValue) {
		this.variableValue.set(variableValue);
	}
	
}
