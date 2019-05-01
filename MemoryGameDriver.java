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
      System.out.println("the card pairs in order to win.");
        
      while(mg.isWinner==false && mg.gameOverStatus().equals("inProgress")){
         System.out.println("Which row do you want for card 1?");
         int r1 = sc.nextInt();
         System.out.println("Which column do you want for card 1?");
         int c1 = sc.nextInt();
       
         System.out.println("Which row do you want for card 2?");
         int r2 = sc.nextInt();
         System.out.println("Which column do you want for card 2?");
         int c2 = sc.nextInt();
         int [] choice = new int []{r1,c1,r2,c2};
       
         mg.takeTurn(choice);
         if(mg.match(choice)){
            System.out.println("Match");}
         else{
            System.out.println("No match");}
         
         String[][]backboard=mg.getBackBoard();
         System.out.println(mg);
         
         mg.flipNoMatch(choice);  
      }
      if(mg.isWinner() == true){
         System.out.println("You win!");}
      else{
         System.out.println("You lose!");}
   } // main
} // class