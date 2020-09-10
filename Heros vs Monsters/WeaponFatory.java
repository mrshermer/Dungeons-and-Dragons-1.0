public class WeaponFatory{
   Weapon createWeapon(String weaponCode){
     
     if(weaponCode.equals("Swoard Of Death")){
        return new SwoardOfDeath();
     } 
     
     else if(weaponCode.equals("Ravin Staff")){
        return new RavinStaff();
     }
     
     
     else if(weaponCode.equals("Wooden Club")){
        return new WoodenClub();
     }
          else if(weaponCode.equals("Spike Club")){
        return new SpikeClub();
     }
     
     return null;
   }
   


}