package com.Intuit.socialNewsFeed.service.impl;

import java.util.List;
import java.util.Stack;

import com.Intuit.socialNewsFeed.model.Post;
import com.Intuit.socialNewsFeed.model.User;
import com.Intuit.socialNewsFeed.service.IStoreFriendsPost;

public class InMemoryStoreFriendsPost implements IStoreFriendsPost {

	public InMemoryStoreFriendsPost() {
	}

	static Stack<Post> friendPost = new Stack<>();

	@Override
	public void addPost(User user, Post post) {
		friendPost.add(post);
	}

	@Override
	public List<Post> getPost(User user) {
		return friendPost;
	}

	@Override
	public void removePost(Post post) {
		friendPost.remove(post);

	}

}
