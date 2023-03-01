package com.Intuit.socialNewsFeed.service;

import java.util.List;

import com.Intuit.socialNewsFeed.model.Post;
import com.Intuit.socialNewsFeed.model.User;

public interface IRankingService {

	List<Post> selectAndArrangePost(User user, List<Post> topicsPostLst, List<Post> friendsPostLst,
			List<Post> eventPostLst, int maxCount);
	

}
