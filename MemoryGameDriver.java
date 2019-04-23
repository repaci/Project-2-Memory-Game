import java.util.*;

class MemoryGameDriver{
   public static void main(String argv[]){
      Scanner sc = new Scanner(System.in); 
      int takeTurn=0;
        
      MemoryGame mg = new MemoryGame();
       mg.setUp();
       mg.createBackBoard();
       mg.createImageBoard();

       System.out.println("In this game you need to match");
       System.out.println("the button pairs in order to win."); 
   } // main
} // class