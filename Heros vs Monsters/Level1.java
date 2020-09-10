import java.util.Random;
import java.util.ArrayList;

public class Level1 extends Levels
{
   private ArrayList<Monster> monster = null;
   
   public Level1(){
       monster = new ArrayList<Monster>();
   }
   public void placeMonsters(){
      PreGameCheck game = PreGameCheck.getInstance();
      Random rand1 = new Random();
      Random rand2 = new Random();
      int countMonsters = 0;
      
    
      char[][] maze = game.getGameArray();
      
      int row = rand1.nextInt(2) + 1;
      int col = rand2.nextInt(4) + 1;
      
      while(countMonsters != 2){
          if(maze[row][col] != 'M' && maze[row][col] != 'S' && maze[row][col] != 'F') {
            
                 maze[row][col] = 'M';
                 countMonsters++; 
          }
          row = rand1.nextInt(2) + 1;
          col = rand2.nextInt(4) + 1;
      }
       game.setGameArray(maze);
     
   }   
   public void monstersToAttack(){
      monster.add(new Goblin());
      monster.add(new Goblin());   
   
   }
   public ArrayList<Monster> getMonstersArray(){
     return monster;
   }
}//end of class