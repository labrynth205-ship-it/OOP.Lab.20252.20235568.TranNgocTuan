package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    public String getArtist() {
        return artist;
    }
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Added: " + track.getTitle());
        } else {
            System.out.println("Already exists!");
        }
    }
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Deleted: " + track.getTitle());
        } else {
            System.out.println("Not found!");
        }
    }
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public void play() {
        System.out.println("Playing " + this.getTitle());
        System.out.println("Length: " + this.getLength());
        for (Track track: tracks) {
            track.play();
        }
    }
    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - Artist: " + this.getArtist() + " - " + this.getLength() + " mins - " + this.getCost() + " $";
    }
}