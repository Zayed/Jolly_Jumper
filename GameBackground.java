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

public class GameBackground{
	private BackgroundImage bgImg;
	private Image imageBackground;
	
	GameBackground(){
			//insert background image
			imageBackground = new Image("background.png", 1200, 0, true, false);
			
			//create background
			bgImg = new BackgroundImage(imageBackground, BackgroundRepeat.REPEAT, 
									BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
									BackgroundSize.DEFAULT);												
	}
	
	BackgroundImage getImage(){
		return bgImg;
	}
}