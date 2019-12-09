
import java.awt.Label;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseButton;



public class Main  {
	
	public boolean turn=false;
	public static Tile[][] Board =  new Tile[ draw.i][ draw.i];
	public Combo combos;
	Stage window;
	public String player="";
	public int winCombo;
	
	
	
private class Tile extends StackPane {
	
	
	public int value;
	public int col;
	public int row;
	
	ImageView o = new ImageView();
	Image oImage =  new Image("file:D:\\Users\\ASUS\\eclipse-workspace\\TicTacToe\\Images\\O.jpg");
	Image xImage = new Image("file:D:\\Users\\ASUS\\eclipse-workspace\\TicTacToe\\Images\\X.jpg");
	public boolean clicked=false;	
		public Tile()
		{
			Rectangle  border = new Rectangle(100,100);
			border.setFill(null);
			border.setStroke(Color.BLACK);
			setAlignment(Pos.CENTER);
			setOnMouseClicked(event->{
				if(event.getButton()==MouseButton.PRIMARY) {
					if(!turn) {
						createO();
						 turn=!turn;
						
					}
					else {
						 createX();
						 turn=!turn;
					}
					
					setOnMouseClicked(null);
					
					/*
					System.out.println(combos.match1(value,row,col));
					System.out.println(combos.match2(value,row,col));
					System.out.println(combos.match3(value,row,col));
					System.out.println(combos.match4(value,row,col));
					*/
					if(combos.match1(value, row, col) || combos.match2(value, row, col) || combos.match3(value, row, col) || combos.match4(value, row, col) ) {
						
							Winner.showWinner(player);
							window.close();
						
					}
					
				}
			});
		
			
			getChildren().add(border);
		
			
		}
		
		
		public void createO() {
			value=1;
			player="O";
			o.setImage(oImage);
			setAlignment(Pos.CENTER);
			o.setFitHeight(100);
			o.setFitWidth(100);
			getChildren().addAll(o);
			System.out.println("O Printed");
		}
		
		public void createX() {
			
			value=2;
			player="X";
			o.setImage(xImage);
			setAlignment(Pos.CENTER);
			o.setFitHeight(100);
			o.setFitWidth(100);
			getChildren().addAll(o);
			System.out.println("X Printed");
			
		}
		
		public int getValue() {
			return value;
		}
		
		public boolean isEmpty() {
			if(value==0) {
				return false;
			}
			else
			{
				return true;
			}
		}
	}


	private class Combo{
		
		public ArrayList<Tile> combo1 = new ArrayList<Tile>();
		public ArrayList<Tile> combo2 = new ArrayList<Tile>();
		public ArrayList<Tile> combo3 = new ArrayList<Tile>();
	
		public Combo() {
			
			
		}
		
		/*public boolean checkCombo1() {
			
			
			 int value = combo1.get(0).getValue();
			 boolean Same = combo1.stream().allMatch(x -> x.getValue()==(value));
			 return Same;
		} */
		
		public boolean match1(int value,int row,int col) {
			
			//System.out.println(value + " " + row + " " + col);
			boolean win=false;
			int counter=0;
			for(int i=row ; i <row+1 ; i++) {
				
				for(int j=0 ; j<draw.i ; j++) {
					
					if(value==Board[i][j].getValue()) {
						counter++;
					} 
					else
					{
						break;
					}
				}
				
			}
			if(counter== draw.i) {
				win=true;
			}
			else
			{
				win=false;
			}
			return win;
		}
		
public boolean match2(int value,int row,int col) {
			
			//System.out.println(value + " " + row + " " + col);
			boolean win=false;
			int counter=0;
			for(int i=0 ; i < draw.i ; i++) {
				
				for(int j=i ; j<i+1 ; j++) {
					
					if(value==Board[i][j].getValue()) {
						counter++;
					}
					else
					{
						break;
					}
				}
				
			}
			if(counter== draw.i) {
				win=true;
			}
			else
			{
				win=false;
			}
			return win;
		}

public boolean match3(int value,int row,int col) {
	
	//System.out.println(value + " " + row + " " + col);
	boolean win=false;
	int counter=0;
	for(int i=0 ; i < draw.i ; i++) {
		
		for(int j= draw.i-(i+1) ; j< draw.i-(i) ; j++) {
			
			if(value==Board[i][j].getValue()) {
				counter++;
			}
			else
			{
				break;
			}
			
		}
		
	}
	if(counter== draw.i) {
		win=true;
	}
	else
	{
		win=false;
	}
	return win;
}

public boolean match4(int value,int row,int col) {
	
	//System.out.println(value + " " + row + " " + col);
	boolean win=false;
	int counter=0;
	for(int i=0 ; i <draw.i ; i++) {
		
		for(int j=col ; j<col+1 ; j++) {
			
			if(value==Board[i][j].getValue()) {
				counter++;
			}
			else
			{
				break;
			}
		}
		
	}
	if(counter== draw.i) {
		win=true;
	}
	else
	{
		win=false;
	}
	return win;
}

	}

	
	public void display()
	{
		 window = new Stage();
		Pane root = new Pane();		
		root.setPrefSize(draw.i*100, draw.i *100); 	
		System.out.println(Board.length);
		AddTiles(root);
		combos = new Combo();	
		Scene s = new Scene(root);
		//Menu.display(s);
		window.setScene(s);
		window.show();
		
	}
	
	
	public void AddTiles(Pane root)
	{
		for(int i=0 ; i< draw.i ; i++)
		{
			for(int j=0 ; j< draw.i ; j++)
			{
				Tile tile = new Tile();
				tile.row=i;
				tile.col=j;
				Board[i][j] = tile;
				tile.setTranslateX(100*j);
				tile.setTranslateY(100*i);
				root.getChildren().add(tile);
			}
		}
	}
	
	
  /* public void match (){
	
	   if(Board[0][0].getValue()==1 && Board[0][1].getValue()==1 && Board[0][2].getValue()==1) {
		   System.out.println("Player Win");
	   }
	   */
	   
	   
	 
   
	
	
	
	
}


