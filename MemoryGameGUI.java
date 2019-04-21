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
   Button [][] buttons = new Button[2][2];
   //Image[] symbols = new Image[2];
   int turns=0;
   ImageView[] animals = new ImageView[4];
   ImageView[] matches = new ImageView[4];



public static void main(String[] args)
   {
      launch(args);
   }
   
@Override
public void start(Stage stage)  {

   setAnimalImages();

   for (int h=0; h<2; h++) {
      for (int v=0; v<2; v++){
         buttons[h][v]=  makeButton(new Image("unknown.png"));
            
         }//for
         
      }//for
      
      
    for (int h=0; h<2; h++) {
      for (int v=0; v<2; v++){
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
   for(int i=0;i<2;i++){
         
         animals[i] = new ImageView("file:animal"+(i)+".jpg");
   
  

   /*animals[0] = new ImageView(new Image("file:animal0.jpg"));    //bunny image
   animals[1] = new ImageView(new Image("file:animal1.jpg"));    //chick
   animals[2] = new ImageView(new Image("file:animal2.jpg"));     //duck
   animals[3] = new ImageView(new Image("file:animal3.jpg"));  //cats
   animals[4] = new ImageView(new Image("file:aniaml4.jpg"));    //goat
   animals[5] = new ImageView(new Image("file:animal5.jpg"));     //pig
   animals[6] = new ImageView(new Image("file:animal6.jpg"));   //sheep
   animals[7] = new ImageView(new Image("file:animal7.jpg"));    //pony*/
                    
      }       
     
   
   for(int x=0;x<2;x++){   
         matches[x] = new ImageView("file:match"+(x)+".jpg");
               
      }       
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
      int i=0;
      
      for (int h = 0; h<2; h++) {
            for (int v = 0; v<2; v++){
            
               if(event.getSource().equals(buttons[h][v])){
               
                  if(v < 1){ 
                     animals[i].setFitWidth(100);
                     animals[i].setFitHeight(100);
                     buttons[h][v].setGraphic(animals[i]);
                     
                  }   
                  else{
                     matches[i].setFitWidth(100);
                     matches[i].setFitHeight(100);
                     buttons[h][v].setGraphic(matches[i]);
                     
                  }   
                  i++;
               }
                  
                  
                
                 //grid.add(buttons[h][v],h,v); //error on this line
                 
              
                

                  }

}}}}

   
   

