package com.Intuit.socialNewsFeed.service.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.Intuit.socialNewsFeed.model.CategoryEnum;
import com.Intuit.socialNewsFeed.model.Post;
import com.Intuit.socialNewsFeed.service.IPostsForTopicService;
import com.Intuit.socialNewsFeed.util.PostData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class DefaultPostsForTopic implements IPostsForTopicService {
	private static final Logger logger = LoggerFactory.getLogger(DefaultPostsForTopic.class);

	public List<Post> getPosts(CategoryEnum category, Instant since, int maxCount) {
		List<Post> postLst = new ArrayList<>();
		if (category == null)
			return postLst;
		String jsonString = PostData.getMap().getOrDefault(category, null);
		if (jsonString == null)
			return postLst;
		ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
		try {
			List<Post> jsonList = mapper.readValue(jsonString, new TypeReference<List<Post>>() {
			});
			for (Post post : jsonList) {
				if (post.getCreationDateTime().isAfter(since)) {
					postLst.add(post);
				}
				if (postLst.size() == maxCount)
					break;
			}

		} catch (Exception e) {
			logger.info("error in parsing json " + e.getMessage());
		}

		return postLst;

	}

}
