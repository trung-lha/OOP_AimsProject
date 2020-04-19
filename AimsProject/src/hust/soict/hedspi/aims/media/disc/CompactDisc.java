package hust.soict.hedspi.aims.media.disc;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	ArrayList<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	public CompactDisc(int id,String title,String category,float cost,int length,String director,String artist) {
		super(id,title,category,cost,length,director);
		this.artist = artist;
	}
	public CompactDisc(int id,String title,String category,float cost,int length,String director,String artist,ArrayList<Track> tracks) {
		super(id,title,category,cost,length,director);
		this.length = getLength();
		this.artist = artist;
		this.tracks = tracks;
	}
	public void addTrack(Track track) {
		int checkExist = 0;
		for(Track checkTrack : tracks) {
			if(checkTrack.getTitle() == track.getTitle())
				checkExist = 1;
		}
		if(checkExist == 1) {
			System.err.println("The track want to add is exist");
			return;
		}
		else {
			tracks.add(track);
		}
	}
	public void removeTrack(Track track) {
		int checkExist = 0;
		for(Track checkTrack : tracks) {
			if(checkTrack.getTitle() == track.getTitle())
				checkExist = 1;
		}
		if(checkExist == 0) {
			System.err.println("The track want to remove is not exist");
			return;
		}
		else {
			tracks.remove(track);
		}
	}
	public int getLength() {
		int totalLength = 0;
		for(Track track: tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	public void play() {
		System.out.println("CompactDisc's name: "+this.getTitle());
		for(Track track : tracks) {
			track.play();
		}
		System.out.println("Length of CD: "+this.getLength());
		System.out.println("---------------------------------");
	}

}
