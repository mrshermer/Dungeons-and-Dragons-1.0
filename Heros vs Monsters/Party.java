import java.util.ArrayList;
import java.util.Scanner;

public class Party{

  private ArrayList<Hero> party = new ArrayList<Hero>();
  
  public Party(){
  
  }
  public void listHeros(){
     System.out.println("Please select your hero\n");
     System.out.println("Mage: A fierce warrior");
     System.out.println("Wizard: May his magical powers terrify you");
  }
  public boolean checkHero(String userHeroSelection){
     if(userHeroSelection.equals("MAGE") ||  userHeroSelection.equals("WIZARD")){
        return true;
     }
     return false;
  }
  public void addHerosToParty(int numberOfHeros){
       listHeros();
       int numberOfPlayers = 0;
       String player = "";
       Scanner scan = new Scanner(System.in);
       
       do{
        player = scan.nextLine().toUpperCase();
        if(checkHero(player)){
            switch(player){
                case "MAGE":
                  party.add(new Mage(100));
                  
                  break;
                case "WIZARD":    
                  party.add(new Wizard(100));
                  break;  
            }     
            numberOfPlayers++;
        }
      }while(numberOfPlayers != numberOfHeros);
  }
  
  public ArrayList<Hero> getParty(){
     return party;
  }
  public void addWeaponsToHeros(){
      for(int a = 0; a < getParty().size(); a++){
         Hero hero = getParty().get(a);
         hero.addWeapons();
      }
  }

}//end of party class