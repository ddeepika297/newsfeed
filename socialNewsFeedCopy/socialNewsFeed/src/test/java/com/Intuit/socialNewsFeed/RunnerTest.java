package com.Intuit.socialNewsFeed;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Intuit.socialNewsFeed.model.CategoryEnum;
import com.Intuit.socialNewsFeed.model.Post;
import com.Intuit.socialNewsFeed.model.PubSubUser;
import com.Intuit.socialNewsFeed.service.IPostsForTopicService;
import com.Intuit.socialNewsFeed.service.IRankingService;
import com.Intuit.socialNewsFeed.service.NewsFeedService;
import com.Intuit.socialNewsFeed.service.UserService;
import com.Intuit.socialNewsFeed.service.impl.DefaultPostsForTopic;
import com.Intuit.socialNewsFeed.service.impl.DefaultRankingServiceImpl;
import com.Intuit.socialNewsFeed.service.impl.NewsFeedServiceImpl;
import com.Intuit.socialNewsFeed.service.impl.UserServiceImpl;
import com.Intuit.socialNewsFeed.util.Constants;

public class RunnerTest {

	private static final Logger logger = LoggerFactory.getLogger(RunnerTest.class);
	final Instant SINCE_DATE_TIME = Instant.now().minus(Constants.FETCH_DAYS, ChronoUnit.DAYS);

	NewsFeedService newsFeedService;

	@BeforeEach
	void setUp() {
		IPostsForTopicService postsForTopicService = new DefaultPostsForTopic();
		IRankingService rankingService = new DefaultRankingServiceImpl();
		UserService userService = new UserServiceImpl(postsForTopicService, rankingService);
		newsFeedService = new NewsFeedServiceImpl(userService);
	}

	@Test
	void testnewsFeedFlow() throws InterruptedException {

		logger.info("Creating new user ");
		PubSubUser u1 = new PubSubUser();
		logger.info("create,add and remove friends");
		PubSubUser f1 = new PubSubUser();
		PubSubUser f2 = new PubSubUser();
		PubSubUser f3 = new PubSubUser();

		u1.addFriend(f1);
		u1.addFriend(f2);
		u1.addFriend(f3);
		Thread.sleep(1000);
		u1.removeFriend(f3);
		Thread.sleep(1000);

		logger.info(" set user location and sublocation");
		u1.setLocation("Bangalore");
		u1.setSubLocation("Bangalore:Sarjapur");
		
		logger.info("let friends make some posts");
		f1.sendPost(Post.builder().content("hello").build());
		f2.sendPost(Post.builder().content("all").build());
		f1.sendPost(Post.builder().content("GOOD MORNING").url("https://google.com/").build());
		Thread.sleep(1000);
		assertTrue (u1.getFriends().contains(f1.getAccountID()));
		assertTrue (u1.getFriends().contains(f2.getAccountID()));
		assertFalse (u1.getFriends().contains(f3.getAccountID()));
		logger.info("list of \"Topics\" that user is interested in");
		ArrayList<CategoryEnum> interestedTopics = new ArrayList<>();
		interestedTopics.add(CategoryEnum.Music);
		interestedTopics.add(CategoryEnum.Sports);
		interestedTopics.add(CategoryEnum.Meme);
		u1.setInterestedTopics(interestedTopics);

		List<Post> output = newsFeedService.getNewsFeed(u1, SINCE_DATE_TIME, Constants.NUMBER_OF_POSTS_TO_BE_FETCHED);
		assert (output.size() <= Constants.NUMBER_OF_POSTS_TO_BE_FETCHED);
		System.out.println();
		int index = 1;
		for (Post p : output) {
			System.out.println("Post" + (index++) + " : " + p);
		}

	}

}
