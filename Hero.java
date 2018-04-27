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
import javafx.application.Platform;
import java.awt.*;
import javafx.scene.effect.DropShadow;

public class Hero implements Runnable{
	private double positionX;
	private double positionY;
	private static ImageView heroImageView;
	private static int score;
	static Thread heroThread;
	private Image heroImage;
	static boolean break_thread;
	
	static Stage copyStage;
	
	Hero(){				
		score = 0;
	
		break_thread = false;
	
		heroImage = new Image("Hero.png");
	
		//insert hero image and set size
		heroImageView = new ImageView();
		heroImageView.setImage(heroImage);				
		heroImageView.setFitWidth(200);		
		heroImageView.setPreserveRatio(true);
	}
	
	public static void incrementScore(){
		score++;
	}
	
	public static int getScore(){
		return score;
	}
	
	public static void resetScore(){
		score = 0;
	}
	
	static ImageView getHeroImageView(){
		return heroImageView;
	}
	
	void setPosition(double x, double y){
		this.positionX = x;
		this.positionY = y;
		
		heroImageView.setX(x);
		heroImageView.setY(y);
	}
	
	void setTemporaryPosition(double x, double y){
		heroImageView.setX(x);
		heroImageView.setY(y);
	}
	
	public void run(){
		double pos_y = positionY;
		for(int i=0; i<150; i++){
			pos_y-=2.5;
			final double pos_y_temp = pos_y;
			Platform.runLater(() ->{						
				setTemporaryPosition(this.positionX, pos_y_temp);
			});			
			
			try{
				Thread.sleep(2);
			}catch(Exception e){}
		}
		
		for(int i=0; i<150; i++){
			pos_y+=2.5;
			final double pos_y_temp = pos_y;
			Platform.runLater(() ->{						
				setTemporaryPosition(this.positionX, pos_y_temp);			
			});	
			try{
				Thread.sleep(2);
			}catch(Exception e){}
		}
	}
	
	void jump(){		
		heroThread = new Thread(this);
		heroThread.start();
	}
}