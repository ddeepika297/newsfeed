package com.Intuit.socialNewsFeed.model;

import java.time.Instant;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Post {

	public Post(String postCreatorID, String content, String url, Instant creationDateTime, CategoryEnum category) {
		super();
		this.postCreatorID = postCreatorID;
		this.content = content;
		this.url = url;
		this.creationDateTime = creationDateTime;
		this.category = category;
	}

	final String postId = UUID.randomUUID().toString().substring(0, 8);
	String postCreatorID;
	String content;
	String url;
	Instant creationDateTime;
	CategoryEnum category;

	public Post() {
		// TODO Auto-generated constructor stub
	}

}
