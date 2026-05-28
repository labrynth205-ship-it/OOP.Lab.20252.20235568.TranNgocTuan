package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title, String category, String artist, float cost, String director) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.artist = artist; 
        this.setDirector(director);
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
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD " + this.getTitle() + " length is non-positive!");
        }
    }
    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - Artist: " + this.getArtist() + " - " + this.getLength() + " mins - " + this.getCost() + " $";
    }
}