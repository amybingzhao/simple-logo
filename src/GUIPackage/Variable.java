package GUIPackage;
import javafx.beans.property.SimpleStringProperty;

public class Variable {
	private final SimpleStringProperty variableName;
	private final SimpleStringProperty variableValue;
	
	protected Variable (String name, String value) {
		this.variableName = new SimpleStringProperty(name);
		this.variableValue = new SimpleStringProperty(value);
	}

	public String getVariableName() {
		return variableName.get();
	}

	public void setVariableName(String variableName) {
		this.variableName.set(variableName);
	}

	public String getVariableValue() {
		return variableValue.get();
	}

	public void setVariableValue(String variableValue) {
		this.variableValue.set(variableValue);
	}
	
}
