public class Inventory {    //inventory class

    //instance variables
    private String Weapon;
    private int damage; // Enapsulation as private so limited access so can only access within class unless getter/setter methods r used

    public Inventory(String Weapon, int damage){   //inventory constructor used      //constructor used
        this.Weapon = Weapon;   //stores weapon name in weapon
        this.damage = damage;   //stores damage value in damage
    }

     public static Inventory createSword() {    //create sword method responsible for passing values of sword in constructor and then storing it in weapon and damage
        return new Inventory("Sword", 50);  // passes sword and damage in constructor
    }

    public static Inventory createGun() {//create Gun method responsible for passing values of Gun in constructor and then storing it in weapon
        return new Inventory("Gun", 70); // passes Gun and damage in constructor
    }
    
    public String getWeapon() { //get weapon method
        return Weapon;          // Ensures encapsuation
    //returns method chosen by user
    }
    public int getdamage(){ //get damage method
        return damage;  //returns damage of weapon chosen
    }

        public static Inventory createGoldenApple() {   //golden apple method
        return new Inventory("Golden Apple", 50); // 50 health boost to player
    }

}