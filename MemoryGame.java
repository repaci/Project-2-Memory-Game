
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
      List<Integer> possiblePos = new ArrayList<>();
      possiblePos.add(0);
      possiblePos.add(1);
      possiblePos.add(2);
      possiblePos.add(3);
      
      for(int r=0; r<2; r++)
      {
         for(int c=0; c<2; c++)
         {
            int position = z.nextInt(possiblePos);
            possiblePos.remove(new Integer(position));
            
            if(position%2 == 0)
              imageBoard[r][c] = "A";
            else
              imageBoard[r][c] = "B"; 
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
