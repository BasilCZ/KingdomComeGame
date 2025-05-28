import command.Console;
import loading_and_saving.Load;

public class Main {
    public static void main(String[] args) {
        if(Load.load()){
            Console c = new Console();
            c.start();
        } else {
            System.out.println("Error!");
        }
    }
}