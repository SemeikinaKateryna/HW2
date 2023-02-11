package main;

import broadcasting.Broadcasting;
import parts.*;
import radiopresenter.GuestRadioPresenter;
import radiopresenter.MainRadioPresenter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ad> ads = Ad.readFromFile();
        System.out.println(ads);
        List<Interview> interviews = Interview.readFromFile();
        System.out.println(interviews);
        List<Song> songs = Song.readFromFile();
        System.out.println(songs);

        Broadcasting broadcasting = new Broadcasting(1000);
        broadcasting.add(songs.get(1));
        broadcasting.add(ads.get(1));
        broadcasting.add(interviews.get(1));
        broadcasting.add(songs.get(2));
        broadcasting.add(ads.get(2));
        broadcasting.add(songs.get(3));
        broadcasting.add(ads.get(3));
        broadcasting.add(interviews.get(2));
        broadcasting.writeToFile();

        Broadcasting broadcasting2 = new Broadcasting(800);
        broadcasting2.add(songs.get(2));
        broadcasting2.add(ads.get(2));
        broadcasting2.add(interviews.get(1));
        broadcasting2.add(songs.get(3));
        broadcasting2.add(ads.get(2));
        broadcasting2.add(interviews.get(2));
        broadcasting2.add(songs.get(3));
        broadcasting2.writeToFile();

        MainRadioPresenter radioPresenter1
                = new MainRadioPresenter("MC Dusya",12, "months");
        radioPresenter1.addBroadcasting(broadcasting);
        radioPresenter1.addBroadcasting(broadcasting2);
        radioPresenter1.writeToFile();

        GuestRadioPresenter radioPresenter2 = new GuestRadioPresenter("Vova",
                "I'm 21 year old, funny and smart");
        radioPresenter2.addBroadcasting(broadcasting);
        radioPresenter2.writeToFile();

    }
}
