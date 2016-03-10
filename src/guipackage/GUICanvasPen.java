package guipackage;

import javafx.scene.paint.Color;

public class GUICanvasPen {
	private static final String SOLID_LINE = "Solid Line";
	private static final int DEFAULT_PEN_SIZE = 3;
	private static final Color DEFAULT_PEN_COLOR = Color.BLACK;
	
	private double myPenSize;
	private String myPenType;
	private int myPenColorIndex;
	private String myPenRGB;
	private Color myPenColor;
	
	public GUICanvasPen(){
		myPenSize = DEFAULT_PEN_SIZE;
		myPenType = SOLID_LINE;
		myPenColorIndex = 0;
		myPenRGB = DEFAULT_PEN_COLOR.getRed() + " " + DEFAULT_PEN_COLOR.getGreen() + " " + DEFAULT_PEN_COLOR.getBlue();
		myPenColor = DEFAULT_PEN_COLOR;
	}

	protected double getMyPenSize() {
		return myPenSize;
	}

	public void setMyPenSize(double myPenSize) {
		this.myPenSize = myPenSize;
	}

	protected String getMyPenType() {
		return myPenType;
	}

	protected void setMyPenType(String myPenType) {
		this.myPenType = myPenType;
	}

	public int getMyPenColorIndex() {
		return myPenColorIndex;
	}

	protected void setMyPenColorIndex(int myPenColorIndex) {
		this.myPenColorIndex = myPenColorIndex;
	}

	public String getMyPenRGB() {
		return myPenRGB;
	}

	protected void setMyPenRGB(String myPenRGB) {
		this.myPenRGB = myPenRGB;
	}

	protected Color getMyPenColor() {
		return myPenColor;
	}

	protected void setMyPenColor(Color myPenColor) {
		this.myPenColor = myPenColor;
	}
	
	
}
