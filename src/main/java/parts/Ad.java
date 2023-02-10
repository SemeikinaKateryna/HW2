package parts;

import fileSystem.ReadFromFileAbility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ad extends Part implements ReadFromFileAbility {
    String product;
    public static final double pricePerSecond = 5;
    public Ad(int durationInSeconds, String product) {
        super(durationInSeconds);
        this.product = product;
    }

    public Ad() {
        super(0);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "product=" + product +
                "\tdurationInSeconds=" + durationInSeconds +
                '}';
    }

    @Override
    public double getPricePerSecond(){
        return pricePerSecond;
    }
    static public List<Ad> readFromFile(){
        List<Ad> ads = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ad.txt"))) {
            var line = "";
            while ((line = br.readLine()) != null) {
                String[] newLines = line.split("-");
                Ad temp = new Ad();
                temp.durationInSeconds = Integer.parseInt(newLines[0]);
                temp.product = newLines[1];
                ads.add(temp);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ads;
    }
}
