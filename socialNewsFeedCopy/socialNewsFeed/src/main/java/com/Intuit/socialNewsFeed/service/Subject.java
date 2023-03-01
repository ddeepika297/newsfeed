package com.Intuit.socialNewsFeed.service;

import com.Intuit.socialNewsFeed.model.Post;

public interface Subject {
	public void registerObserver(Observer o);

	public void unregisterObserver(Observer o);

	public void sendPost(Post post);
}
