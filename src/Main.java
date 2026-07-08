public class Main { //main class
    public static void main(String[] args) {    //main method
        
        // Setup the GUI
        gui gd = new gui(640, 480);
        gd.setupgui();
        
        // initialises Game object
        Game myGame = Game.getInstance();
        myGame.setGui(gd); // passes gui to game 
        
    }
}