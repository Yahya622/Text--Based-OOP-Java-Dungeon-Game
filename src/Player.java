import java.util.ArrayList; // imports the array class 

public class Player {   //player class

    private int health;
    private String name;
    private int damage; //Instance variables
    private ArrayList<Observer> observers = new ArrayList<>(); // list of observers watching player

    public Player (String name,int health,int damage){      //constructor used
        this.name = name;   //stores the name of the user
        this.health = health;   //stores the health of the user
        this.damage= damage;    //stores the damage the user does with the weapon
    }

    public void addObserver(Observer o) {   //addobserver method
        observers.add(o); // adds the observer to list therefore allowing the observer to notify other classses when something happens to player
    }

    public void notifyObservers(String event) { //notifyobserver method
        for (Observer o : observers) {  //colon means in so observer o in the lit of observers
            o.update(event); // tells observer o what happened
        }
    }
    public void takeDamage(int damageamount) {  //takedamage method
    this.health -= damageamount;    //calculates the health of player after the enemy attack
    Game.getInstance().getGui().print(this.name + " health is now: " + this.health);    //prints msg in gui window

    notifyObservers("Health update:" + this.health); // notifies observers of new health value

    if (this.health <= 0) { //if statement used
        notifyObservers("Player is dead"); // notifies the observers the player has died
    }
}

    public int getHealth() {    //get health method
    return this.health; // returns players health to combat loop in game to check if player is still alive
}
     
    public void weaponattack(Inventory Presentitem, Enemy target) { //tells it to take present item from inv class and also tells it to get target enemy from enemy class

        int damageToEnemy = Presentitem.getdamage();    //stores damage done to the enemy from the player
       
        target.takeDamage(damageToEnemy);   //damage to enemy is the value of damage being taken by the enemy
    }

        public void heal(int amount) {  //heal method
        this.health += amount; // adds health to player
        notifyObservers("HEALTH_UPDATE:" + this.health); // notifies observers of new health value
         Game.getInstance().getGui().print(this.name + " health is now: " + this.health);   // prints in gui
    }

        private Userattackstrategy attackStrategy;  //Instance variable

    public void setAttackStrategy(Userattackstrategy strategy) {    //Attackstrategy method
        this.attackStrategy = strategy; // stroes the attackstrategy for user
    }

    public void weaponAttack(Enemy target) {    //weaponAttack method
        attackStrategy.execute(target); //executes attack on target enemy
    }

}