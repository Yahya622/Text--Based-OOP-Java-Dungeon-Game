public class Gun extends Inventory {    //Gun class which extends inventory so inheritance giving it the name and damage

    static String[] GunFrame = {    //using static as the data doesnt change and is stored once as its the same object
        """
                          __,_____
                        / __.==--"
                        /#(-'
                        `-'
                """ //Gun Ascii Art
    };

    public Gun() {
        super("Gun", 150);  //super used to pass these values in the constructor in inventory
    }
}