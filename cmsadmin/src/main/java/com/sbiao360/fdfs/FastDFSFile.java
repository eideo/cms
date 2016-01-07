package com.sbiao360.fdfs;

public class FastDFSFile implements FileManagerConfig{

	private static final long serialVersionUID = 9189219901011983948L;
	
	private String name;
	
	private byte[] content;
	
	private String ext;
	 
	private String width = FILE_DEFAULT_WIDTH;
	
	private String height = FILE_DEFAULT_HEIGHT;
	
	private String author = FILE_DEFAULT_AUTHOR;

	public FastDFSFile(String name, byte[] content, String ext, String width,
			String height, String author) {
		super();
		this.name = name;
		this.content = content;
		this.ext = ext;
		this.width = width;
		this.height = height;
		this.author = author;
	}

	public FastDFSFile(String name, byte[] content, String ext) {
		super();
		this.name = name;
		this.content = content;
		this.ext = ext;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	

}
