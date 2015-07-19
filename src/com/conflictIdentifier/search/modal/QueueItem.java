package com.conflictIdentifier.search.modal;

import java.util.LinkedHashMap;
import java.util.Map;

import com.SongsConflictIdentifier.modal.SongsModal;
import com.conflictIdentifier.search.util.Mapper.MapperSingleton;

public class QueueItem {

	public String flag = null;
	public Map<String,SongsModal> leaf = null;
	public QueueItem[] range= new QueueItem[36];
	
	public QueueItem() {
		leaf = new LinkedHashMap<String,SongsModal>();
	}
	
	public void addSongModal(SongsModal modal){
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
	
	public void addItem(QueueItem newItem){
		int index = MapperSingleton.INSTANCE.getInstace().get(newItem.getFlag().charAt(0));
		if(range[index] != null){
			
		}else{
			range[index] = newItem;
		}
	}
	
	public QueueItem getItem(char c){
		int index = MapperSingleton.INSTANCE.getInstace().get(c);
		return range[index];
	}
}
