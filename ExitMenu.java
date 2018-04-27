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

public class ExitMenu extends Application{
	@Override
	public void start(Stage primaryStage){
		try{
			GridPane root = new GridPane();		
			
			//create background
			Image backGroundImage = new Image("background.png",1200,0,true,false);		
			ImageView bgImageView = new ImageView(backGroundImage);
			
			root.getChildren().addAll(bgImageView);
			
			//create text 
			Label gameOverLabel = new Label("Game Over");
			gameOverLabel.setFont(new Font("Candara", 50));
			gameOverLabel.setTextFill(Color.web("#E8480C"));
			gameOverLabel.setTextAlignment(TextAlignment.CENTER);
			
			Label score = new Label("Your score: " + Hero.getScore());
			score.setFont(new Font("Candara", 32));
			score.setTextFill(Color.web("#E8480C"));
			score.setTextAlignment(TextAlignment.CENTER);
			
			Label instructionLabel = new Label("Do you want to return to Desktop?");			
			instructionLabel.setFont(new Font("Candara", 32));
			instructionLabel.setTextFill(Color.web("#E8480C"));
			instructionLabel.setTextAlignment(TextAlignment.CENTER);
			
			//read from file
			BufferedReader br = null;
			String sCurrentLine;
			ArrayList<String>sL = new ArrayList<String>();

			try {			
				br = new BufferedReader(new FileReader("score.txt"));

				while ((sCurrentLine = br.readLine()) != null) {
					sL.add(sCurrentLine);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			br.close();
			
			//write to file
			PrintWriter fw = null;
			fw = new PrintWriter("score.txt");
			BufferedWriter bw = new BufferedWriter(fw);			
			try {
				while(!sL.isEmpty()){
					sCurrentLine = sL.get(0);
					bw.write(sCurrentLine);
					bw.newLine();
					sL.remove(0);					
				}
				bw.write(NameMenu.getName() + " " + Hero.getScore());
				bw.close();			
				fw.close();				
			} catch (Exception e) {}
			
			//create No button
			Button noButton = new Button("No");
			noButton.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
			
			//create shadow
			DropShadow shadow = new DropShadow();
			
			//Adding the shadow when the mouse cursor is on
			noButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						noButton.setEffect(shadow);
					}
			});
		
			//Removing the shadow when the mouse cursor is off
			noButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						noButton.setEffect(null);
					}
			});
			
			//set no button action
			noButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {				
					GameMenu newGameMenu = new GameMenu();
					newGameMenu.start(primaryStage);
				}
			});	

			//create Yes button
			Button yesButton = new Button("Yes");
			yesButton.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
			
			//Adding the shadow when the mouse cursor is on
			yesButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						yesButton.setEffect(shadow);
					}
			});
		
			//Removing the shadow when the mouse cursor is off
			yesButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						yesButton.setEffect(null);
					}
			});
			
			//set yes button action
			yesButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {				
					System.exit(0);
				}
			});
			
			VBox layout = new VBox(30);
			layout.getChildren().addAll(gameOverLabel, score, instructionLabel, yesButton, noButton);
			layout.setAlignment(Pos.CENTER);
			
			root.getChildren().addAll(layout);
			
			Scene exitMenuScene = new Scene(root,1200,800);
			primaryStage.setScene(exitMenuScene);
			primaryStage.show();
		}catch(Exception e){			
		}
	}
}