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
   
   //attributes
   GridPane grid = new GridPane();
   Label introlabel;
   int turns = 0;
   
   Button clicked;
   
   Button [][] buttons = new Button[4][4];
   ImageView[] all = new ImageView[16];
   


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
         
      }//for 
      
      grid.setAlignment(Pos.CENTER);
   
      Label introLabel = new Label("Matching Game Label");
       
                
      VBox vbox = new VBox(introLabel,grid); 
      
         
      Scene scene = new Scene(vbox,500, 500);    
         
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
   
class MemoryGameButtonHandler implements EventHandler<ActionEvent>
{
      @Override
      public void handle(ActionEvent event){
      
      turns++;
      int i=0;
      
      for (int h = 0; h<4; h++) {
            for (int v = 0; v<4; v++){
            
               if(event.getSource().equals(buttons[h][v])){
                     
                     all[i].setFitWidth(100);
                     all[i].setFitHeight(100);
                     buttons[h][v].setGraphic(all[i]);
                     clicked = buttons[h][v];
                     
                     if(all[i] == new ImageView("file:animal"+(0)+".jpg")){
                        System.out.println("Match");
                     }
                     
               }
               i++;
            }
      }

      

}}}

   
   

