

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.*;
import javafx.scene.input.MouseButton;

public class Menu extends Application  {
		

	
	
	public static int i=0;




public static void display(){
	
	Stage window = new Stage() ;
	window.setTitle("Menu");
	Button button = new Button("Start Game!");
	Label label = new Label();
	label.setText("How many grids u want?");
	ImageView imageView = new ImageView();
	Image image = new Image("file:D:\\Users\\ASUS\\eclipse-workspace\\TicTacToeLaptop\\Logo\\logo.png");
	imageView.setImage(image);
	imageView.setFitHeight(70);
	imageView.setFitWidth(250);
	

	
	 ChoiceBox cb = new ChoiceBox();
	 cb.getItems().addAll("3", "4", "5","6","7");
	 cb.setValue("3");
	
		button.setOnAction(e-> getChoice(cb,window));
	
	
	VBox layout = new VBox(10);
	layout.setPadding(new Insets(20,20,20,20));
	layout.getChildren().addAll(imageView,label,cb,button);
	
	Scene scene=new Scene(layout,300,250);
	window.setScene(scene);
	window.show();
}

public static void getChoice(ChoiceBox c,Stage stage) {
	
	  i = Integer.parseInt(c.getValue().toString());	 
	  System.out.println(i);
	  Main a = new Main();
	  stage.close();
	  a.display();
	
	
}

public static void main(String args[]) {
	launch(args);
}


public void start(Stage stage) throws Exception{
	display();
}

}