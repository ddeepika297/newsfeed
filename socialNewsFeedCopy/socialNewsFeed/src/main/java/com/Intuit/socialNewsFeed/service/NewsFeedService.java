package com.Intuit.socialNewsFeed.service;

import java.time.Instant;
import java.util.List;

import com.Intuit.socialNewsFeed.model.Post;
import com.Intuit.socialNewsFeed.model.User;

public interface NewsFeedService {

	List<Post> getNewsFeed(User user, Instant since, int maxCount);
}
