package com.conflictIdentifier.search.modal;

import com.SongsConflictIdentifier.modal.SongsModal;
import com.conflictIdentifier.search.util.Mapper.MapperSingleton;

public class SongsQueue {
	
	public QueueItem[] first = null, last = null;

	public SongsQueue() {
		first = new QueueItem[36];
	}
	
	public SongsQueue(String keyWord, SongsModal modal) {
		this();
		addKeyWord(keyWord, modal);
	}

	public void addKeyWord(String keyWord, SongsModal modal){
		
		char firstChar = keyWord.charAt(0);
		
		QueueItem firstItem = null;
		int index = MapperSingleton.INSTANCE.getInstace().get(firstChar);
		if(first[index] == null)
		{	
			firstItem = new QueueItem();
			firstItem.setFlag(firstChar+"");
			first[index] = firstItem;
		}else{
			firstItem = first[index];
		}
		
		if(keyWord.length() == 1){
			return;
		}

		for (int i = 1; i < keyWord.length(); i++) {
			
			QueueItem newItem = null;
			char c = keyWord.charAt(i);
			if(firstItem.getItem(c) != null){
				newItem = firstItem.getItem(c);			
			}else{
				newItem = new QueueItem();
				newItem.setFlag(c+"");
				firstItem.addItem(newItem);			
			}
			
			if(i == keyWord.length()){
				newItem.addSongModal(modal);
			}
			
		}
	}

	public static void main(String[] args){
		
		SongsQueue myQueue = new SongsQueue();
		
	}
}
