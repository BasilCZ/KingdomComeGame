import command.Console;
import loading_and_saving.LoadGame;

public class Main {
    public static void main(String[] args) {
        if(LoadGame.load()){
            Console c = new Console();
            c.start();
        } else {
            System.out.println("Error!");
        }
    }
}