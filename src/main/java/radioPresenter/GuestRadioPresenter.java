package radioPresenter;

import fileSystem.WriteToFileAbility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class GuestRadioPresenter extends RadioPresenter implements WriteToFileAbility {
    String cv;
    public GuestRadioPresenter(String name, String cv) {
        super(name);
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "GuestRadioPresenter\t" +
                "name : " + name +
                ", broadcastings :\n" + broadcastings +
                "\ncv : " + cv ;
    }
    public void writeToFile(){
        try(FileWriter writer = new FileWriter("RadioPresenters.txt", true);
            PrintWriter pw = new PrintWriter(writer)) {
            pw.println("Guest Radio presenter\tName : " + this.name);
            String result = Arrays.toString(this.getBroadcastings().toArray())
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", "\n");
            pw.println("Translations :\n" + result );
            pw.println("CV : " + this.cv);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
