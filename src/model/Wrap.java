package model;
 
 import guipackage.Bounds;
 import guipackage.GUICanvas;
 
 public class Wrap extends DisplayNode {
 	private static final String WRAP = "Wrap";
 	private static final int RETURN_VAL = 1;
 	
 	@Override
 	protected double performCanvasOperation(GUICanvas canvas, double val) {
 		canvas.setBounds(Bounds.Wrap);
 		return RETURN_VAL;
 	}
 
 	@Override
 	public String toString() {
 		return WRAP + childrenToString();
 	}

}