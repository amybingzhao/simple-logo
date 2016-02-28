package GUIPackage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class TableVariable {
	private final SimpleStringProperty variableName;
	private final SimpleDoubleProperty variableValue;
	
	protected TableVariable (String name, Double value) {
		this.variableName = new SimpleStringProperty(name);
		this.variableValue = new SimpleDoubleProperty(value);
	}

	public String getVariableName() {
		return variableName.get();
	}

	public void setVariableName(String variableName) {
		this.variableName.set(variableName);
	}

	public double getVariableValue() {
		return variableValue.get();
	}

	public void setVariableValue(Double variableValue) {
		this.variableValue.set(variableValue);
	}
	
}
