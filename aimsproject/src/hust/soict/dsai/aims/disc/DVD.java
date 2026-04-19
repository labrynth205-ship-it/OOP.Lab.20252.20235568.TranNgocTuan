package hust.soict.dsai.aims.disc;

public class DVD {
    private static int nbDigitalVideoDiscs = 0;
    private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
    public DVD(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public DVD(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public DVD(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public DVD(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    public int getId() {
        return id;
    }
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
	public String getTitle() {
		return title;
	}
    public void setTitle(String title) {
    this.title = title;
    }
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }
    public boolean isMatch(String title) {
        if (this.title == null || title == null) return false;
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}
