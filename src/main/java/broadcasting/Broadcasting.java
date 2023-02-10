package broadcasting;

import fileSystem.WriteToFileAbility;
import parts.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Broadcasting implements WriteToFileAbility {
    int expectedDuration;    // In seconds
    int actualDuration;      // In seconds
    ArrayList<Part> content;
    public Broadcasting(int expectedDuration){
        this.expectedDuration = expectedDuration;
        this.actualDuration = 0;
        content = new ArrayList<>();
    }
    public boolean add (Part elem) {
        if (actualDuration + elem.getDurationInSeconds() <= expectedDuration) {
            content.add(elem);
            actualDuration += elem.getDurationInSeconds();
            if(checkPaidContent()) {
                return true;
            }else{
                content.remove(content.size()-1);
                actualDuration -= elem.getDurationInSeconds();
                return false;
            }
        } else {
            return false;
        }
    }
     private boolean checkPaidContent(){
        int durationOfPaidContent = 0;
        for (Part elem : content) {
            if(!(elem instanceof Song)){
                durationOfPaidContent += elem.getDurationInSeconds();
            }
        }
        double percentOfPaidContent =(double) durationOfPaidContent / expectedDuration;
        if( percentOfPaidContent <= 0.5){
            return true;
        }else{
            return false;
        }

    }
    @Override
    public String toString() {
        return "Broadcasting\t" +
                "duration : " + actualDuration + " seconds\n" +
                content;
    }
    public double getIncome(){
        double income = 0;
        for (Part elem : content) {
            if(!(elem instanceof Song)){
                income += elem.getPricePerSecond() * elem.getDurationInSeconds();
            }
        }
        return income;
    }
    public void writeToFile(){
        try(FileWriter writer = new FileWriter("Broadcasting.txt", true);
            PrintWriter pw = new PrintWriter(writer)) {
            pw.println("Duration : " + this.actualDuration + " seconds");
            pw.println("Content : " + this.content);
            pw.println("Income : " + this.getIncome());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
