public class Goblin extends Enemy {//Goblin class uses inheritance    
        // same thing as Dragon

        public Goblin(){
                super("Goblin", 100, 25);/*  super allows Goblin to 
         tell enemy what will be in constructor so super allows Goblin to tell enemy stats of Goblin */
}

        static String[] Goblinframe = { // uses static to avoid creating array again and again as static stores it once

            """ 

                    (0 0)
                    - | -
                     / \
                    GOBLIN
                    
                    """

//ASCII Code
        };
}