package com.Intuit.socialNewsFeed.service.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Intuit.socialNewsFeed.model.CategoryEnum;
import com.Intuit.socialNewsFeed.model.Post;
import com.Intuit.socialNewsFeed.model.User;
import com.Intuit.socialNewsFeed.service.IPostsForTopicService;
import com.Intuit.socialNewsFeed.service.IRankingService;
import com.Intuit.socialNewsFeed.service.UserService;
import com.Intuit.socialNewsFeed.util.Constants;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	IPostsForTopicService postsForTopicService;
	@Autowired
	IRankingService rankingService;

	public UserServiceImpl(IPostsForTopicService postsForTopicService, IRankingService rankingService) {
		super();
		this.postsForTopicService = postsForTopicService;
		this.rankingService = rankingService;
	}

	@Override
	public List<Post> getPostFromInterestedTopics(User user, Instant since) {
		List<Post> postLst = new ArrayList<>();
		for (CategoryEnum i : user.getInterestedTopics()) {
			postLst.addAll(postsForTopicService.getPosts(i, since, Constants.PER_TOPIC_POST_TO_BE_FETCHED));
		}
		return postLst;
	}

	@Override
	public List<Post> getPostFromEventAroundLocation(User user, Instant since) {
		List<Post> postLst = new ArrayList<>();
		try {
			postLst.addAll(postsForTopicService.getPosts(CategoryEnum.valueOf(user.getLocation()), since,
					Constants.PER_TOPIC_POST_TO_BE_FETCHED));
		} catch (IllegalArgumentException e) {
		}
		try {
			postLst.addAll(postsForTopicService.getPosts(CategoryEnum.valueOf(user.getSubLocation()), since,
					Constants.PER_TOPIC_POST_TO_BE_FETCHED));
		} catch (IllegalArgumentException e) {
		}
		return postLst;
	}

	@Override
	public List<Post> getPostFromFriends(User user) {
		return user.getStoreFriendsPost().getPost(user);
	}

	@Override
	public List<Post> selectandGetPostUsingRankingLogic(User user, Instant since, int maxCount) {
		List<Post> topicsPostLst = getPostFromInterestedTopics(user, since);
		List<Post> friendsPostLst = getPostFromFriends(user);
		if (friendsPostLst.size() > Constants.PER_TOPIC_POST_TO_BE_FETCHED)
			friendsPostLst = friendsPostLst.subList(0, Constants.PER_TOPIC_POST_TO_BE_FETCHED);
		List<Post> eventPostLst = getPostFromEventAroundLocation(user, since);
		List<Post> output = rankingService.selectAndArrangePost(user, topicsPostLst, friendsPostLst, eventPostLst,
				maxCount);
		markPostAsSeen(user, output);
		return output;
	}

	@Override
	public void markPostAsSeen(User user, List<Post> postLst) {
		Map<Date, HashSet<String>> map = user.getSeenMap();
		for (Post post : postLst) {
			Date key = Date.from(post.getCreationDateTime());
			HashSet<String> postIdList = map.getOrDefault(key, new HashSet<String>());
			postIdList.add(post.getPostId());
			map.put(key, postIdList);
			user.getStoreFriendsPost().removePost(post);
		}
	}

}
