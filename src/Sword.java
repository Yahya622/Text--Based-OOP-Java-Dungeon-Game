public class Sword extends Inventory {  //Sword class which extends inventory so inheritance giving it the name and damage

    public Sword() {
        super("Sword", 1); // calls inventory constructor with sword stats
    }

    static String[] SwordFrame = {  //sword frame aray
        """
                   ^
                  |.|
                  |||
                  |||
                  |||
                  |||
                  |||
                __|||_
                `----.`
                 ||  ))
                 |'-',
                 '-'
                
                """
                 //Sword ASCII Art
    };
}