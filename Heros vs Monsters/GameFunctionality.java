import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class GameFunctionality{
  private Scanner scan = null;
  private Party party = null;
  PreGameCheck preGame = null;
  private int rowMove = 1, colMove = 1;
  private ArrayList<Monster> monsters = null;
    
  public GameFunctionality(){
      scan = new Scanner(System.in);
      party = new Party();
      preGame = PreGameCheck.getInstance();
       
  }
  public void startGame(){
            System.out.println("Welcome to a Miniture version of Dungeons and Dragons\n" +
            "You will face monsters as you try to get past all two levels and navigate the dungeon\n" +
             "" +
            "\nTo start, will you go on this quest alone or with a party?\n" + 
            "Type [1 - 2] to indicate how many people will be in the party\n (1) to go alone\n (2) 2 people maximum in the party");
            preGame.determineLevels();
            monsters = preGame.getMonstersPerLevel();
            int partyNum = 0;
            do{
               partyNum = scan.nextInt(); 
               if(partyNum <= 0 || partyNum > 2){
                  System.out.println("Invalid people for the party: \nType [1 - 2] to indicate how many people will be in the " +  
                  "party\n (1) to go alone\n (2) 2 people maximum in the party");
               }
            }while(partyNum <= 0 || partyNum> 2);
            
            party.addHerosToParty(partyNum);
            party.addWeaponsToHeros();
            System.out.println("Let the Game Begin!\n");
            printGameArray(preGame.getGameArray());
            while (!gameOver()){   
                makeMove();
            }
 }
 private void makeMove(){
     Random die = new Random();
     int spacesToMove = die.nextInt(3) + 1;
     System.out.println("Player moves forward: " + spacesToMove + " Spaces");
     playerChoosesDirection(spacesToMove);
     
     
 }
 private void playerChoosesDirection(int spacesToMove){
      Scanner scan = new Scanner(System.in);
      
      
      while(!doesPlayerHaveMoreMoves(spacesToMove)){
         System.out.println(" Choose [Right, Up, Down] in the maze?");
         String playerDirection = scan.nextLine();
         
         if(playerDirection.equals("Up")){
             spacesToMove = playerMovesUp(spacesToMove);
         }
         else if(playerDirection.equals("Down")){
             spacesToMove = playerMovesDown(spacesToMove);
         }
         else if(playerDirection.equals("Right")){
             spacesToMove = playerMovesRight(spacesToMove);
         }         
      
      }
 
 }
 private int playerMovesUp(int spacesToMove){
    int remainingSpaces = spacesToMove;
    char[][] gameArray = preGame.getGameArray();
    
    while(remainingSpaces != 0){
       if(gameArray[rowMove-1][colMove] == 'M'){
          
          attack();
          gameArray[rowMove-1][colMove] = '*';
          remainingSpaces = 0;
          printGameArray(gameArray);
          break;
       }
       else if(gameArray[rowMove-1][colMove] == 'F'){
          if(preGame.getGameLevelVarible() != 2){
            System.out.println("Congratulations, you have beat Level " + preGame.getGameLevelVarible());
            System.out.println("Welcome to level " + (preGame.getGameLevelVarible()+1));
          
            rowMove = 1; colMove = 1;          
          }
          preGame.setGameLevelVarible(preGame.getGameLevelVarible()+1);
          preGame.determineLevels();
          remainingSpaces = 0;
          monsters = preGame.getMonstersPerLevel();
          printGameArray(preGame.getGameArray());
          break;
       }
       else if(gameArray[rowMove-1][colMove] == '\0'){
          System.out.println("You have hit a wall");
          System.out.println("Remaining spaces left: " + remainingSpaces);
          printGameArray(gameArray);
          break;
       }
       else{
          rowMove--;
          gameArray[rowMove+1][colMove] = '*';
          preGame.setGameArray(gameArray);
          System.out.println();
          printGameArray(gameArray);
          remainingSpaces--;
       } 
    }
    return remainingSpaces;
 }
 private int playerMovesDown(int spacesToMove){
    int remainingSpaces = spacesToMove;
    char[][] gameArray = preGame.getGameArray();
    
   while(remainingSpaces != 0){
       if(gameArray[rowMove+1][colMove] == 'M'){
          attack();
          gameArray[rowMove+1][colMove] = '*';
          printGameArray(gameArray);
          remainingSpaces = 0;
          break;
       }
       else if(gameArray[rowMove+1][colMove] == 'F'){
          if(preGame.getGameLevelVarible() != 2){
            System.out.println("Congratulations, you have beat Level " + preGame.getGameLevelVarible());
            System.out.println("Welcome to level " + (preGame.getGameLevelVarible()+1));
          
            rowMove = 1; colMove = 1;          
          }
          
          preGame.setGameLevelVarible(preGame.getGameLevelVarible()+1);
          preGame.determineLevels();
          monsters = preGame.getMonstersPerLevel();
          printGameArray(preGame.getGameArray());
          remainingSpaces = 0;
          break;
       }
       else if(gameArray[rowMove+1][colMove] == '\0'){
          System.out.println("You have hit a wall");
          System.out.println("Remaining spaces left: " + remainingSpaces);
          printGameArray(gameArray);
          break;
       }
       else{
          rowMove++;
          gameArray[rowMove-1][colMove] = '*';
          preGame.setGameArray(gameArray);
          System.out.println();
          printGameArray(gameArray);
          remainingSpaces--;
       } 
    }
    return remainingSpaces;

 }
  private int playerMovesRight(int spacesToMove){
     int remainingSpaces = spacesToMove;
     char[][] gameArray = preGame.getGameArray();
    
      while(remainingSpaces != 0){
       if(gameArray[rowMove][colMove+1] == 'M'){
          attack();
          gameArray[rowMove][colMove+1] = '*';
          printGameArray(preGame.getGameArray());
          remainingSpaces = 0;
          break;
       }
       else if(gameArray[rowMove][colMove+1] == 'F'){
          if(preGame.getGameLevelVarible() != 2){
            System.out.println("Congratulations, you have beat Level " + preGame.getGameLevelVarible());
            System.out.println("Welcome to level " + (preGame.getGameLevelVarible()+1));
          
            rowMove = 1; colMove = 1;          
          }
                   
          preGame.setGameLevelVarible(preGame.getGameLevelVarible()+1);
          preGame.determineLevels();
     
          monsters = preGame.getMonstersPerLevel();
          remainingSpaces = 0;
          printGameArray(gameArray);
          break;
       }
       else if(gameArray[rowMove][colMove+1] == '\0'){
          System.out.println("You have hit a wall");
          System.out.println("Remaining spaces left: " + remainingSpaces);
          
          printGameArray(gameArray);
          break;
       }
       else{
          colMove++;
          gameArray[rowMove][colMove-1] = '*';
          preGame.setGameArray(gameArray);
          System.out.println();
          printGameArray(gameArray);
          remainingSpaces--;
          
       } 
    }
    return remainingSpaces;
 }
 private boolean doesPlayerHaveMoreMoves(int spacesToMove){
    return (spacesToMove == 0);
 }
 
 public void attack(){
    
  
   int monstersHealth = monsters.get(0).getMonstersHealth();
     
   System.out.println("You've encountered: " + monsters.get(0).toString());
   System.out.println("Monster's Initial Health : " + monsters.get(0).getMonstersHealth());
   System.out.println();
   
   while(!isAttackOver(monstersHealth)){
       for(int a = 0; a < party.getParty().size() && monstersHealth > 0; a++){
            
            Hero herosInParty = party.getParty().get(a);
            System.out.println(herosInParty.toString() + " Health: " + herosInParty.getHerosHealth());
            System.out.println();
            herosInParty.performAbilities();
            int damageHeroWillToMonster = herosInParty.performHeroAttackMove();
            int d = herosInParty.getWeapons().get(0).weaponDamage();
            System.out.println("Total Damage Delt to " + monsters.get(0).toString() + " - " + (damageHeroWillToMonster + d));
            
            monstersHealth -= (damageHeroWillToMonster + d);
            monsters.get(0).setMonstersHealth(monstersHealth);
            
       }
       if(monstersHealth <= 0){
             monsters.remove(0);     
       }
       else {
             for(int a = 0; a < party.getParty().size(); a++){
                Monster monster = monsters.get(0); 
                System.out.println(monster.toString() + " Health: " + monster.getMonstersHealth());
                System.out.println();
                monster.performAbilities();
                int monsterDamageDoToHero = monster.monsterAttackMove();
                int monsterWeaponDamage = monster.getWeapons().get(0).weaponDamage();
                Hero hero = party.getParty().get(a);
                int herosHealth = hero.getHerosHealth();
                herosHealth -= (monsterDamageDoToHero + monsterWeaponDamage);  
                hero.setHerosHealth(herosHealth);  
                System.out.println("Total Damage Delt to " + hero.toString() + " - " + (monsterDamageDoToHero + monsterWeaponDamage));
                System.out.println();
                if(hero.getHerosHealth() <= 0){
                   party.getParty().remove(a);
                   a--;
                }
             }
       }      
   }
 }
 public boolean gameOver(){
    char[][] gameArray = preGame.getGameArray();
     if(party.getParty().size() == 0){
        System.out.println("The game is over, you have not survived");
        return true;
     }
     else if(preGame.getGameLevelVarible() >= 2 && monsters.size() == 0){
        System.out.println("The game is over, you have  survived the final level");
        return true;              
     } 
     else if(preGame.getGameLevelVarible() >= 2 && monsters.size() != 0 && (gameArray[rowMove+1][colMove] == 'F' || gameArray[rowMove][colMove+1] == 'F')){
        System.out.println("The game is over, you have  survived the final level");
        return true;
     }
     return false;
 }
 private boolean isAttackOver(int monstersHealth){
      if(party.getParty().size()==0){
         System.out.println("Noooo your party is dead: the monster wins");
         System.out.println("The battle is over");
         return true;
      }else if(monstersHealth <= 0){
         System.out.println("Congratulations you have survived");
         System.out.println("The battle is over");
         
         return true;
      }
      return false;
 }
 private void printGameArray(char[][] array){
     int a = 0, b = 0;
     array[rowMove][colMove] = 'P';
     
     for(a = 0; a < array.length; a++){
        for(b = 0; b < array[a].length; b++){
           if(array[a][b] == '\0'){
              System.out.print('0');
           }
           else if(array[a][b] == 'F'){
              System.out.print('F');
           }
           else if(array[a][b] == 'P'){
              System.out.print('P');
           }
           else{
              System.out.print('*');           
           }
        }
        System.out.println();
     }
     
     preGame.setGameArray(array);
 }
//make move
//start game
//attack(figure out how to use the hero special aplities meaning when they can use it, slash )

}