interface Game{
   public void setUp(); 
   public void takeTurn(int [] x);
   public boolean isWinner(); 
   public int getTurnCnt();
   public String gameOverStatus();
   public boolean isValidInput(int [] x);

}// Game class