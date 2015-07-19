package com.conflictIdentifier.search.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Mapper {

	Map<Character,Integer> myMapping = null;
	
	private Mapper() {
		myMapping = new LinkedHashMap<Character, Integer>();
		init();
	}
	
	public enum MapperSingleton {
		
		INSTANCE;
		
		private static final Mapper mapper=new Mapper();
		
		public Mapper getInstace(){
			return mapper;
		}
		
	}
	
	private void init(){
		myMapping.put('A', 0);
		myMapping.put('B', 1);
		myMapping.put('C', 2);
		myMapping.put('D', 3);
		myMapping.put('E', 4);
		myMapping.put('F', 5);
		myMapping.put('G', 6);
		myMapping.put('H', 7);
		myMapping.put('I', 8);
		myMapping.put('J', 9);
		myMapping.put('K', 10);
		myMapping.put('L', 11);
		myMapping.put('M', 12);
		myMapping.put('N', 13);
		myMapping.put('O', 14);
		myMapping.put('P', 15);
		myMapping.put('Q', 16);
		myMapping.put('R', 17);
		myMapping.put('S', 18);
		myMapping.put('T', 19);
		myMapping.put('U', 20);
		myMapping.put('V', 21);
		myMapping.put('W', 22);
		myMapping.put('X', 23);
		myMapping.put('Y', 24);
		myMapping.put('Z', 25);

		myMapping.put('0', 26);
		myMapping.put('1', 27);
		myMapping.put('2', 28);
		myMapping.put('3', 29);
		myMapping.put('4', 30);
		myMapping.put('5', 31);
		myMapping.put('6', 32);
		myMapping.put('7', 33);
		myMapping.put('8', 34);
		myMapping.put('9', 35);
	}
	
	public int get(Character c){
		return myMapping.get(c.toUpperCase(c));
	}
}
