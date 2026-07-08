   public class Enemy{  //Enemy class
    

        private String monster; // Instance variable - Enemey name
        private int health;     // Instance variable - Enemy Health
        private int damage;     //Instance variable - Enemy attacking power

    public Enemy(String monster,int health,int damage){ //constructor used- has 3 charachteristics monster, health and damage

        this.monster = monster; //passes values in to monster
        this.health = health;   //passes values in to health
        this.damage = damage;   //passes values in to damage
    }

public void takeDamage(int damageamount) {  //takeDamage method
    this.health -= damageamount;    //calculates the health of enemy after the players attack
    if (this.health <= 0) { // if-else logic statement used
        Game.getInstance().getGui().print(this.monster + " has been slayed!"); // prints slayed message if enemy health is less than or equal to 0
    //getInstance() - represents singleton pattern as it means there will only be one game
    // getInstance() returns single game object and getGUI() returns gui and print, prints the text to gui 
    } else {
        Game.getInstance().getGui().print(this.monster + " health is now: " + this.health); // otherwise prints the enemys health at that time
    }
}

    public void attack(Player target) {    //attack method
        Game.getInstance().getGui().print(this.monster + " attacks back!"); // enemy attacks the player printing msg
        target.takeDamage(this.damage); // enemy is doing the damage to the player
    }
    public int getHealth() {
            return this.health; // checks if the enemy is dead / if the player has won
        }

}