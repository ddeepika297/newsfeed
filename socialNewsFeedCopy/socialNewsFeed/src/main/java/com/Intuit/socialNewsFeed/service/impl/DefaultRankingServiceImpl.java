package com.Intuit.socialNewsFeed.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.Intuit.socialNewsFeed.model.Post;
import com.Intuit.socialNewsFeed.model.User;
import com.Intuit.socialNewsFeed.service.IRankingService;
import com.Intuit.socialNewsFeed.util.SortPostByDateComparator;

// alternating between friend, topics and nearbyLocationEvents post
@Service
public class DefaultRankingServiceImpl implements IRankingService {

	@Override
	public List<Post> selectAndArrangePost(User user, List<Post> topicsPostLst, List<Post> friendsPostLst,
			List<Post> eventsPostLst, int maxCount) {
		Collections.shuffle(topicsPostLst);
		Collections.sort(topicsPostLst, new SortPostByDateComparator());
		Collections.shuffle(eventsPostLst);
		Collections.sort(eventsPostLst, new SortPostByDateComparator());
		List<Post> outputLst = new LinkedList<>();
		Map<Date, HashSet<String>> seenMap = user.getSeenMap();
		for (int i = 0, j = 0, k = 0; outputLst.size() < maxCount
				&& (i != friendsPostLst.size() || j != topicsPostLst.size() || k != eventsPostLst.size());) {
			if (i < friendsPostLst.size()) {

				checkAndAddPost(friendsPostLst.get(i), outputLst, seenMap);
				i++;
			}
			if (outputLst.size() >= maxCount)
				break;
			if (j < topicsPostLst.size()) {
				checkAndAddPost(topicsPostLst.get(j), outputLst, seenMap);
				j++;
			}
			if (outputLst.size() >= maxCount)
				break;
			if (k < eventsPostLst.size()) {
				checkAndAddPost(eventsPostLst.get(k), outputLst, seenMap);
				k++;
			}

		}
		return outputLst;
	}

	private void checkAndAddPost(Post post, List<Post> outputLst, Map<Date, HashSet<String>> seenMap) {

		Date key = Date.from(post.getCreationDateTime());
		if (!seenMap.containsKey(key) || !seenMap.get(key).contains(post.getPostId())) {
			outputLst.add(post);
		}

	}

}
