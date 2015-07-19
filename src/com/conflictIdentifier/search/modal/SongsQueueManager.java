package com.conflictIdentifier.search.modal;

import java.io.IOException;

import com.SongsConflictIdentifier.modal.SongsModal;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;

public class SongsQueueManager {

	public SongsQueueManager() {
	}

	public void search(SongsModal modal){
		String artist = modal.getArtist();
		String[] array = modal.getArtist().split(" ");
		
		SongsQueue queue=new SongsQueue(array[0], modal);
		artist = array[1];
		queue.addKeyWord(array[1], modal);
	}
	
	public static void main(String[] args) throws Exception, InvalidDataException, IOException {

		SongsModal firstSong = new SongsModal();
		firstSong.setSongId("1");
		
		String songPath = "F:\\Songs\\";
		firstSong.setSongPath(songPath);
		
		String songName = "Hanuman chalisha.mp3";
		firstSong.setFileName("Hanuman chalisha");
		
		Mp3File mp3file = new Mp3File(songPath+songName);
		
		//readGatterMathod(ID3v1.class, mp3file.getId3v1Tag());
		firstSong.setAlbum(mp3file.getId3v1Tag().getAlbum());
		firstSong.setArtist(mp3file.getId3v1Tag().getArtist());
		firstSong.setComment(mp3file.getId3v1Tag().getComment());
		firstSong.setGenre(mp3file.getId3v1Tag().getGenre());
		firstSong.setGenreDescription(mp3file.getId3v1Tag().getGenreDescription());
		firstSong.setTitle(mp3file.getId3v1Tag().getTitle());
		firstSong.setTrack(mp3file.getId3v1Tag().getTrack());
		firstSong.setYear(mp3file.getId3v1Tag().getYear());
		
		//readGatterMathod(ID3v2.class, mp3file.getId3v2Tag());
		firstSong.setAlbumArtist(mp3file.getId3v2Tag().getAlbumArtist());
		
		if (mp3file.hasId3v2Tag()){
			
		     ID3v2 id3v2tag = mp3file.getId3v2Tag();
		     byte[] imageData = id3v2tag.getAlbumImage();
		     //converting the bytes to an image
		     //BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
		}
		
		SongsQueueManager qm=new SongsQueueManager();
		qm.search(firstSong);
	}

}
