public class EnemyFactory {//EnemyFactory class
    // factory structural pattern created the enemy the player is fighting as it chooses the enemy

    public static Enemy createEnemy() {

        int randomnumber = (int) (Math.random() * 2); // random number generator gives 2 number as Java is 0 indexed

        if (randomnumber == 1) {    // if else statement is used so if that number its that enemy and vice versa
            return new Dragon();  // creates dragon if 1 is rolled
        } else {
            return new Goblin();  // creates goblin if 0 is rolled
        }
    }
}