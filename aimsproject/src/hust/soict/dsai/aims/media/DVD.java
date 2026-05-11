package hust.soict.dsai.aims.media;

public class DVD extends Disc implements Playable{
    private static int nbDigitalVideoDiscs = 0;

    public DVD(String title) {
        super();
        this.setTitle(title);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DVD(String category, String title, float cost) {
        super();
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DVD(String director, String category, String title, float cost) {
        super();
        this.setDirector(director);
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    public DVD(String title, String category, String director, int length, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setLength(length);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    @Override
    public void play() {
        System.out.println("Playing " + this.getTitle());
        System.out.println("Length: " + this.getLength());
    }
}