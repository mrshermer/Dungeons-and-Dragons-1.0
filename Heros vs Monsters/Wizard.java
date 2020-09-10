import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Wizard extends Hero{
  private int health;
 
  private ArrayList<Weapon> wizardWeapons = new ArrayList<Weapon>();
  
  public Wizard(int health){
    super(health);
    this.health = health;
  }
  public int getHerosHealth(){
     return health;
  }
  public void setHerosHealth(int health){
     this.health = health;
  }
  
  public void addWeapons(){
     Weapon weapon = new WeaponFatory().createWeapon("Ravin Staff");
     wizardWeapons.add(weapon);
  }
  public void setWeapons(ArrayList<Weapon> weapon){
     this.wizardWeapons = weapon;
  }
  public ArrayList<Weapon> getWeapons(){
     return wizardWeapons;
  }
  
  public void performAbilities(){
       Random attackMove = new Random();
       
       int heroAttack = attackMove.nextInt(3);
       
       if(heroAttack == 0){
           System.out.println("Wizard performs ability: - Arcane Blast");
           heroAttackMove = new ArcneBlast();
       }
       else if(heroAttack == 1){
           System.out.println("Wizard performs ability: - Deception");
           heroAttackMove = new Decption();
       }
       else if(heroAttack == 2){
           System.out.println("Wizard performs ability: - Rooted");
           heroAttackMove = new RootAbility();             
       }
  }
  public void weaponsEquipedForHero(){
      for(int a = 0; a < wizardWeapons.size(); a++){
         Weapon weapons = wizardWeapons.get(a);
         System.out.println("Weapon Equiped: " + weapons.toString());
      }
  }
  public String toString(){
     return "Wizard";
  }

}