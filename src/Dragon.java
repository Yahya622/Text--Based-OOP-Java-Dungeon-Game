public class Dragon extends Enemy {     // extends shows inheritance allowing dragon to inherit atributes from enemy e.g. health


    public Dragon(){    //Dragon class
        super("Dragon",2000000,75); /*  super allows dragon to 
         tell enemy what will be in constructor so super allows dragon to tell enemy stats of Dragon */
    }


        static final String[] Dragonframe = { //using static as the data doesnt change and is stored once as its the same object
                        //final reinforces static so data remains constant
            """                         
                                \\||/
                                |  @___oo
                 /\\  /\\   / (__,,,,|
                    ) /^\\) ^\\/ _)
                    )   /^\\/   _)
                    )   _ /  / _)
           /|    /\\  )/\\/ ||  | )_)
          / |   <  >      |(,,) )__)
         /  ||||||     /    \\)___)\\
                | \\____(      )___) )___
                \\______(_______;;; __;;;

                    _                                
           _| |  _ __    __ _    __ _    ___       _ __  
         / _` | | '__|  / _` |  / _` |  / _ \\    | '_ \\ 
        | (_| | | |    | (_| | | (_| | | (_) |    | | | |
        \\__,_| |_|     \\__,_|  \\__, | \\__/    |_| |_|
                                |___/                 
            """
// Dragon ASCII Art
        };
}