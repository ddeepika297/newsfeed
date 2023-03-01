package com.Intuit.socialNewsFeed.service;

import java.time.Instant;
import java.util.List;

import com.Intuit.socialNewsFeed.model.CategoryEnum;
import com.Intuit.socialNewsFeed.model.Post;

public interface IPostsForTopicService {
	public List<Post> getPosts(CategoryEnum category, Instant since, int maxCount);
}
