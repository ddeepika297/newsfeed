package com.Intuit.socialNewsFeed.service;

import java.time.Instant;
import java.util.List;

import com.Intuit.socialNewsFeed.model.Post;
import com.Intuit.socialNewsFeed.model.User;

public interface UserService {

	// public void addFriendsPost();

	public List<Post> getPostFromFriends(User user);

	public List<Post> getPostFromInterestedTopics(User user, Instant since);
	
	public List<Post> getPostFromEventAroundLocation(User user,Instant since);

	public List<Post> selectandGetPostUsingRankingLogic(User user, Instant since, int maxCount);
	
	public void markPostAsSeen(User user, List<Post> postLst);
}
