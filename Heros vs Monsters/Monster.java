import java.util.ArrayList;

public abstract class Monster{
   protected MonsterAbilites monsterAttackMove;
   
   
   public Monster(){

   }
   public int monsterAttackMove(){
      return monsterAttackMove.attack();
   }
   public void setMonsterAttackMove(MonsterAbilites abilities){
      this.monsterAttackMove = abilities;
   }
   public abstract int getMonstersHealth();
   public abstract void setMonstersHealth(int health);
   public abstract void performAbilities();
   public abstract ArrayList<Weapon> getWeapons();
   public abstract String toString();
}