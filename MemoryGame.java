

// Code created by Charlie Repaci. Last updated April 30, 2019. 
// Code is a part of a larger MemoryGame program
// Coordinated with Ismah Ahmed, Natalie Starczewski, Lauren Del Vacchio, and Michele MacKinnon

// The purpose of this program is to provide backfunctions for the memory game.

import java.util.*;
import java.util.Random;

class MemoryGame implements Game
{

   String[][] backBoard = new String[4][4];
   String[][] imageBoard = new String[4][4];
   int turnCount = 0;
   boolean isWinner = false;
   int matchesMade = 0;

   public void setUp()
   {
      createBackBoard();
      createImageBoard();
      turnCount = 0;
      isWinner = false;
      matchesMade = 0;
   } 
   
   public void createBackBoard()
   {
      for(int r=0; r<4; r++)
      {
         for(int c=0; c<4; c++)
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
      
      for(int r=0; r<4; r++)
      {
         for(int c=0; c<4; c++)
         {
            String randomImage = i.get(z.nextInt(i.size()));
            imageBoard[r][c] = randomImage;
            i.remove(randomImage);
         }
            
      }
   }
   
   public String[][] getBackBoard()
   {
      return(backBoard);
   }
   
   public String[][] getImageBoard()
   {
      return(imageBoard);
   }
   
   public int getMatchesMade()
   {
      matchesMade = 0;
   }
   
   public int[] findImagePlacement(String image)
   {
      int row1 = -1;
      int col1 = -1;
      int row2 = -1;
      int col2 = -1;
      
      int[] retList = new int[4];
      
      for(int r=0; r<4; r++)
      {
         for(int c=0; c<4; c++)
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
      
      retList[0] = row1;
      retList[1] = col1;
      retList[2] = row2;
      retList[3] = col2;
      
      return(retList);
   }
   
   public void takeTurn(int[] choice)
   {
      int r1 = choice[0];
      int c1 = choice[1];
      int r2 = choice[2];
      int c2 = choice[3];
      
      backBoard[r1][c1] = imageBoard[r1][c1];
      backBoard[r2][c2] = imageBoard[r2][c2];
      
      turnCount++;
   }
   
   public boolean match(int[] choice)
   {
      int r1 = choice[0];
      int c1 = choice[1];
      int r2 = choice[2];
      int c2 = choice[3];
      
      boolean m = false;
      
      if(imageBoard[r1][c1].equals(imageBoard[r2][c2]))
      {
         m = true;
         matchesMade++;
      }
      
      return(m);
   }
   
   public void flipNoMatch(int[] choice)
   {
      int r1 = choice[0];
      int c1 = choice[1];
      int r2 = choice[2];
      int c2 = choice[3];
      
      if(match(choice) == false)
      {
         backBoard[r1][c1] = "#";
         backBoard[r2][c2] = "#";
      }
   }
   
   public boolean isWinner()
   {
      if(matchesMade == 8)
         isWinner = true;
      else
         isWinner = false;
      
      return(isWinner);
   }
    
   public int getTurnCnt()
   {
      return(turnCount);
   }
   
   public String gameOverStatus()
   {
      if(isWinner())
         return("winner");
      else if (turnCount == 12)
         return("loser");
      else
         return("inProgress");
   }
   
   public boolean isValidInput(int [] x)
   {
      int r = x[0];
      int c = x[1];
      
      if(r >= 0 && r <= 3 && c >= 0 && c <= 3)
         return(true);
      else
         return(false);
   }
   
   public String toString()
   {
      String s = " ";
      
      for(int r=0; r<4; r++)
      {
         for(int c=0; c<4; c++)
         {
            if(c == 3)
               s = s + backBoard[r][c] + " \n ";
            else
               s = s + backBoard[r][c];
         }
      }
      
      return(s);
   
   }

}// MemoryGame class
}// MemoryGame class
