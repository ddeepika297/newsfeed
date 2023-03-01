package com.Intuit.socialNewsFeed.service.impl;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Intuit.socialNewsFeed.model.Post;
import com.Intuit.socialNewsFeed.model.User;
import com.Intuit.socialNewsFeed.service.NewsFeedService;
import com.Intuit.socialNewsFeed.service.UserService;

@Service
public class NewsFeedServiceImpl implements NewsFeedService {
	private static final Logger logger = LoggerFactory.getLogger(NewsFeedServiceImpl.class);

	@Autowired
	UserService userService;

	public NewsFeedServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<Post> getNewsFeed(User user, Instant since, int maxCount) {
		logger.info("getting news feed");
		List<Post> postLst = userService.selectandGetPostUsingRankingLogic(user, since, maxCount);

		userService.markPostAsSeen(user, postLst);
		return postLst;
	}

}
