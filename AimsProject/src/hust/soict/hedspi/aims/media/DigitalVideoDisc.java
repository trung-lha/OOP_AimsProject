package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media{
	private String director;
	private int length;
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
	// constructor tittle
	public DigitalVideoDisc(String title) {
		super(title);
	}
	//constructor title and category
	public DigitalVideoDisc(int id,String  title,String category) {
		super(id,title,category);
	}
	//title,category,director
	public DigitalVideoDisc(int id,String  title,String category,String director) {
		super(id,title,category);
		this.director = director;
	}
	//constructor full
	public DigitalVideoDisc(int id,String title,String category,String director,int length,float cost) {
		super(id,title, category, cost);
		this.director = director;
		this.length = length;
	}
	public DigitalVideoDisc(String title,String category,String director,int length,float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
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