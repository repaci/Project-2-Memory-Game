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
public class MemoryGameGUI extends Application {
   
   //attributes
   private MemoryGame game;

   
   Font font = new Font("Helvetica", 50);
   GridPane grid = new GridPane();
   Label introlabel;
   int turns = 0;
   Button clicked;
   Button [][] buttons = new Button[4][4];
   ImageView[] all = new ImageView[16];
   Button restartButton = new Button("Restart");
   Label reportLabel;
   


public static void main(String[] args)
   {
      launch(args);
   }
   
@Override
public void start(Stage stage)  {

   //create new game
   game = new MemoryGame();
   game.createBackBoard();
   game.createImageBoard();
   
   setAnimalImages();

   for (int h=0; h<4; h++) {
      for (int v=0; v<4; v++){
         buttons[h][v]=  makeButton(new Image("question.jpg"));
         grid.add(buttons[h][v],h,v);
         buttons[h][v].setOnAction(new MemoryGameButtonHandler());   
         }//for
      }//for 
      
      grid.setAlignment(Pos.CENTER);
   
      Label introLabel = new Label(" Matching Game ");
      introLabel.setFont(font);
      
      Label blank = new Label("     ");
      VBox vbox2 = new VBox(blank);
      
      Label blank2 = new Label("     ");
      VBox vbox3 = new VBox(blank2);
      
      reportLabel = new Label ("Report Label");
      
      Label space = new Label ("    ");
      
      HBox hbox= new HBox ( restartButton, space, reportLabel);
      hbox.setAlignment(Pos.CENTER);
                
      VBox vbox = new VBox(introLabel,vbox2, grid, vbox3, hbox); 
      vbox.setAlignment(Pos.CENTER);
      
      vbox.setPadding(new Insets(20));
         
      Scene scene = new Scene(vbox, 600, 600);
      
      //scene.getStylesheets().add("matchingGame.CSS");
         
      stage.setScene(scene);  
         
      stage.setTitle("Matching Game");
         
      stage.show();
         
   }//End of Stage

void setAnimalImages(){
   
   for(int i=0; i<16; i++){
      if(i>7){
         all[i] = new ImageView("file:animal"+(i-8)+".jpg");
      }
      else{
         all[i] = new ImageView("file:animal"+(i)+".jpg");
      }     
   }                  
}//end setAnimalImages
   
   
Button makeButton(Image img){
      ImageView iView = new ImageView(img);
      iView.setFitWidth(100); 
      iView.setFitHeight(100);
         
      Button newButton =  new Button("",iView);
      return(newButton); 
      
   }
   
class MemoryGameButtonHandler implements EventHandler<ActionEvent>{
      @Override
      public void handle(ActionEvent event){
      
      turns++;
      int i=0;
      int r2=0;
      int c2=0;
      int [] choices = new int[4];
      
      for (int r = 0; r<4; r++) {
            for (int c = 0; c<4; c++){
               
               if(event.getSource().equals(buttons[r][c])){
               
                     //update gui board with image
                     all[i].setFitWidth(100);
                     all[i].setFitHeight(100);
                     buttons[r][c].setGraphic(all[i]);
                     clicked = buttons[r][c];
                     
                     //test if first card or second card
                     if(turns % 2!=0){
                        r2 = r;
                        c2 = c;
                     }
                     else{
                        //add choices to array
                        choices[0] = r;
                        choices[1] = c;
                        choices[2] = r2;
                        choices[3] = c2;
                        
                        //take turn using choices array
                        game.takeTurn(choices);
                        
                        //test if these two are a match
                        if(game.match(choices)==true){
                           reportLabel.setText(String.format("Match!"));
                        }
                        else{
                           reportLabel.setText(String.format("not a match!"));
                           
                           
                           
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
                       
               }
               
               //if restart button clicked
               else if(event.getSource().equals(restartButton)){
                  for (int h=0; h<4; h++) {
                     for (int v=0; v<4; v++){
                        buttons[h][v]=  makeButton(new Image("question.jpg"));
                        grid.add(buttons[h][v],h,v);
                        buttons[h][v].setOnAction(new MemoryGameButtonHandler());   
                     }//for
                  }//for
               }
             i++;   
            }
         }
      }
   }
}
