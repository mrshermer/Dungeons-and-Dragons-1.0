import java.util.ArrayList;
import java.util.Random;

public class Goblin extends Monster{
   private int health = 30;
   private ArrayList<Weapon> goblinWeapons = new ArrayList<Weapon>();
   
   
   
   public Goblin(){
       addGoblinWeapon();
   }
   public int getMonstersHealth(){
     return health;
   }
   public void setMonstersHealth(int health){
     this.health = health;
   } 
   public void addGoblinWeapon(){
     Weapon weapon = new WeaponFatory().createWeapon("Wooden Club");
     goblinWeapons.add(weapon);
   
   }
   public void performAbilities(){
       Random attackMove = new Random();
       
       int monsterAttack = attackMove.nextInt(2);
       
       if(monsterAttack == 0){
           System.out.println("Goblin performs ability: - Club On The Head");
           monsterAttackMove = new ClubOnTheHead();
       }
       else if(monsterAttack == 1){
           System.out.println("Goblin performs ability: - Swing And Hit");
           monsterAttackMove = new SwingAndHit();
       }
       
  }
  public void setGoblinWeapon(ArrayList<Weapon> weapon){
      this.goblinWeapons = weapon;
  }
  public ArrayList<Weapon> getWeapons(){
      return goblinWeapons;
  }
  public String toString(){
     return "Goblin";
  }
}