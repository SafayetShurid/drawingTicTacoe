
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class draw extends Application {

	Canvas canvas ;
	Pane pane;
	Scene scene ;
	GraphicsContext gc;
	double xStart,xEnd,yStart,yEnd;
	public static int horizontal;
	public static int vertical;
	public static int i = 0;
	
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	public void start(Stage stage) throws Exception {
		
		canvas =  new Canvas(800,500);
		
		pane = new Pane();
		
		VBox layout = new VBox(10);
		
		layout.setPadding(new Insets(520,0,0,370));
		Button b = new Button("Start Game");
		b.setOnAction(e->startGame(stage));
		layout.getChildren().addAll(b);
		
		//b.setPadding(new Insets(20,20,30,40));
		//b.setLayoutX(200);
		//b.setLayoutY(3000);
		//b.setPadding(new Insets(20,20,30,30));
		//b.setAlignment(Pos.BOTTOM_RIGHT);
		pane.getChildren().addAll(canvas,layout);
		scene = new Scene(pane,800,600);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.ALICEBLUE);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
		scene.setOnMousePressed(e->{
			gc.beginPath();
			xStart = e.getSceneX();
			yStart = e.getSceneY();
			gc.lineTo(e.getSceneX(),e.getSceneY());
			gc.stroke();
			System.out.println(e.getSceneX() + " " + e.getSceneY());
		});
		
		scene.setOnMouseDragged(e->{
			gc.lineTo(e.getSceneX(),e.getSceneY());
			gc.stroke();
		});
		
	scene.setOnMouseReleased(e->{
		xEnd = e.getSceneX();
		yEnd = e.getSceneY();
		System.out.println(e.getSceneX() + " " + e.getSceneY());
		calculate(xStart, xEnd , yStart , yEnd);
	});
		
		
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	
	public void calculate(double xStart, double xEnd , double yStart , double yEnd) {
		
		double differenceX = Math.abs(xStart - xEnd);
		double differenceY = Math.abs(yStart - yEnd);
		
		if(differenceX > differenceY) {
			System.out.println("Drew a Horizontal Line");
			horizontal++;
		}
		else {
			System.out.println("Drew a Vertical Line");
			vertical++;
			
		}
		
	}
	
	
	public void startGame(Stage stage) {
		 
		if(horizontal==vertical) {
			i=horizontal+1;
		}
		else {
			 i= Math.max(horizontal, vertical);
		}
		 
		  Main a = new Main();
		  stage.close();
		  System.out.println(i);
		  a.display();
		 
	}
	
	
	public static void main(String[] args) {
			
		launch(args);
		
		
	}
	
    
	

}
