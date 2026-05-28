package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public String getTitle() { return title; }
    public int getLength() { return length; }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing: " + this.getTitle());
            System.out.println("Length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: " + this.getTitle() + " length is non-positive!");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Track)) {
            return false;
        }
        Track other = (Track) o;
        if (this.title != null && other.title != null) {
            return this.title.equalsIgnoreCase(other.title) && this.length == other.length;
        }
        return false;
    }
}