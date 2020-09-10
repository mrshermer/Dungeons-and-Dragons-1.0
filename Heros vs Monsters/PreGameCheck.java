import java.util.ArrayList;

public class PreGameCheck{
   private static PreGameCheck uniqueInstance;
   private char[][] gameArray = null;
   private int determineLevelsVarible = 1;
   private Levels lv1 = null, lv2 = null;
   private ArrayList<Monster> monsters = null;
   
   private PreGameCheck(){
        lv1 = new Level1();
        lv2 = new Level2();
      
   }
   public void determineLevels(){
      if(determineLevelsVarible == 1){
         lv1 = new Level1();
         
         loadGameArray(2, 4);
         setGameArray(gameArray);
         lv1.placeMonsters();
         lv1.monstersToAttack();
         monsters = lv1.getMonstersArray();
      }
      else if(determineLevelsVarible == 2){
         lv2 = new Level2();
         loadGameArray(4, 4);
         setGameArray(gameArray);
         lv2.placeMonsters();
         lv2.monstersToAttack();
         monsters = lv2.getMonstersArray();
      }
          
   }
   public void loadGameArray(int row, int col){
        gameArray = new char[row + 2][col + 2]; 
        int r, c = 0;
        
        
        for(r = 1; r <= row; r++){
          for(c = 1; c <= col; c++){
              gameArray[r][c] = '*';
          }
        }
        gameArray[row][col] = 'F'; 
        gameArray[1][1] = 'S';
   }
   public void setGameArray(char[][] array){
     this.gameArray = array;
   }
   public char[][] getGameArray(){
     return gameArray;
   }
   public static PreGameCheck getInstance(){
      if(uniqueInstance == null){
         uniqueInstance = new PreGameCheck();
      }
      return uniqueInstance;
   }
   public void setGameLevelVarible(int level){
      this.determineLevelsVarible = level;
   }
   public int getGameLevelVarible(){
      return determineLevelsVarible;
   }
   public ArrayList<Monster> getMonstersPerLevel(){
      return monsters;
   } 
   
   public Levels getLevel3Info(){
      return lv2;
   }
 
}