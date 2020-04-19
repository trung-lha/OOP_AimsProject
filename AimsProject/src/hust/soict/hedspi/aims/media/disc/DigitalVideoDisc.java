package hust.soict.hedspi.aims.media.disc;

public class DigitalVideoDisc extends Disc implements Playable{
	//constructor
	public DigitalVideoDisc(int id,String title,String category,float cost,int length,String director) {
		super(id,title,category,cost,length,director);
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
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		System.out.println("--------------------------------");
	}
}