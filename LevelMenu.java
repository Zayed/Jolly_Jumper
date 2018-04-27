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

public class LevelMenu extends Application{
	@Override
	public void start(Stage primaryStage){
		try{
			GridPane root = new GridPane();		
			
			//create background
			Image backGroundImage = new Image("background.png",1200,0,true,false);		
			ImageView bgImageView = new ImageView(backGroundImage);
			
			root.getChildren().addAll(bgImageView);
			
			//create level1 button
			Button level_1_Button = new Button("Level 1");
			level_1_Button.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
			
			//applying shadow effect pn level_1_Button
			DropShadow shadow = new DropShadow();
			
			//Adding the shadow when the mouse cursor is on
			level_1_Button.addEventHandler(MouseEvent.MOUSE_ENTERED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						level_1_Button.setEffect(shadow);
					}
			});
			
			//Removing the shadow when the mouse cursor is off
			level_1_Button.addEventHandler(MouseEvent.MOUSE_EXITED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						level_1_Button.setEffect(null);
					}
			});	

			//add action to level_1_Button
			level_1_Button.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {				
					Level1 newLevel = new Level1();
					newLevel.start(primaryStage);
				}
			});
			
			//create level2 button
			Button level_2_Button = new Button("Level 2");
			level_2_Button.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
			
			//Adding the shadow when the mouse cursor is on
			level_2_Button.addEventHandler(MouseEvent.MOUSE_ENTERED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						level_2_Button.setEffect(shadow);
					}
			});
			
			//Removing the shadow when the mouse cursor is off
			level_2_Button.addEventHandler(MouseEvent.MOUSE_EXITED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						level_2_Button.setEffect(null);
					}
			});	

			//add action to level_2_Button
			level_2_Button.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {				
					Level2 newLevel = new Level2();
					newLevel.start(primaryStage);
				}
			});
			
			//create return button
			Button returnButton = new Button("Return");
			returnButton.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
			
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
			
			VBox layout = new VBox(15);
			layout.getChildren().addAll(level_1_Button, level_2_Button, returnButton);
			layout.setAlignment(Pos.CENTER);
		
			root.getChildren().addAll(layout);
			
			Scene menuScene = new Scene(root,1200,800);
			primaryStage.setScene(menuScene);
			primaryStage.show();
			
		}catch(Exception e) {            
        }
	}
}