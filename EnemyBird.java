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
import javafx.application.Platform;
import java.util.*;
import java.awt.Shape;
import javafx.geometry.Bounds;

public class EnemyBird implements Runnable{
	private double positionX;
	private double positionY;
	private ImageView enemyBirdImageView;
	private static boolean play;
	static Thread birdThread;
	private Image birdImage;
	
	EnemyBird(){

		birdImage = new Image("Enemy.png");
		
		//create enemy bird imageview
		enemyBirdImageView = new ImageView();
		enemyBirdImageView.setImage(birdImage);
		enemyBirdImageView.setFitWidth(70);		
		enemyBirdImageView.setPreserveRatio(true);
		
		play = true;
	}
	
	ImageView getEnemyBirdImageView(){
		return enemyBirdImageView;
	}
	
	static boolean getPlay(){
		return play;
	}
	
	static void setPlay(boolean status){
		play = status;
	}
	
	void setPosition(double x, double y){
		this.positionX = x;
		this.positionY = y;
		enemyBirdImageView.setX(x);
		enemyBirdImageView.setY(y);
	}
	
	public void run(){		
		double pos_x;		
		Random rand = new Random();
		pos_x = 1000;
		while(!Hero.break_thread){
			if(pos_x <= 0)
				pos_x = 1000;
			int n = rand.nextInt(3) + 2;
			while(pos_x >= 0 && play == true && !Hero.break_thread){
				
				pos_x -= n;				
				
				if(enemyBirdImageView.intersects(Hero.getHeroImageView().getBoundsInParent())){					
					//Hero.resetScore();
					Hero.break_thread = true;
				}							
				
				final double pos_x_temp = pos_x;
				Platform.runLater(() ->{						
					setPosition(pos_x_temp, positionY);
				});			
				try{
					Thread.sleep(4);
				}catch(Exception e){}
			}
			
			if(play == true && !Hero.break_thread){
				Hero.incrementScore();
				Label newLabel = Level1.getScoreLabel1();
				
				//update score board
				Platform.runLater(() -> {
					newLabel.setText("Score: " + String.valueOf(Hero.getScore())); 
				});
			}	
		}
		
		try{
			Platform.runLater(() -> {
					ExitMenu newMenu = new ExitMenu();
					newMenu.start(Level1.copyStage);
			});
		}catch(Exception e){}
	}	
	
	void move(){
		birdThread = new Thread(this);		
		birdThread.start();
	}
}