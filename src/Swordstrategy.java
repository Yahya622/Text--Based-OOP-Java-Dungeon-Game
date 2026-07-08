public class Swordstrategy implements Userattackstrategy {  //SwordStrategy class uses the interface from userattackstrategy
    public void execute(Enemy target) { //execute method
        target.takeDamage(new Sword().getdamage()); //sword is doing damage to the target enemy
    }
}