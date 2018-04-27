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

public class HowToPlayMenu extends Application{
	@Override
	public void start(Stage primaryStage){
		try{
			GridPane root = new GridPane();		
			
			//create background
			Image backGroundImage = new Image("background.png",1200,0,true,false);		
			ImageView bgImageView = new ImageView(backGroundImage);
			
			root.getChildren().addAll(bgImageView);
			
			//create text 
			Label instructionLabel = new Label("Press Any Key to Jump and Avoid Enemies");			
			instructionLabel.setFont(new Font("Candara", 32));
			instructionLabel.setTextFill(Color.web("#E8480C"));
			instructionLabel.setTextAlignment(TextAlignment.CENTER);
			
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
			layout.getChildren().addAll(instructionLabel, returnButton);
			layout.setAlignment(Pos.CENTER);
			
			root.getChildren().addAll(layout);
			
			Scene aboutMenuScene = new Scene(root,1200,800);
			primaryStage.setScene(aboutMenuScene);
			primaryStage.show();
		}catch(Exception e){
		}
	}
}