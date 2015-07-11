package com.conflictIdentifier.test;

import java.awt.image.BufferedImage;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.imageio.ImageIO;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

public class MyTest {
	
	public static void main(String[] args) throws UnsupportedTagException, InvalidDataException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
		String songPath = "E:\\My Song\\";
		String songName = "Hanuman chalisha.mp3";
		Mp3File mp3file = new Mp3File(songPath+songName);
		System.out.println(mp3file.getChannelMode());
		System.out.println("Length of this mp3 is: " + mp3file.getLengthInSeconds() + " seconds");
		System.out.println("Bitrate: " + mp3file.getBitrate() + " kbps " + (mp3file.isVbr() ? "(VBR)" : "(CBR)"));
		System.out.println("Sample rate: " + mp3file.getSampleRate() + " Hz");
	
		System.out.println("Has ID3v1 tag?: " + (mp3file.hasId3v1Tag() ? "YES" : "NO"));
		System.out.println("Has ID3v2 tag?: " + (mp3file.hasId3v2Tag() ? "YES" : "NO"));
		System.out.println("Has custom tag?: " + (mp3file.hasCustomTag() ? "YES" : "NO"));
		
		readGatterMathod(ID3v1.class, mp3file.getId3v1Tag());
		readGatterMathod(ID3v2.class, mp3file.getId3v2Tag());
		
		if (mp3file.hasId3v2Tag()){
			
		     ID3v2 id3v2tag = mp3file.getId3v2Tag();
		     byte[] imageData = id3v2tag.getAlbumImage();
		     //converting the bytes to an image
		     //BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
		}
	}

	/**
	 * reads all getter method
	 * @param aClass
	 * @param aObject
	 * @throws Exception
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void readGatterMathod(Class<?> aClass,Object aObject) throws Exception, IllegalArgumentException, InvocationTargetException{
		for(PropertyDescriptor propertyDescriptor : 
		    Introspector.getBeanInfo(aClass).getPropertyDescriptors()){
			// if there is no read method then bypass this block
			if(propertyDescriptor.getReadMethod() != null){
				// get name of name method
			    System.out.print("\n"+propertyDescriptor.getReadMethod().getName().replace("get", ""));
			    // get only those method which argument is  0
			    if(propertyDescriptor.getReadMethod().getParameterCount() == 0 ){
			    	Object printO = propertyDescriptor.getReadMethod().invoke(aObject, null);
			    	printO = (printO != null) ? printO : "";
			    	System.out.print("  :  "+ printO);
			    }
			}
		}
	}
}
