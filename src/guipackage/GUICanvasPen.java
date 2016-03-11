package guipackage;

import java.util.List;

import javafx.scene.paint.Color;

public class GUICanvasPen {
	private static final String SOLID_LINE = "Solid Line";
	private static final int DEFAULT_PEN_SIZE = 3;
	private static final Color DEFAULT_PEN_COLOR = Color.BLACK;
	private static final int DEFAULT_PEN_COUNTER = 0;
	private static final int RGB_MAX = 255;
	private double myPenSize;
	private String myPenType;
	private int myPenColorIndex;
	private String myPenRGB;
	private Color myPenColor;
	private int myPenCounter;
	private List<String> myPenPalette;
	
	public GUICanvasPen(){
		myPenSize = DEFAULT_PEN_SIZE;
		myPenType = SOLID_LINE;
		myPenColorIndex = 0;
		myPenRGB = DEFAULT_PEN_COLOR.getRed()*RGB_MAX  + " " + DEFAULT_PEN_COLOR.getGreen()*RGB_MAX  + " " + DEFAULT_PEN_COLOR.getBlue()*RGB_MAX ;
		myPenColor = DEFAULT_PEN_COLOR;
		myPenCounter = DEFAULT_PEN_COUNTER;
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
	
	public void setMyPenColor(int index){
		this.myPenColorIndex = index;
		String[] rgb = myPenPalette.get(index).split(" ");
		Color col = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
		setMyPenColor(col, myPenPalette.get(index));
	}
	
	public void setMyPenColor(Color c, String penColorName) {
		this.myPenColor = c;
		this.myPenRGB = penColorName;
		for(String turtleName:myPenPalette){
			if(turtleName.equals(penColorName)){
				this.myPenColorIndex = myPenPalette.indexOf(penColorName);
			}
		}
	}
	
	protected void incrementMyPenCounter(){
		this.myPenCounter++;
	}
	
	protected int getMyPenCounter(){
		return myPenCounter;
	}
	
	protected void resetPenCounter(){
		this.myPenCounter = DEFAULT_PEN_COUNTER;
	}
	
	protected void setMyPenPalette(List<String> palette){
		this.myPenPalette = palette;
	}
}
