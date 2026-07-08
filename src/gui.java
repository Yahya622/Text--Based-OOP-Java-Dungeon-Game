import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;   //awt - Abstract Window Toolkit
import java.awt.FlowLayout;
//imports Java sing classes

public class gui {  //gui class

    private JFrame frame;
    private JButton button;
    private JButton swordbutton;
    private JButton gunbutton;
    private JButton nextbutton;
    private JButton applebutton;
    private JButton restartbutton;
    private int width;
    private int height;
    private JTextArea textArea;
        // instance variables which store gui components and settings for the game window/application

    public gui(int w, int h) {  //gui constructor
        frame = new JFrame();   //creates the main game window object and stores it in the JFrame field
        frame.setLayout(new BorderLayout()); // Set layout of components in window

        // creates text area to display game output
        textArea = new JTextArea(20, 50);   //created the text box in the window where the printing happens / msgs appear
        textArea.setEditable(false);    //prevents the user from editing any printing/msgs
        textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12)); //sets font of text printed

        button = new JButton("Start Game"); //Creates start button
        swordbutton = new JButton("Sword"); //Creates Sword button
        gunbutton = new JButton("Gun");//Creates Gun button
        nextbutton = new JButton("Next");   //Creates next button
        applebutton = new JButton("Eat Golden Apple");  //Creates eat golden apple button
        restartbutton = new JButton("Restart Game");    //Creates Restart game button

        // method calls / setter methods
        swordbutton.setVisible(false);  //hides sword button
        gunbutton.setVisible(false);//hides Gun button
        nextbutton.setVisible(false);//Hides next button
        applebutton.setVisible(false);  //hides golden apple button
        restartbutton.setVisible(false);    // hides restard button
        button.setVisible(true);    //shows start button

        // Waits for user input before showing more buttons
        button.addActionListener(e -> {
            button.setVisible(false);     // Hide Start
            swordbutton.setVisible(true);  // Show Weapons
            gunbutton.setVisible(true);
            Game.getInstance().start(); //starts game using singleton pattern
            
            // Refreshes the UI to show the new buttons
            frame.revalidate(); 
            frame.repaint();
        });

        swordbutton.addActionListener(e -> {    //method call for sword
            swordbutton.setVisible(false);  //hides sword button
            gunbutton.setVisible(false);    //hides gun button
            nextbutton.setVisible(true);    //shows next button
            applebutton.setVisible(true); // shows apple button when combat starts
            Game.getInstance().chooseWeapon("Sword");   //tells game player has chose sword
            frame.revalidate();//refreshes ui
            frame.repaint();
        });

        gunbutton.addActionListener(e -> {  // method call for gun does same thing as sword but for Gun
            swordbutton.setVisible(false);
            gunbutton.setVisible(false);
            nextbutton.setVisible(true);
            applebutton.setVisible(true); // shows apple button when combat starts
            Game.getInstance().chooseWeapon("Gun");
            frame.revalidate();
            frame.repaint();
        });

        nextbutton.addActionListener(e -> {
            boolean gameOver = Game.getInstance().nextRound(); // runs one round of combat
            if (gameOver) {
                nextbutton.setVisible(false); // hides next button when game is over
                applebutton.setVisible(false); // hides apple button when game is over
                restartbutton.setVisible(true); // shows restart button when game is over
            }
            frame.revalidate(); //refreshes UI
            frame.repaint();
        });

        applebutton.addActionListener(e -> {
            Game.getInstance().eatApple(); // tells game to eat apple and boost health
            frame.revalidate(); //refreshes UI
            frame.repaint();
        });

        restartbutton.addActionListener(e -> {
            restartbutton.setVisible(false); // hides restart button
            textArea.setText(""); // clears the text area
            button.setVisible(true); // shows start button again
            Game.getInstance().reset(); // resets the game
            frame.revalidate();
            frame.repaint();
        });

        this.width = w;     //stores width value which was passed in constructor
        this.height = h;    //stores height value which was passed in constructor
    }


    public void showTitleScreen() {//showtitlescreen method which displays ascii art
    String title =
        "  X     X  XXXXX  X        XXXXX    XXXXX   X     X  XXXXX\n" +
        "  X     X  X      X       X        X     X  XX   XX  X    \n" +
        "  X  X  X  XXXX   X       X        X     X  X X X X  XXXX \n" +
        "  X X X X  X      X       X        X     X  X  X  X  X    \n" +
        "   X   X   XXXXX  XXXXX    XXXXX    XXXXX   X     X  XXXXX\n" +


        "                XXXXX   XXXXX\n" +
        "                  X    X     X\n" +
        "                  X    X     X\n" +
        "                  X     XXXXX \n" +


        "  XXXXX  X   X  XXXXX    XXXXX   X   X  X   X   XXXXX  XXXXX   XXXXX  X     X\n" +
        "    X    X   X  X        X    X  X   X  XX  X  X       X      X     X XX    X\n" +
        "    X    XXXXX  XXXX     X    X  X   X  X X X  X  XXX  XXXX   X     X X X   X\n" +
        "    X    X   X  X        X    X  X   X  X  XX  X    X  X      X     X X  X  X\n" +
        "    X    X   X  XXXXX    XXXXX    XXX   X   X   XXXXX  XXXXX   XXXXX  X   XXX\n" +


        "                XXXXX   XXXX   X     X  XXXXX\n" +
        "               X       X    X  XX   XX  X    \n" +
        "               X  XXX  XXXXXX  X X X X  XXXX \n" +
        "               X    X  X    X  X  X  X  X    \n" +
        "                XXXX   X    X  X     X  XXXXX\n";
        //Welcom TO GAME ASCII ART
        textArea.setText(title + "\n"); //basically formats the text so i fits within the area provided
}

    public void setupgui() {    //setipgui method
        frame.setSize(width, height);   //sets size of window from values provided earlier
        frame.setTitle("Dungeon Game"); //shows title of application

       
        JPanel buttonPanel = new JPanel(new FlowLayout());//creates a pannel and adds all the buttons below to it
        buttonPanel.add(button);
        buttonPanel.add(swordbutton);
        buttonPanel.add(gunbutton);
        buttonPanel.add(nextbutton);
        buttonPanel.add(applebutton);
        buttonPanel.add(restartbutton);

        frame.add(new JScrollPane(textArea), BorderLayout.CENTER); // adds scrollable text area to frame
        frame.add(buttonPanel, BorderLayout.SOUTH); // adds buttons at the bottom

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exites the window when user presses x
        frame.setVisible(true); //shows window/ makes the application appear
        showTitleScreen();//shows the titlescreen ascii art
    }

    public void print(String text) {
        textArea.append(text + "\n");   //append adds to what is there so this allows more stuff to be added instead of replaced to the text window
    }
}