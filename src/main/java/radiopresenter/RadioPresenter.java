package radiopresenter;

import broadcasting.Broadcasting;

import java.util.LinkedHashSet;

public abstract class RadioPresenter {
    String name;
    LinkedHashSet<Broadcasting> broadcastings;
    public RadioPresenter(String name) {
        this.name = name;
        broadcastings = new LinkedHashSet<>();
    }
    public void addBroadcasting(Broadcasting broadcasting){
        broadcastings.add(broadcasting);
    }

    public LinkedHashSet<Broadcasting> getBroadcastings() {
        return broadcastings;
    }
}
