package com.mpatric.mp3agic;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * An IOUtils as in commons.io
 * with methods contentEquals and closeQuietly
 *
 */
public class IOUtils {
	
	/**
	 * Represents the end-of-file (or stream).
	 */
	public static final int EOF = -1;

	/**
	 * Compares the content of two Streams to determine if they are equals or
	 * not.
	 * 
	 * This method buffers the input internally using
	 * <code>BufferedInputStream</code> if they are not already buffered.
	 * rows
	 * @param input1
	 *            the first stream
	 * @param input2
	 *            the second stream
	 * @return true if the content of the streams are equal
	 * @throws NullPointerException
	 *             if either input is null
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static boolean contentEquals(InputStream input1, InputStream input2) throws IOException {
		if (input1 == input2) {
			return true;
		}
		
		if (!(input1 instanceof BufferedInputStream)) {
			input1 = new BufferedInputStream(input1);
		}
		
		if (!(input2 instanceof BufferedInputStream)) {
			input2 = new BufferedInputStream(input2);
		}
		
		int ch = input1.read();
		while(EOF != ch) {
			final int ch2 = input2.read();
			if (ch != ch2) {
				return false;
			}
			ch = input1.read();
		}
		
		final int ch2 = input2.read();
		return ch2 == EOF;
		
	}
	
	/**
	 * Closing an <code>InputStream</code> quietly
	 * by calling <code>closeQuietly(Closeable)</code>
	 * 
	 * @param input
	 */
	public static void closeQuietly(final InputStream input) {
		closeQuietly((Closeable) input);
	}
	
	/**
	 * Closing an <code>Closeable</code> quietly
	 * i.e. no IOException handling
	 * 
	 * @param closeable
	 */
	public static void closeQuietly(final Closeable closeable) {
		try {
			if (closeable != null) {
				closeable.close();
			}
		} catch (final IOException ioe) {
			// ignore
		}
	}

}
