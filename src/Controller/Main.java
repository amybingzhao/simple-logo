package Controller;

import GUIPackage.GUI;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by blakekaplan on 2/23/16.
 */
public class Main extends Application{
	private static final int SCREEN_WIDTH = 500;
	private static final int SCREEN_HEIGHT = 500;
	
	private Stage s;
	GUI myGui;
    @Override
    public void start(Stage myStage) throws Exception {
    	s = new Stage();
    	myGui = new GUI(SCREEN_WIDTH, SCREEN_HEIGHT);
    	s.setScene(myGui.createScene());
    	s.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
