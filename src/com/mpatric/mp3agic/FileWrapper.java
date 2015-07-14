package com.mpatric.mp3agic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileWrapper {
	
	protected File file;
	protected long length;
	protected long lastModified;
	
	protected FileWrapper() {
	}

	public FileWrapper(String filename) throws IOException {
		this.file = new File(filename);
		init();
	}
	
	public FileWrapper(File file) throws IOException {
		if (file == null) throw new NullPointerException();
		this.file = file;
		init();
	}
	
	private void init() throws IOException {
		if (!file.exists()) throw new FileNotFoundException("File not found " + file.getPath());
		if (!file.canRead()) throw new IOException("File not readable");
		length = file.length();
		lastModified = file.lastModified();
	}
	
	public String getFilename() {
		return file.getPath();
	}

	public long getLength() {
		return length;
	}

	public long getLastModified() {
		return lastModified;
	}
	
	/**
	 * contentEquals check if the file hold in FileWrapper has content equals to file hold in another FileWrapper
	 * return true if contents are the same or both file does not exist, false otherwise
	 * 
	 * @param filew
	 * @return
	 * @throws IOException 
	 */
	public boolean contentEquals(FileWrapper filew) throws IOException {
		
		final boolean file1Exists = this.file.exists();
		if (file1Exists != filew.file.exists()) {
			return false;
		}

		if (!file1Exists) {
			// if both does not exist, return true
			return true;
		}

		if (this.file.isDirectory() || filew.file.isDirectory()) {
			// don't want to compare directory contents
			throw new IOException("Can't compare directories, only files");
		}
		
		if (this.length != filew.length) {
			// lengths differ, cannot be equal
			return false;
		}
		
		if (this.file.getCanonicalFile().equals(filew.file.getCanonicalFile())) {
			// same file
			return true;
		}
		
		InputStream input1 = null;
		InputStream input2 = null;
		try {
			input1 = new FileInputStream(this.file);
			input2 = new FileInputStream(filew.file);
			return IOUtils.contentEquals(input1, input2);
		} finally {
			IOUtils.closeQuietly(input1);
			IOUtils.closeQuietly(input2);
	}
	}
}
