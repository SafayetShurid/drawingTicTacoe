
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Winner {


		static Stage window;

public static void showWinner(String text)  {
	
		 window = new Stage();
		
		//window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Result!");
		window.setMinWidth(250);
		window.setMinHeight(200);
		
		Label label = new Label();
		label.setText("Player " + text + " wins the match!");
		 
		VBox layout = new VBox(10);
		//layout.getChildren().add(label);
		layout.setAlignment(Pos.CENTER);
		
		Button b = new Button("Quit Game");
		b.setOnAction(e->{
			try {
				Quit();
				//Restart();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		layout.getChildren().addAll(label,b);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
		
	}

		public static void Restart() throws Exception {
			
			new draw().start(new Stage());
			draw.horizontal=0;
			draw.vertical =0 ;
			draw.i = 0;
			window.close();
		}
		
        public static void Quit() throws Exception {
			
			System.exit(0);
		}
		
}