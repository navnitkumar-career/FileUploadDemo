package com.file.payload;

public class FileResponce {

	private  String fileName;
	private   String message;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public FileResponce(String fileName, String message) {
		super();
		this.fileName = fileName;
		this.message = message;
	}
	public FileResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
