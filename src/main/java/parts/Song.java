package parts;

import fileSystem.ReadFromFileAbility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Song extends Part implements ReadFromFileAbility
{
    String artist;
    String name;
    public static final double pricePerSecond = 0;

    public Song() {
        super(0);
    }

    public Song(int durationInSeconds, String artist, String name) {
        super(durationInSeconds);
        this.artist = artist;
        this.name = name;
    }
    @Override
    public double getPricePerSecond(){
        return pricePerSecond;
    }
    @Override
    public String toString() {
        return "Song{" +
                "artist=" + artist +
                "\tname=" + name +
                "\tdurationInSeconds=" + durationInSeconds +
                '}';
    }
    static public List<Song> readFromFile(){
        List<Song> songs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("song.txt"))) {
            var line = "";
            while ((line = br.readLine()) != null) {
                String[] newLines = line.split("-");
                Song temp = new Song();
                temp.durationInSeconds = Integer.parseInt(newLines[0]);
                temp.artist = newLines[1];
                temp.name = newLines[2];
                songs.add(temp);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }
}
