import java.util.ArrayList;

import java.util.Random;
import java.util.ArrayList;

public class Orgre extends Monster{
   private int health = 40;
   private ArrayList<Weapon> orgreWeapon = new ArrayList<Weapon>();
   
   public Orgre(){
      addWeaponsToOrgre();
   }
   public int getMonstersHealth(){
     return this.health;
   }
   public void setMonstersHealth(int health){
     this.health = health;
   } 
   public void setOrgreWeapon(ArrayList<Weapon> weapon){
      this.orgreWeapon = weapon;
   }
   
   public void addWeaponsToOrgre(){
       Weapon spikeWeapon = new WeaponFatory().createWeapon("Spike Club");
       orgreWeapon.add(spikeWeapon);
   }
   public ArrayList<Weapon> getWeapons(){
      return orgreWeapon;
   }
   public void performAbilities(){
       Random attackMove = new Random();
       
       int monsterAttack = attackMove.nextInt(4);
       
       if(monsterAttack == 0){
           System.out.println("Ability: - Poisen");
           monsterAttackMove = new Poisen();
       }
       else if(monsterAttack == 1){
           System.out.println("Orgre performs ability: - Stink Breath");
           monsterAttackMove = new StinkBreath();
       }
       else if(monsterAttack == 2){
           System.out.println("Orgre performs ability: - Swamp Attack");
           monsterAttackMove = new SwampAttack();           
       }
       else if(monsterAttack == 3){
           System.out.println("Orgre performs ability: - The Charging Bull");
           monsterAttackMove = new TheChargingBull();           
       }
  }
  public String toString(){
      return "orgre";
  }
}