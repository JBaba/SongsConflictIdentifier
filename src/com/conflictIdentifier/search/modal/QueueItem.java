package com.conflictIdentifier.search.modal;

import java.util.LinkedHashMap;
import java.util.Map;

import com.SongsConflictIdentifier.modal.SongsModal;
import com.conflictIdentifier.search.util.Mapper.MapperSingleton;

/**
 * this is item for my structure
 * @author naimish
 *
 */
public class QueueItem {

	// has flag which represents charater 
	public String flag = null;
	// left had value 
	public Map<String,SongsModal> leaf = null;
	// reference to sub elements 
	public QueueItem[] range= new QueueItem[36];
	
	public QueueItem() {
		leaf = new LinkedHashMap<String,SongsModal>();
	}
	
	/**
	 * add songs
	 * @param modal
	 */
	public void addSongModal(SongsModal modal){
		// id is not in list
		if(!leaf.containsKey(modal.getSongId())){
			leaf.put(modal.getSongId(), modal);
		}
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * add item on index
	 * @param newItem
	 */
	public void addItem(QueueItem newItem){
		// get index
		int index = MapperSingleton.INSTANCE.getInstace().get(newItem.getFlag().charAt(0));
		if(range[index] != null){
			
		}else{
			range[index] = newItem;
		}
	}
	
	/**
	 * get item based on index
	 * @param c
	 * @return
	 */
	public QueueItem getItem(char c){
		int index = MapperSingleton.INSTANCE.getInstace().get(c);
		return range[index];
	}
}
