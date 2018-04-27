import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.*;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.text.*;
import javafx.scene.paint.Paint;
import java.io.*;
import java.util.ArrayList;

public class ScoreMenu extends Application{
	@Override
	public void start(Stage primaryStage){
		try{
			GridPane root = new GridPane();		
			
			//create background
			Image backGroundImage = new Image("background.png",1200,0,true,false);		
			ImageView bgImageView = new ImageView(backGroundImage);
			
			root.getChildren().addAll(bgImageView);
			
			//read
			BufferedReader br = null;
			String sCurrentLine;
			ArrayList<String>sL = new ArrayList<String>();

			try {			
				br = new BufferedReader(new FileReader("score.txt"));

				while ((sCurrentLine = br.readLine()) != null) {
					sL.add(sCurrentLine);
				}

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			int size = sL.size();
			
			//score label
			Label myLabel = new Label(sL.get(size-1) + "\n" + sL.get(size-2));
			myLabel.setFont(new Font("Candara", 32));
			myLabel.setTextFill(Color.web("#E8480C"));
			myLabel.setTextAlignment(TextAlignment.CENTER);
			
			//create return button
			Button returnButton = new Button("Return");
			returnButton.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
			
			//create shadow
			DropShadow shadow = new DropShadow();
			
			//Adding the shadow when the mouse cursor is on
			returnButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						returnButton.setEffect(shadow);
					}
			});
		
			//Removing the shadow when the mouse cursor is off
			returnButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						returnButton.setEffect(null);
					}
			});
			
			//set return button action
			returnButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {				
					GameMenu newGameMenu = new GameMenu();
					newGameMenu.start(primaryStage);
				}
			});								
			
			VBox layout = new VBox(30);
			layout.getChildren().addAll(myLabel, returnButton);
			layout.setAlignment(Pos.CENTER);
			
			root.getChildren().addAll( layout);
			
			Scene scoreMenuScene = new Scene(root,1200,800);
			primaryStage.setScene(scoreMenuScene);
			primaryStage.show();
		}catch(Exception e){			
		}
	}
}