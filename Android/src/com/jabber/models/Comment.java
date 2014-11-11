package com.jabber.models;

public class Comment {

	private String content;
	private String timestamp;

	public Comment(String content, String timestamp) {
		super();
		this.content = content;
		this.timestamp = timestamp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Comment [content=" + content + ", timestamp=" + timestamp + "]";
	}
	
	
	
	

}
