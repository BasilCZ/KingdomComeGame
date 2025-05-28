package loading_and_saving;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save {
    public static boolean save(){
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("save.txt"));
            //Add saving
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
