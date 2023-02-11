package parts;

import filesystem.ReadFromFileAbility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Interview extends Part implements ReadFromFileAbility
{
    String guest;
    public static final double pricePerSecond = 0.5;

    public Interview() {
        super(0);
    }

    public Interview(int durationInSeconds, String guest) {
        super(durationInSeconds);
        this.guest = guest;
    }
    @Override
    public double getPricePerSecond(){
        return pricePerSecond;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "guest=" + guest +
                "\tdurationInSeconds=" + durationInSeconds +
                '}';
    }
    static public List<Interview> readFromFile(){
        List<Interview> interviews = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("interview.txt"))) {
            var line = "";
            while ((line = br.readLine()) != null) {
                String[] newLines = line.split("-");
                Interview temp = new Interview();
                temp.durationInSeconds = Integer.parseInt(newLines[0]);
                temp.guest = newLines[1];
                interviews.add(temp);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return interviews;
    }
}
