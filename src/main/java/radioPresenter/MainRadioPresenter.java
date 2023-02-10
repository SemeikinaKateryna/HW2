package radioPresenter;

import fileSystem.WriteToFileAbility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class MainRadioPresenter extends RadioPresenter implements WriteToFileAbility {
    int workExperience;
    String time;

    public MainRadioPresenter(String name, int workExperience, String time) {
        super(name);
        this.workExperience = workExperience;
        this.time = time;
    }

    @Override
    public String toString() {
        return "MainRadioPresenter\t" +
                "name : " + name +
                ", broadcastings :\n" + broadcastings +
                "\nworkExperience : " + workExperience + " " + time;
    }
    public void writeToFile(){
        try(FileWriter writer = new FileWriter("RadioPresenters.txt", true);
            PrintWriter pw = new PrintWriter(writer)) {
            pw.println("Main Radio presenter\tName : " + this.name);
            String result = Arrays.toString(this.getBroadcastings().toArray())
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", "\n");
            pw.println("Translations :\n" + result );
            pw.println("Work experience : " + this.workExperience + " " + this.time);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
