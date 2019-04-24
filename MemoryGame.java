
// Code created by Charlie Repaci. Last updated April 16, 2019. 
// Code is a part of a larger MemoryGame program
// Coordinated with Ismah Ahmed, Natalie Starczewski, Lauren Del Vacchio, and Michele MacKinnon

// The purpose of this program is to provide backfunctions for the memory game.

import java.util.*;
import java.util.Random;

class MemoryGame implements Game
{

   String[][] backBoard = new String[2][2];
   String[][] imageBoard = new String[2][2];

   public void setUp()
   {
   
   } 
   
   public void createBackBoard()
   {
      for(int r=0; r<2; r++)
      {
         for(int c=0; c<2; c++)
            backBoard[r][c] = "#";
      }
   }
   
   public void createImageBoard()
   {
      Random z = new Random();
      ArrayList<String> i = new ArrayList<String>();
      i.add("A");
      i.add("A");
      i.add("B");
      i.add("B");
      i.add("C");
      i.add("C");
      i.add("D");
      i.add("D");
      i.add("E");
      i.add("E");
      i.add("F");
      i.add("F");
      i.add("G");
      i.add("G");
      i.add("H");
      i.add("H");
      
      for(int r=0; r<2; r++)
      {
         for(int c=0; c<2; c++)
         {
            String randomImage = i.get(z.nextInt(i.size()));
            imageBoard[r][c] = randomImage;
            i.remove(randomImage);
         }
            
      }
   }
   
   public boolean findMatch(int r1, int c1, int r2, int c2)
   {
      if(imageBoard[r1][c1].equals(imageBoard[r2][c2]))
         return(true);
      else
         return(false);
   }
   
   
   public void takeTurn(int [] choice)
   {
   turncnt++
   if(findMatch() == true){
      System.out.println("That's a match!");
      if(gameOverStatus().equals("winner")){
      isWinner = true;
         }
         
      }
   else if(findMatch == false){
     System.out.println("That's not a match");
      }
      }

   }
   
public int findImagePlacement(String image)
   {
      int row1 = -1;
      int col1 = -1;
      int row2 = -1;
      int col2 = -1;
      
      for(int r=0; r<2; r++)
      {
         for(int c=0; c<2; c++)
         {
           if(imageBoard[r][c].equals(image)) 
           {
              if(row1 == -1 && col1 == -1)
              {
                row1 = r;
                col1 = c;
              }
              else if(row1 != -1 && col1 != -1)
              {
                row2 = r;
                col2 = c;
              }
           }
         }
      }
      
      return(row1, col1, row2, col2);
   }
   
   public boolean isWinner()
   {
      return (false);
   }
    
   public int getTurnCnt()
   {
      return(1);
   }
   
   public String gameOverStatus()
   {
      return("inProgress");
   }
   
   public boolean isValidInput(int [] x)
   {
      return(true);
   }

}// MemoryGame class
