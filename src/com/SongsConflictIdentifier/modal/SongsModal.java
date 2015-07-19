package com.SongsConflictIdentifier.modal;

import java.io.Serializable;

public class SongsModal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4926680570918843924L;

	private String songPath = "";
	private String songId = "";
	private String fileName = "";
	private String track = null;
	private String artist = null;
	private String title = null;
	private String album = null;
	private String year = null;
	private int genre = -1;
	private String comment = null;
	private String genreDescription = null;
	private String AlbumArtist  = null;
	private String BufferedImage  = null;  
	private String AlbumImageMimeType  = null; 
	private String ArtistUrl  = null; 
	private String AudioSourceUrl  = null;  
    private String AudiofileUrl  = null;  
    private String ChapterTOC  = null;  
    private String Chapters  = null; 
    private String CommercialUrl  = null; 
    private String isCompilation   = null;
    private String Composer  = null; 
    private String Copyright  = null; 
    private String CopyrightUrl  = null;  
    private String DataLength  = null;
    private String Date  = null;  
    private String Encoder  = null;
    private String Grouping = null;  
    private String ItunesComment = null;  
    private String Key = null;  
    private String Length = null;
    private String ObseleteFormat = null;
    private String OriginalArtist = null;  
    private String Padding = null;
    private String PartOfSet = null; 
    private String PaymentUrl = null; 
    private String Publisher = null; 
    private String PublisherUrl = null;  
    private String RadiostationUrl = null; 
    private String Url = null; 
	
	public SongsModal() {
		// TODO Auto-generated constructor stub
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSongPath() {
		return songPath;
	}

	public void setSongPath(String songPath) {
		this.songPath = songPath;
	}

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getGenreDescription() {
		return genreDescription;
	}

	public void setGenreDescription(String genreDescription) {
		this.genreDescription = genreDescription;
	}

	public String getAlbumArtist() {
		return AlbumArtist;
	}

	public void setAlbumArtist(String albumArtist) {
		AlbumArtist = albumArtist;
	}

	public String getBufferedImage() {
		return BufferedImage;
	}

	public void setBufferedImage(String bufferedImage) {
		BufferedImage = bufferedImage;
	}

	public String getAlbumImageMimeType() {
		return AlbumImageMimeType;
	}

	public void setAlbumImageMimeType(String albumImageMimeType) {
		AlbumImageMimeType = albumImageMimeType;
	}

	public String getArtistUrl() {
		return ArtistUrl;
	}

	public void setArtistUrl(String artistUrl) {
		ArtistUrl = artistUrl;
	}

	public String getAudioSourceUrl() {
		return AudioSourceUrl;
	}

	public void setAudioSourceUrl(String audioSourceUrl) {
		AudioSourceUrl = audioSourceUrl;
	}

	public String getAudiofileUrl() {
		return AudiofileUrl;
	}

	public void setAudiofileUrl(String audiofileUrl) {
		AudiofileUrl = audiofileUrl;
	}

	public String getChapterTOC() {
		return ChapterTOC;
	}

	public void setChapterTOC(String chapterTOC) {
		ChapterTOC = chapterTOC;
	}

	public String getChapters() {
		return Chapters;
	}

	public void setChapters(String chapters) {
		Chapters = chapters;
	}

	public String getCommercialUrl() {
		return CommercialUrl;
	}

	public void setCommercialUrl(String commercialUrl) {
		CommercialUrl = commercialUrl;
	}

	public String getIsCompilation() {
		return isCompilation;
	}

	public void setIsCompilation(String isCompilation) {
		this.isCompilation = isCompilation;
	}

	public String getComposer() {
		return Composer;
	}

	public void setComposer(String composer) {
		Composer = composer;
	}

	public String getCopyright() {
		return Copyright;
	}

	public void setCopyright(String copyright) {
		Copyright = copyright;
	}

	public String getCopyrightUrl() {
		return CopyrightUrl;
	}

	public void setCopyrightUrl(String copyrightUrl) {
		CopyrightUrl = copyrightUrl;
	}

	public String getDataLength() {
		return DataLength;
	}

	public void setDataLength(String dataLength) {
		DataLength = dataLength;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getEncoder() {
		return Encoder;
	}

	public void setEncoder(String encoder) {
		Encoder = encoder;
	}

	public String getGrouping() {
		return Grouping;
	}

	public void setGrouping(String grouping) {
		Grouping = grouping;
	}

	public String getItunesComment() {
		return ItunesComment;
	}

	public void setItunesComment(String itunesComment) {
		ItunesComment = itunesComment;
	}

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	public String getLength() {
		return Length;
	}

	public void setLength(String length) {
		Length = length;
	}

	public String getObseleteFormat() {
		return ObseleteFormat;
	}

	public void setObseleteFormat(String obseleteFormat) {
		ObseleteFormat = obseleteFormat;
	}

	public String getOriginalArtist() {
		return OriginalArtist;
	}

	public void setOriginalArtist(String originalArtist) {
		OriginalArtist = originalArtist;
	}

	public String getPadding() {
		return Padding;
	}

	public void setPadding(String padding) {
		Padding = padding;
	}

	public String getPartOfSet() {
		return PartOfSet;
	}

	public void setPartOfSet(String partOfSet) {
		PartOfSet = partOfSet;
	}

	public String getPaymentUrl() {
		return PaymentUrl;
	}

	public void setPaymentUrl(String paymentUrl) {
		PaymentUrl = paymentUrl;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getPublisherUrl() {
		return PublisherUrl;
	}

	public void setPublisherUrl(String publisherUrl) {
		PublisherUrl = publisherUrl;
	}

	public String getRadiostationUrl() {
		return RadiostationUrl;
	}

	public void setRadiostationUrl(String radiostationUrl) {
		RadiostationUrl = radiostationUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
	
	
	
}
