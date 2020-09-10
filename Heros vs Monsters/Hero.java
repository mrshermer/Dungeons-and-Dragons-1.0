import java.util.ArrayList;

public abstract class Hero{

   private int health = 0;
   protected HeroAbilities heroAttackMove;

   public Hero(int health){
     this.health = health;
   }
   public int performHeroAttackMove(){
      return heroAttackMove.attack();
   }
   public void setHeroAttackMove(HeroAbilities abilities){
      this.heroAttackMove = abilities;
   }
   public abstract void addWeapons();
   public abstract void weaponsEquipedForHero();
   public abstract void performAbilities();
   public abstract ArrayList<Weapon> getWeapons();
   public abstract int getHerosHealth();
   public abstract void setHerosHealth(int health);
   public abstract String toString();
}