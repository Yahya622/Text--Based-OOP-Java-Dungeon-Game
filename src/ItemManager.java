import java.io.*;

public class ItemManager {  //item manager class

    private static final String FILE = "resources/items.json"; // saves the file path in resources to read from

    public static void saveApple(int count) {   //save apple method
        try {   //try catch used incase file not found or any other error which makes it not possible to write in the file
            FileWriter writer = new FileWriter(FILE);   //opens the json file
            writer.write("{\"goldenApples\": " + count + "}"); // saves apple count to json by writing how many apples there are
            writer.close(); //stops writing and closes the json file
        } catch (IOException apple) {   //IO Exception used incase file cannot be written in
            System.out.println("Could not save apple"); //failed printing msg
        }
    }

    public static int loadApples() {    //loadapples method
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE));   //opens json file to read how many apples are available
            String line = reader.readLine();//Reads first line on file
            reader.close(); //closes file after reading
            line = line.replace("{\"goldenApples\": ", "").replace("}", ""); // extracts the number by removing everything else
            return Integer.parseInt(line.trim());   //converts the string into an int so it can return it
        } catch (IOException e) {
            return 0; // no apples if file doesnt exist or isnt found
        }
    }
}