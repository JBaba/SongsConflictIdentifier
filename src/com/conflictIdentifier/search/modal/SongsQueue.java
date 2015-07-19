package com.conflictIdentifier.search.modal;

import com.SongsConflictIdentifier.modal.SongsModal;
import com.conflictIdentifier.search.util.Mapper.MapperSingleton;

/**
 * Structure for songs comparison 
 * @author naimish
 *
 */
public class SongsQueue {
	
	public QueueItem[] first = null; // first node

	public SongsQueue() {
		first = new QueueItem[36];
	}
	
	public SongsQueue(String keyWord, SongsModal modal) {
		this();
		addKeyWord(keyWord, modal);
	}

	/**
	 * Build structure based on key word
	 * @param keyWord
	 * @param modal
	 */
	public void addKeyWord(String keyWord, SongsModal modal){
		
		// find first char 
		// place in queue [A-Z or 0-9] based on index form mapper object 
		char firstChar = keyWord.charAt(0);
		
		QueueItem firstItem = null;
		// get index
		int index = MapperSingleton.INSTANCE.getInstace().get(firstChar);
		
		// if index is empty then add new
		if(first[index] == null)
		{	
			firstItem = new QueueItem();
			firstItem.setFlag(firstChar+"");
			first[index] = firstItem;
		}else{
			firstItem = first[index];
		}
		
		// ignore keyword which is less then size 1
		if(keyWord.length() == 1){
			return;
		}

		// append or build structure based on keyword
		for (int i = 1; i < keyWord.length(); i++) {
			
			QueueItem newItem = null;
			char c = keyWord.charAt(i);
			Character upperCase = Character.toUpperCase(c);
			// only consider A-Z or 0-9
			if( ( upperCase > 65 && upperCase < 90 )  || ( upperCase > 48 && upperCase < 57 ) ){
			
				if(firstItem.getItem(c) != null){
					newItem = firstItem.getItem(c);			
				}else{
					// create new
					newItem = new QueueItem();
					newItem.setFlag(c+"");
					firstItem.addItem(newItem);
				}
				
				// add songs in list
				if(i == keyWord.length()){
					newItem.addSongModal(modal);
				}
				// switch place
				firstItem = newItem;
			}
		}
	}

}
