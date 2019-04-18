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

public class MemoryGameGUI extends Application {

   GridPane grid = new GridPane();
   Label introlabel;
   Button [][] buttons = new Button[4][4];
   //Image[] symbols = new Image[2];
   int turns=0;
   ImageView[] animals = new ImageView[8];


public static void main(String[] args)
   {
      launch(args);
   }
   
@Override
public void start(Stage stage)  {

   setAnimalImages();

   for (int h=0; h<4; h++) {
      for (int v=0; v<4; v++){
         buttons[h][v]=  makeButton(new Image("unknown.png"));
            
         }//for
         
      }//for
      
      
    for (int h=0; h<4; h++) {
      for (int v=0; v<4; v++){
         grid.add(buttons[h][v],h,v);
         buttons[h][v].setOnAction(new MemoryGameButtonHandler());  
            
         }//for
         
      } //for 
      
      grid.setAlignment(Pos.CENTER);
   
      Label introLabel = new Label("Matching Game Label");
       
                
      VBox vbox = new VBox(introLabel,grid); 
      
         
      Scene scene = new Scene(vbox,500, 500);    
         
      stage.setScene(scene);  
         
      stage.setTitle("Matching Game");
         
      stage.show();
         
   }//End of Stage

void setAnimalImages(){

   //new ImageView = new ImageView(new Image());
   
   animals[0] = new ImageView(new Image("file:bunny.jpg"));    //bunny image
   animals[1] = new ImageView(new Image("file:chick.jpg"));    //chick
   animals[2] = new ImageView(new Image("file:duck.jpg"));     //duck
   animals[3] = new ImageView(new Image("file:forgui1.jpg"));  //cats
   animals[4] = new ImageView(new Image("file:goat.jpg"));    //goat
   animals[5] = new ImageView(new Image("file:pig.jpg"));     //pig
   animals[6] = new ImageView(new Image("file:sheep.jpg"));   //sheep
   animals[7] = new ImageView(new Image("file:pony.jpg"));    //pony
   /*animals[8] = new ImageView(new Image("file:bunny.jpg"));    //bunny image
   animals[9] = new ImageView(new Image("file:chick.jpg"));    //chick
   animals[10] = new ImageView(new Image("file:duck.jpg"));     //duck
   animals[11] = new ImageView(new Image("file:forgui1.jpg"));  //cats
   animals[12] = new ImageView(new Image("file: goat.jpg"));    //goat
   animals[13] = new ImageView(new Image("file: pig.jpg"));     //pig
   animals[14] = new ImageView(new Image("file: sheek.jpg"));   //sheep
   animals[15] = new ImageView(new Image("file: pony.jpg"));*/    //pony
                    
      }       
   
   
Button makeButton(Image img){
      ImageView iView = new ImageView(img);
      iView.setFitWidth(100); 
      iView.setFitHeight(100);
         
      Button newButton =  new Button("",iView);
      return(newButton); 
      
   }
   
class MemoryGameButtonHandler implements EventHandler<ActionEvent>
      {
      @Override
      public void handle(ActionEvent event){
      turns++;
      int i=-1;
      for (int h = 0; h<4; h++) {
            for (int v = 0; v<4; v++){
            i++;
               if(event.getSource().equals(buttons[h][v])){
                  animals[i].setFitWidth(100);
                  animals[i].setFitHeight(100);
                  buttons[h][v].setGraphic(animals[i]);
                  grid.add(buttons[h][v],h,v);
                  
                  }
                  
                  //buttons[h][v] = makeButton(animals[i-7]);
               
                

                  }

}}}}

   
   

