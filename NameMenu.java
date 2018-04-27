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

class NameMenu extends Application{
	private static String playerName;
	
	static String getName(){
		return playerName;
	}
	
	@Override
	public void start(Stage primaryStage){
		try{
			GridPane root = new GridPane();		
			
			//create background
			Image backGroundImage = new Image("background.png",1200,0,true,false);		
			ImageView bgImageView = new ImageView(backGroundImage);
			
			root.getChildren().addAll(bgImageView);
			
			//create text 
			Label nameLabel = new Label("Name: ");			
			nameLabel.setFont(new Font("Candara", 32));
			nameLabel.setTextFill(Color.web("#E8480C"));
			nameLabel.setTextAlignment(TextAlignment.CENTER);
			
			TextField textField = new TextField ();
			textField.setMaxWidth(250);
			HBox hb = new HBox();
			hb.getChildren().addAll(nameLabel, textField);
			hb.setSpacing(10);
			
			//create play button
			Button playButton = new Button("Play");
			playButton.setStyle("-fx-font: 32 candara; -fx-base: #FF9E2B;");
			
			//create shadow
			DropShadow shadow = new DropShadow();
			
			//Adding the shadow when the mouse cursor is on
			playButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						playButton.setEffect(shadow);
					}
			});
		
			//Removing the shadow when the mouse cursor is off
			playButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
				new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent e) {
						playButton.setEffect(null);
					}
			});
			
			//set play button action
			playButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					playerName = textField.getText();
					LevelMenu levelMenu = new LevelMenu();
					levelMenu.start(primaryStage);
				}
			});
			
			VBox layout = new VBox(30);
			layout.getChildren().addAll(nameLabel, textField, playButton);
			layout.setAlignment(Pos.CENTER);
			
			root.getChildren().addAll(layout);
			
			Scene nameMenuScene = new Scene(root,1200,800);
			primaryStage.setScene(nameMenuScene);
			primaryStage.show();
		}catch(Exception e){
		}
	}
}