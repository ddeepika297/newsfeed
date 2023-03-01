package com.Intuit.socialNewsFeed.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Intuit.socialNewsFeed.service.Observer;
import com.Intuit.socialNewsFeed.service.Subject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PubSubUser extends User implements Observer, Subject {

	private static final Logger logger = LoggerFactory.getLogger(PubSubUser.class);

	ArrayList<Observer> observerList;

	public PubSubUser() {

		super();
		this.observerList = new ArrayList<>();
	}

	public void addFriend(PubSubUser friend) {
		friend.registerObserver(this);
		friends.add(friend.accountID);
		logger.info("friend added");
	}

	public void removeFriend(PubSubUser friend) {
		if (friend.getObserverList().contains(friend)) {
			friend.unregisterObserver(this);
		}
		friends.remove(friend.accountID);
		logger.info("friend removed");
	}

	@Override
	public void registerObserver(Observer o) {
		observerList.add(o);

	}

	@Override
	public void unregisterObserver(Observer o) {
		observerList.remove(observerList.indexOf(o));

	}

	@Override
	public void sendPost(Post post) {
		post.postCreatorID = this.accountID;

		post.setCreationDateTime(Instant.now());

		if (post.getCategory() == null)
			post.setCategory(CategoryEnum.others);
		for (Iterator<Observer> it = observerList.iterator(); it.hasNext();) {
			Observer o = it.next();
			o.getPost(post);
		}

	}

	@Override
	public void getPost(Post post) {
		storeFriendsPost.addPost(this, post);

	}

}
