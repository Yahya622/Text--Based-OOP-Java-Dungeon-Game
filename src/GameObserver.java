public class GameObserver implements Observer {//Gameobserver class
    //interface as were implementing observer

    public void update(String event) {  // update method
        if (event.equals("Player is dead")) {   //if else logic used 
            Game.getInstance().getGui().print("You have died! Game over."); //prints msg in gui updating user showing properties of observer pattern
        } else if (event.startsWith("Health-update:")) {    // if else logic used to update health 
            String health = event.split(":")[1];    //splits it so health is at 0 index and the int value is at 1 index
            Game.getInstance().getGui().print("Health updated: " + health); // prints to console instead of GUI
        }
    }
}