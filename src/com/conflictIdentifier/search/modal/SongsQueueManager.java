package com.conflictIdentifier.search.modal;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.SongsConflictIdentifier.modal.SongsModal;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

/**
 * Manages/Builds queues to compare  
 * @author naimish
 *
 */
public class SongsQueueManager {

	// queue
	SongsQueue queue = new SongsQueue();
	List<String> ignoreList = null;
	// songs id
	int songId = 1;
	
	public SongsQueueManager() {
		ignoreList = new LinkedList<String>();
		ignoreList.add("(Remix)");
		ignoreList.add("[www.DJMaza.Com]");
		ignoreList.add("Mp3HunGama.Com");
		ignoreList.add("@");
	}

	/**
	 * Search songs by artist
	 * 
	 * @param modal
	 */
	public SongsQueue searchByArtist(SongsModal modal) {
		System.out.println(modal.getTitle());
		String[] array = modal.getTitle().split(" ");
		for (int i = 0; i < array.length; i++) {
			// ignore some keywords and if length is more then 0 then proceed
			if(!ignoreList.contains(array[i]) && array[i].length() != 0){
				queue.addKeyWord(array[i], modal);
			}
		}
		return queue;
	}

	/**
	 * List of files in folder
	 * @param folderPath
	 * @throws IOException 
	 * @throws InvalidDataException 
	 * @throws UnsupportedTagException 
	 */
	public void loadSongsOnFolder(String folderPath) throws UnsupportedTagException, InvalidDataException, IOException {
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				//System.out.println("File " + listOfFiles[i].getName());
				buildSongsModal(listOfFiles[i]);
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
	}
	
	/**
	 * Build songsmodal and push into queue to build structure 
	 * @param file
	 * @throws UnsupportedTagException
	 * @throws InvalidDataException
	 * @throws IOException
	 */
	public void buildSongsModal(File file) throws UnsupportedTagException, InvalidDataException, IOException{
		SongsModal firstSong = new SongsModal();
		firstSong.setSongId((songId++) + "");
		firstSong.setSongPath(file.getAbsolutePath());
		firstSong.setFileName(file.getName());
		
		Mp3File mp3file = new Mp3File(file.getAbsolutePath());

		// readGatterMathod(ID3v1.class, mp3file.getId3v1Tag());
		if(mp3file.getId3v1Tag() != null){
			firstSong.setAlbum(mp3file.getId3v1Tag().getAlbum());
			firstSong.setArtist(mp3file.getId3v1Tag().getArtist());
			firstSong.setComment(mp3file.getId3v1Tag().getComment());
			firstSong.setGenre(mp3file.getId3v1Tag().getGenre());
			firstSong.setGenreDescription(mp3file.getId3v1Tag()
					.getGenreDescription());
			firstSong.setTitle(mp3file.getId3v1Tag().getTitle());
			firstSong.setTrack(mp3file.getId3v1Tag().getTrack());
			firstSong.setYear(mp3file.getId3v1Tag().getYear());
			
			searchByArtist(firstSong);
		}else{
			System.out.println("No Id3v1Tag");
		}
		// readGatterMathod(ID3v2.class, mp3file.getId3v2Tag());
		if(mp3file.getId3v2Tag() != null){	
			firstSong.setAlbumArtist(mp3file.getId3v2Tag().getAlbumArtist());
			
			//searchByArtist(firstSong);
		}else{
			System.out.println("No Id3v2Tag");
		}
		
	}
	

	public static void main(String[] args) throws Exception,
			InvalidDataException, IOException {
		
		/*SongsModal firstSong = new SongsModal();
		firstSong.setSongId("1");

		String songPath = "F:\\Songs\\";
		firstSong.setSongPath(songPath);

		String songName = "Hanuman chalisha.mp3";
		firstSong.setFileName("Hanuman chalisha");

		Mp3File mp3file = new Mp3File(songPath + songName);

		// readGatterMathod(ID3v1.class, mp3file.getId3v1Tag());
		firstSong.setAlbum(mp3file.getId3v1Tag().getAlbum());
		firstSong.setArtist(mp3file.getId3v1Tag().getArtist());
		firstSong.setComment(mp3file.getId3v1Tag().getComment());
		firstSong.setGenre(mp3file.getId3v1Tag().getGenre());
		firstSong.setGenreDescription(mp3file.getId3v1Tag()
				.getGenreDescription());
		firstSong.setTitle(mp3file.getId3v1Tag().getTitle());
		firstSong.setTrack(mp3file.getId3v1Tag().getTrack());
		firstSong.setYear(mp3file.getId3v1Tag().getYear());

		// readGatterMathod(ID3v2.class, mp3file.getId3v2Tag());
		firstSong.setAlbumArtist(mp3file.getId3v2Tag().getAlbumArtist());

		if (mp3file.hasId3v2Tag()) {

			ID3v2 id3v2tag = mp3file.getId3v2Tag();
			byte[] imageData = id3v2tag.getAlbumImage();
			// converting the bytes to an image
			// BufferedImage img = ImageIO.read(new
			// ByteArrayInputStream(imageData));
		}
	*/
		SongsQueueManager qm = new SongsQueueManager();
		//qm.searchByArtist(firstSong);
		qm.loadSongsOnFolder("F:\\Songs\\Naimish");
		//System.out.println((int)'A' + " " + (int)'Z' + " " + (int)'a' + " " + (int)'z' + " " + (int)'0' + " " + (int)'');
	}

}
