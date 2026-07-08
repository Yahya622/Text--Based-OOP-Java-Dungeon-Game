public class Game { //Game class
    
    private static Game instance;   //only runs one game
    private Game() {}
    public static Game getInstance() {  
        if (instance == null) { // this is the singleton structure applied
            instance = new Game();
        }
        return instance;
        // this makes sure no other class can start a new game and blocks them from starting the game from other classes to prevent duplicates
    }

    private Inventory sword;
    private Inventory gun;
    private Inventory chosenWeapon;
    private Player player;
    private Enemy enemyrn;
    private gui gameGui;    // instance variables that gives the objects reference

    private int appleCount; //  this is a primitive variable as it stores the count of how many golden apples there are

    public void setGui(gui gameGui) {   //setGui method
        this.gameGui = gameGui; //Sets/updates the gui
    }
  
    public gui getGui() {   //getter method 
        return this.gameGui;    //returns gui method
    }

    public void setupInventory() {  //setupInventory method
        this.sword = Inventory.createSword();   //Stores the sword object created by Inventory.creastesword
        this.gun = Inventory.createGun();       //Stores the Gun object created by Inventory.creasteGun
    }
    
    public Enemy getRandomEnemy() { //getRandomEnemy method
        return EnemyFactory.createEnemy(); // uses enemy factory to randomly create an enemy and returns ir
    }

    public void start() {   //Start method initialises the game
        setupInventory(); // Initialises inventory

        // creates player and attaches observer
        this.player = new Player("Pat", 10, 50);
        player.addObserver(new GameObserver()); // observer patttern used on player to track players attributes and update relevant classes and methods

        this.enemyrn = getRandomEnemy();  // gets enemy for the random enemy generator

        this.appleCount = ItemManager.loadApples(); // loads number of apples from json file
        gameGui.print("You have " + appleCount + " Golden Apple(s)");   //prints the number of Golden apples to gui

        gameGui.print("Would you like to choose a gun or Sword?");  //prints the question to player so they can choose their strategy

        gameGui.print("Walking through the door");  //prints for affect

        // prints the ascii art based on which enemy is chosen
        if (enemyrn instanceof Dragon) {    // if-else logic used
            gameGui.print(Dragon.Dragonframe[0]); //prints dragon ascii image
        } else {
            gameGui.print(Goblin.Goblinframe[0]); //prints goblin ascii image
        }
    }

    public void chooseWeapon(String choice) {   //chooseWeapon method
    if (choice.equals("Sword")) {   // if else logic used depending on the button the player chooses
        player.setAttackStrategy(new Swordstrategy());  //attacks with sword
        gameGui.print("You have chosen the Sword!");    //prints confirmation of weapon chosen
        gameGui.print(Sword.SwordFrame[0]); //prints ASCII Art for sword
    } else {
        player.setAttackStrategy(new Gunstrategy());    //atacks with Gun
        gameGui.print("You have chosen the Gun!");  //prints confirmation of attack
        gameGui.print(Gun.GunFrame[0]); //Prints ASCII Art for gunframe
    }
    gameGui.print("Click Next to attack!"); //prints next so player can attack again
}

    public boolean nextRound() {    //boolean method as it can return true game is still running as player and enemy alive or false if game is stopping as there dead
        if (enemyrn.getHealth() > 0 && player.getHealth() > 0) {     // if statement used to run game as long as both alive/ health greater than 0
            //and and operator used
            gameGui.print("You have attacked"); //prints the attack attack msg
            player.weaponAttack(enemyrn);   //player attacks enemy

            if (enemyrn.getHealth() > 0) { //if logic applied
                enemyrn.attack(player); // enemy attacks back if still alive
            }
        }

        if (enemyrn.getHealth() <= 0) { //if else logic 
            dropApple(); // enemy drops apple when they die
            gameGui.print("You Win!");  //prints you win in gui
            return true; // game over
        } else if (player.getHealth() <= 0) {
            gameGui.print("You Lose!");//prints you lose in gui 
            return true; // game over
        }

        return false; // game continues
    }

    public void dropApple() {   //dropApple method
        appleCount++;   //incremets so adds 1 to golden apple
        ItemManager.saveApple(appleCount);  //saves it in item manager and json file
        gameGui.print("The enemy dropped a Golden Apple! You now have " + appleCount + " apple(s)");    //prints msg to gui
    }

    public void eatApple() {    //eatApple method  
        if (appleCount > 0) {   // if else logic
            player.heal(50); // heals player by 50 if there are apples
            appleCount--;
            ItemManager.saveApple(appleCount); // updates json file
            gameGui.print("You ate a Golden Apple! Health boosted by 50");  // prints health gain msg in gui
        } else {
            gameGui.print("You have no apples!");   //prints in gui if theres no more apples
        }
    }

    public void reset() {   // reset method
        this.player = null; //removes player
        this.enemyrn = null;    //removes enemyrn
        this.chosenWeapon = null;   //removes the chosen weapon 
        this.sword = null;  //removes sword
        this.gun = null;    // removes gun
    }   // basically this method resets everything for a new game 
}