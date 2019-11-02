package monster;
import java.util.ArrayList;

public class Monster {
    private String type;
    private int strength;//between 5 and 10
    private int health;
    private String description;
    public ArrayList<Tools> monsterInventory;
    
    //************* constructor methods **************************
    public Monster(String t, int s){
        type = t;
        strength = s/*+5*/;//parameter is a 1 to 5 value
        health = 100;
        
        String[]sizes = {"tiny","tall","giant"};
        String[]colors = {"green","blue","violet"};
        String[]look= {"gross","sauve","beguiling"};
        description = sizes[(int)(Math.random()*3)] + ", " +  colors[(int)(Math.random()*3)]+", " + look[(int)(Math.random()*3)] ;
        
    }
    
    //**********  getter methods  ***********************
    public String getType() {
    	return type;
    }
    
    public int getStrength() {
    	return strength;
    }
    
    public int getHealth() {
    	return health;
    }
    
    public String getDescription() {
    	return description;
    }
    
    //**********  other methods  **********************
    public void setHealth(int hp) {
    	health=hp;
    }
    
    public int attacking(){
        //when the monster is attacking
        //returns the amount of damage done to the player
        int baseDamage = (int) (strength * (health / 100.0));
        int variance = (int) ((Math.random() - 0.5) * 10); //Variance of ± 5
        
        int damage= baseDamage+variance;
        
        return damage > 0 ? damage : 0; //Prevents negative damage due to variance
    }//end attack
    
    public int defending(int damage){
        //when the monster is defending
        //returns the current health of the monster after the attack
        
        health-=damage;
        return health;
    }//end defend
    
    public void printInventory(){
        
    }//end printInventory
    public void addInventory(Tools t){
        
    }//addInventory
    public ArrayList<Tools> getInventory(){    
        return monsterInventory;
    }//end getInventory

    
}


