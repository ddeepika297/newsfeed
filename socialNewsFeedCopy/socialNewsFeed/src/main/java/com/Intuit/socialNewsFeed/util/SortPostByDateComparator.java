package com.Intuit.socialNewsFeed.util;

import java.util.Comparator;

import com.Intuit.socialNewsFeed.model.Post;

public class SortPostByDateComparator implements Comparator<Post> {

	@Override
	public int compare(Post o1, Post o2) {
		// descending order
		if (o1.getCreationDateTime().isAfter(o2.getCreationDateTime()))
			return -1;
		return 1;
	}

}
