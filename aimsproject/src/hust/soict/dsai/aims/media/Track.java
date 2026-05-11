package hust.soict.dsai.aims.media;

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
    public void play() {
        System.out.println("Playing " + this.getTitle());
        System.out.println("Length: " + this.getLength());
    }
}