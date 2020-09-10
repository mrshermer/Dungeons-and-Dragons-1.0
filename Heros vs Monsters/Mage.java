import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Mage extends Hero{
  private int health;
  private ArrayList<Weapon> mageWeapons = new ArrayList<Weapon>();
 
  
 
  public Mage(int health){
    super(health);
    this.health = health;
  }
  public int getHerosHealth(){
     return health;
  }
  public void setHerosHealth(int health){
     this.health = health;
  }
  
  public void performAbilities(){
       Random attackMove = new Random();
       
       int heroAttack = attackMove.nextInt(3);
       
       if(heroAttack == 0){
           System.out.println("Mage performs ability: - Pulverising Punch");
           heroAttackMove = new PulverisingPunch();
       }
       else if(heroAttack == 1){
           System.out.println("Mage performs ability: - Rapid Fire");
           heroAttackMove = new RapidFire();
       }
       else if(heroAttack == 2){
           System.out.println("Mage performs ability: - Swoard Slash");
           heroAttackMove = new SwoardSlash();             
       }
  }
  public void addWeapons(){
         Weapon weapon = new WeaponFatory().createWeapon("Swoard Of Death");
         mageWeapons.add(weapon);
  }
  public void setWeapons(ArrayList<Weapon> weapon){
     this.mageWeapons = weapon;
  }
  public ArrayList<Weapon> getWeapons(){
     return mageWeapons;
  }
  public void weaponsEquipedForHero(){
      for(int a = 0; a < mageWeapons.size(); a++){
         Weapon weapons = mageWeapons.get(a);
         System.out.println("Weapon Equiped: " + weapons.toString());
      }
  }
  public String toString(){
     return "Mage";
  }

}//end of classs