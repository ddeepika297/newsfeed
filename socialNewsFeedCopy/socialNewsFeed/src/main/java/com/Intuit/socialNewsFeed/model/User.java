package com.Intuit.socialNewsFeed.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Intuit.socialNewsFeed.service.IStoreFriendsPost;
import com.Intuit.socialNewsFeed.service.impl.InMemoryStoreFriendsPost;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private static final Logger logger = LoggerFactory.getLogger(User.class);

	IStoreFriendsPost storeFriendsPost;
	final String accountID = UUID.randomUUID().toString().substring(0, 8);
	List<CategoryEnum> interestedTopics;
	List<String> friends;
	String location;
	String subLocation;
	Map<Date, HashSet<String>> seenMap;

	public User() {
		this.interestedTopics = new ArrayList<>();
		this.friends = new ArrayList<>();
		this.seenMap = new HashMap<>();
		storeFriendsPost = new InMemoryStoreFriendsPost();
	}

	public void addFriend(User friend) {
		friends.add(friend.accountID);
		logger.info("friend added");
	}

	public void removeFriend(User friend) {
		friends.remove(friend.accountID);
		logger.info("friend removed");
	}
}
