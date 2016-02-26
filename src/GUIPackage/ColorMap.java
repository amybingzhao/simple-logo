package GUIPackage;

import java.util.HashMap;

import javafx.scene.paint.Color;

public class ColorMap extends HashMap{
	
	public ColorMap(){
		this.put("RED", Color.RED);
		this.put("ORANGE", Color.ORANGE);
		this.put("YELLOW", Color.YELLOW);
		this.put("GREEN", Color.GREEN);
		this.put("BLUE", Color.BLUE);
		this.put("PURPLE", Color.PURPLE);
		this.put("GREY", Color.GREY);		
		this.put("WHITE", Color.WHITE);
		this.put("BLACK",Color.BLACK);
		this.put("BROWN",Color.BROWN);
		
		this.put(Color.RED, "RED");
		this.put(Color.ORANGE, "ORANGE");
		this.put(Color.YELLOW, "YELLOW");
		this.put(Color.GREEN,"GREEN");
		this.put(Color.BLUE, "BLUE");
		this.put(Color.PURPLE, "PURPLE");
		this.put(Color.GREY, "GREY");		
		this.put(Color.WHITE, "WHITE");
		this.put(Color.BLACK, "BLACK");
		this.put(Color.BROWN, "BROWN");

	}

	@Override
	public Object get(Object key) {
		key = ((String) key).toUpperCase();
		return super.get(key);
	}
	
	public String getStringFromPaint(Object key){
		return (String) super.get(key);
	}


}
