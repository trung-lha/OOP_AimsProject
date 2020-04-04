package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	// constructor tittle
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	//constructor title and category
	public DigitalVideoDisc(String  title,String category) {
		super();
		this.title = title;
		this.category = category;
	}
	//title,category,director
	public DigitalVideoDisc(String  title,String category,String director) {
		this(title,category);
		this.director = director;
	}
	//title, categoru, director, length
	public DigitalVideoDisc(String title,String category, String director, int length) {
		this(title, category, director);
		this.length = length;
	}
	//title, category, director, length, cost
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this(title, category, director, length);
		this.cost = cost;
	}
	
	//find out the corresponding disk of the current object contains the title
	public boolean search(String title) {
		int check = 0;
		title = title.toLowerCase().trim();
		String titleCurrentObj = this.title.toLowerCase().trim();
		String[] words = title.split("\\s");
		for(int i = 0;i< words.length;i++) {
			if(titleCurrentObj.contains(words[i]))
				check++;
		}
		if(check == words.length) 
			return true;
		else return false;
	}

}
