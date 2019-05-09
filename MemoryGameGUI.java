import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color; 
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.*;
import java.util.*; 
import javafx.geometry.Insets;

import java.util.concurrent.TimeUnit;

public class MemoryGameGUI extends Application {
   
   //attributes
   private MemoryGame game;
   
   Font font = new Font("American Typewriter", 50);
   GridPane grid = new GridPane();
   Label introlabel;
   int turns = 0;
   int i=0;
   
   Button [][] buttons = new Button[4][4];
   ImageView[] all = new ImageView[16];
   Button restartButton = new Button("Restart");
   Button turnOverButton = new Button("Turn Over");
   Label reportLabel;
   
   //initialize variables for choices
   int r2=0;
   int c2=0;
   
   int r1=0;
   int c1=0;
   
   int r=0;
   int c=0;
   

public static void main(String[] args){
      launch(args);
   }
   
@Override
public void start(Stage stage)  {

   //create new game
   game = new MemoryGame();
   game.setUp();
   
   //game.createBackBoard();
   //game.createImageBoard();

   setImages();   
   setButtons();  
      
      grid.setAlignment(Pos.CENTER);
   
      Label introLabel = new Label(" Matching Game ");
      introLabel.setFont(font);
            
      Label blank = new Label("     ");
      VBox vbox2 = new VBox(blank);
      
      Label blank2 = new Label("     ");
      VBox vbox3 = new VBox(blank2);
      
      reportLabel = new Label ("Report Label");
      reportLabel.setFont(new Font("American Typewriter",25));
      reportLabel.setStyle("-fx-text-fill: BLACK ");
      
      Label space = new Label ("    ");
      
      restartButton.setOnAction(new MemoryGameButtonHandler());
      restartButton.setFont(new Font("American Typewriter",25));
      restartButton.setStyle("-fx-border-color: #c7f9cd; -fx-border-width: 5px;");
      
      turnOverButton.setOnAction(new MemoryGameButtonHandler());
      turnOverButton.setFont(new Font("American Typewriter",25));
      turnOverButton.setStyle("-fx-border-color: #c7f9cd; -fx-border-width: 5px;");
      turnOverButton.setVisible(false);

      HBox hbox= new HBox (restartButton, turnOverButton, space, reportLabel);
      hbox.setAlignment(Pos.CENTER);
                
      VBox vbox = new VBox(introLabel,vbox2, grid, vbox3, hbox);
      vbox.setBackground(Background.EMPTY); 
      vbox.setAlignment(Pos.CENTER);      
      vbox.setPadding(new Insets(20));
         
      Scene scene = new Scene(vbox, 1000, 800, Color.LIGHTBLUE);
            
      //scene.getStylesheets().add("matchingGame.CSS");
         
      stage.setScene(scene);  
         
      stage.setTitle("Matching Game");
         
      stage.show();
         
   }//End of Stage
   
Button makeButton(Image img){
      ImageView iView = new ImageView(img);
      iView.setFitWidth(100); 
      iView.setFitHeight(100);
         
      Button newButton =  new Button("",iView);
      return(newButton); 
   }
   
void setImages(){
      for (int h=0; h<4; h++) {
         for (int v=0; v<4; v++){
               int num = (game.get(h,v)) - 'A';
               
               System.out.println(num);
               
               all[num] = new ImageView("file:animal"+(num)+".jpg");
               all[num].setFitWidth(100);
               all[num].setFitHeight(100);
               
               grid.add(all[num], h, v);
             
         }//for
      }//for 
}   

void setButtons(){
      for (int h=0; h<4; h++) {
         for (int v=0; v<4; v++){
            buttons[h][v]=  makeButton(new Image("question.jpg"));
            grid.add(buttons[h][v],h,v);
            buttons[h][v].setStyle("-fx-background-color: #c7f9cd");
            buttons[h][v].setOnAction(new MemoryGameButtonHandler());   
         }//for
      }//for  
}

class MemoryGameButtonHandler implements EventHandler<ActionEvent>{
      @Override
      public void handle(ActionEvent event){
      
      turns++;
      
      int [] choices = new int[4];
      
      for (r = 0; r<4; r++) {
            for (c = 0; c<4; c++){
               if(event.getSource().equals(buttons[r][c])){
                  
                  buttons[r][c].setVisible(false);
                  buttons[r][c].setOnAction(null);

                  //test if first card or second card
                  if(i % 2 == 0){
                     r2 = r;
                     c2 = c;
                  }
                  else{
                     //add choices to array
                     r1 = r;
                     c1 = c;
                     
                     choices[0] = r;
                     choices[1] = c;
                     choices[2] = r2;
                     choices[3] = c2;
                     
                     //take turn using choices array
                     game.takeTurn(choices);  
                     game.updateTurnCount();

                     //test if these two are a match
                     if(game.match(choices) == true){
                        reportLabel.setText(String.format("Match!"));
                        turnOverButton.setVisible(false);
                     }
                     else{
                        reportLabel.setText(String.format("not a match!"));
                        turnOverButton.setVisible(true);                      
                     }
                  }
                                   
                  //test if game is won
                  if(game.isWinner()){
                     for(r=0;r<3;r++){ 
                        for(c=0; c<3; c++){
                           reportLabel.setText(String.format("Game won!"));
                        }
                     }
                  }//end test if game is won
               i++;       
               }
            }
         }
         
         //if restart button clicked
         if(event.getSource().equals(restartButton)){
                  i=0;
                  
                  game = new MemoryGame();
                  game.setUp();
                  //game.createBackBoard();
                  //game.createImageBoard();
                  
                  setImages();   
                  setButtons();  
                                  
                  reportLabel.setText(String.format("New Game!"));
             
         }//end if restart button clicked
         
         if(event.getSource().equals(turnOverButton)){
            turnOverButton.setVisible(true);
            buttons[r1][c1].setVisible(true);
            buttons[r1][c1].setOnAction(new MemoryGameButtonHandler());

            buttons[r2][c2].setVisible(true);
            buttons[r2][c2].setOnAction(new MemoryGameButtonHandler());
         }//end if turnOverButton clicked
      }
   }//end MemoryGameButtonHandler
}//end public class MemoryGameGUI
