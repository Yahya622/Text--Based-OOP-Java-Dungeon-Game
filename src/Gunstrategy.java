public class Gunstrategy implements Userattackstrategy{ //gunstrategy class uses the interface of userattackstrategy
    //therefore provides its own attack method
    public void execute(Enemy target) { //execute method this method executes the gun attack
        target.takeDamage(new Gun().getdamage());   //this calculates the damage done to the enemy by the gun
    }
}