package com.Intuit.socialNewsFeed.service;

import java.util.List;

import com.Intuit.socialNewsFeed.model.Post;
import com.Intuit.socialNewsFeed.model.User;

public interface IStoreFriendsPost {

	
	List<Post> getPost(User user);

	void addPost(User user, Post post);

	void removePost(Post post);

}
