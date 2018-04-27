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
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

public class GameMenu extends Application{
	@Override
	public void start(Stage primaryStage){
		try{
		GridPane root = new GridPane();		
		
		//create background
		Image backGroundImage = new Image("background.png",1200,0,true,false);		
		ImageView bgImageView = new ImageView(backGroundImage);
		
		root.getChildren().addAll(bgImageView);
		
		//create start game button
		Button startButton = new Button("Start Game");
		startButton.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
		
		//set start game button action
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {				
				NameMenu menu = new NameMenu();
				menu.start(primaryStage);
			}
		});

		//applying shadow effect on startButton
		DropShadow shadow = new DropShadow();
		
		//Adding the shadow when the mouse cursor is on
		startButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
			new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent e) {
					startButton.setEffect(shadow);
				}
		});
		
		//Removing the shadow when the mouse cursor is off
		startButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
			new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent e) {
					startButton.setEffect(null);
				}
		});				
		
		//create about button
		Button aboutButton = new Button("About");
		aboutButton.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
		
		//Adding the shadow when the mouse cursor is on
		aboutButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
			new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent e) {
					aboutButton.setEffect(shadow);
				}
		});
		
		//Removing the shadow when the mouse cursor is off
		aboutButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
			new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent e) {
					aboutButton.setEffect(null);
				}
		});	

		//set about button action
		aboutButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {				
				AboutMenu newAboutMenu = new AboutMenu();
				newAboutMenu.start(primaryStage);
			}
		});
		
		//create how to play button
		Button howToPlayButton = new Button("How to Play");
		howToPlayButton.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
		
		//Adding the shadow when the mouse cursor is on
		howToPlayButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
			new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent e) {
					howToPlayButton.setEffect(shadow);
				}
		});
		
		//Removing the shadow when the mouse cursor is off
		howToPlayButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
			new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent e) {
					howToPlayButton.setEffect(null);
				}
		});
		
		//set howToPlayButton button action
		howToPlayButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {				
				HowToPlayMenu newHowToPlayMenu = new HowToPlayMenu();
				newHowToPlayMenu.start(primaryStage);
			}
		});
		
		//create score button
		Button scoreButton = new Button("Score");
		scoreButton.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
		
		//Adding the shadow when the mouse cursor is on
		scoreButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
			new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent e) {
					scoreButton.setEffect(shadow);
				}
		});
		
		//Removing the shadow when the mouse cursor is off
		scoreButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
			new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent e) {
					scoreButton.setEffect(null);
				}
		});
		
		//set scoreButton button action
		scoreButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {				
				ScoreMenu newScoreMenu = new ScoreMenu();
				newScoreMenu.start(primaryStage);
			}
		});
		
		//create exit button
		Button exitButton = new Button("Exit");
		exitButton.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
		
		//Adding the shadow when the mouse cursor is on
		exitButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
			new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent e) {
					exitButton.setEffect(shadow);
				}
		});
		
		//Removing the shadow when the mouse cursor is off
		exitButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
			new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent e) {
					exitButton.setEffect(null);
				}
		});
		
		//set exitButton button action
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {				
				ExitMenu newExitMenu = new ExitMenu();
				newExitMenu.start(primaryStage);
			}
		});
		
		VBox layout = new VBox(15);
		layout.getChildren().addAll(startButton,aboutButton,howToPlayButton, scoreButton, exitButton);
		layout.setAlignment(Pos.CENTER);
		
		root.getChildren().addAll(layout);
		
		Scene scene = new Scene(root,1200,800);
		primaryStage.setScene(scene);
		primaryStage.show();
		}catch(Exception e){}		
	}
	
	public static void main(String args[]){
		launch(args);
	}
}