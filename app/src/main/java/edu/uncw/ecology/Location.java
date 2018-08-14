package edu.uncw.ecology;

import org.parceler.Parcel;

@Parcel
public class Location {

    public static final Location[] locations = {
            new Location("Venus Flytrap", "https://sites.google.com/site/islandecologyuncw2016/terrestrial-flora/venus-fly-trap"),
            new Location("Bladderwort", "https://sites.google.com/site/islandecologyuncw2016/terrestrial-flora/bladderwort-1"),
            new Location("Longleaf Pine", "https://sites.google.com/site/islandecologyuncw2016/terrestrial-flora/long-leaf-pine"),
            new Location("Eastern Screech Owl", "https://sites.google.com/site/islandecologyuncw2016/impacts-of-terrestrial-fauna/eastern-screech-owl"),
            new Location("Sundew", "https://sites.google.com/site/islandecologyuncw2016/sundew"),
    };

    String title;
    String url;


    public Location() {

    }

    public Location(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return title;
    }
}
