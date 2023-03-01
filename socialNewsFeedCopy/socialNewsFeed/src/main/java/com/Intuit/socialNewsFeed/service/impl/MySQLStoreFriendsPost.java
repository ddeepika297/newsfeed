package com.Intuit.socialNewsFeed.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.Intuit.socialNewsFeed.model.Post;
import com.Intuit.socialNewsFeed.model.User;
import com.Intuit.socialNewsFeed.service.IStoreFriendsPost;
import com.Intuit.socialNewsFeed.util.Constants;


public class MySQLStoreFriendsPost implements IStoreFriendsPost {

	

	@Override
	public List<Post> getPost(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	//create table post( postId varchar(15) ,accountId varchar(15), postCreatorId varchar(15), content varchar(1000), url varchar(200),category varchar(20),
			//	 creation_date timestamp, primary key(postId,accountId));
	@Override
	public void addPost(User user, Post post) {
		// TODO Auto-generated method stub
		String QUERY = "insert into post(postId,accountID,postCreatorId,content,url,category,creation_date) values ("+post.getPostId()+","+user.getAccountID()+","+post;
	
	//create table post( postId varchar(15) ,accountId varchar(15), postCreatorId varchar(15), content varchar(1000), url varchar(200),category varchar(20),
		//	 creation_date timestamp, primary key(postId,accountId));
	
		
		try (Connection conn = DriverManager.getConnection(Constants.DB_URL,Constants. USER, Constants.PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				System.out.print(", num: " + rs.getInt("num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removePost(Post post) {
		// TODO Auto-generated method stub
		
	}
}
