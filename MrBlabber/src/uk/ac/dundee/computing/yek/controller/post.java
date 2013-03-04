package uk.ac.dundee.computing.yek.controller;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.math.BigDecimal;

import uk.ac.dundee.computing.yek.model.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class post {
	
	public post(){
	}

   	@SuppressWarnings("finally")
	public static LinkedList<PostStore> getMyPosts(Connection con, String username){
       	LinkedList<PostStore> postList =  new LinkedList<PostStore>();
       	PostStore post = null;
       	ResultSet resultSet = null;
   	
       	com.mysql.jdbc.Statement statement=null;
       	
       	String sqlQuery="SELECT * FROM posts LEFT JOIN person ON person.PersonID=posts.PostAuthor WHERE person.Username='" + username + "' ORDER BY posts.PostDate DESC;";
     	
       	System.out.println("post Query " + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (Statement) con.createStatement();
        		resultSet=statement.executeQuery(sqlQuery);  		
       		while (resultSet.next() ){
       			post= new PostStore();
       			post.setName(resultSet.getString("FirstName")+" " + resultSet.getString("LastName"));
       			post.setPostID(resultSet.getInt("PostID"));
       			post.setPostDate(resultSet.getLong("PostDate"));
       			post.setPostAuthor(resultSet.getInt("PostAuthor"));
       			post.setPostText(resultSet.getString("PostText"));
       			post.setPostFile(resultSet.getString("PostFile"));
       			postList.add(post);
        		}
       	}catch(Exception ex){
       		return null;
       	}
       	finally{
   	    	try{
   	    		statement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		return null;
   	    	}
   	    	return postList;
       	}
     }
    
    @SuppressWarnings("finally")
   	public static LinkedList<PostStore> getPosts(Connection con){
       	LinkedList<PostStore> postList =  new LinkedList<PostStore>();
       	PostStore post = null;
       	ResultSet resultSet = null;
   	
       	Statement statement=null;
       	String sqlQuery="SELECT * FROM posts LEFT JOIN person ON person.PersonID = posts.PersonID ORDER BY posts.PostDate DESC;";
       	System.out.println("post Query " + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (Statement) con.createStatement();
        		resultSet=statement.executeQuery(sqlQuery);  		
       		while (resultSet.next() ){
       			post= new PostStore();
       			post.setPostID(resultSet.getInt("PostID"));
       			post.setPostDate(resultSet.getLong("PostDate"));
       			post.setPostAuthor(resultSet.getInt("PostAuthor"));
       			post.setPostText(resultSet.getString("PostText"));
       			post.setPostFile(resultSet.getString("PostFile"));
       			postList.add(post);
        		}
       	}catch(Exception ex){
       		return null;
       	}
       	finally{
   	    	try{
   	    		statement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		return null;
   	    	}
   	    	return postList;
       	}
       }
    
    @SuppressWarnings("finally")
   	public static boolean sendPost(Connection con, PostStore post){
   	
       	com.mysql.jdbc.Statement statement=null;
       	String sqlQuery="INSERT INTO posts (PostAuthor, PostDate, PostText, PostFile) VALUES ("+
          	     post.getPostAuthor()+", "+new BigDecimal(post.getPostDate())+", '"+post.getPostText()+"', '"+post.getPostFile()+"');";
       	System.out.println("post Query " + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (Statement) con.createStatement();
        	statement.execute(sqlQuery);
        	
       	}catch(Exception ex){
       		ex.printStackTrace();
       		return false;
       	}
       	finally{
   	    	try{
   	    		statement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		return false;
   	    	}
   	    	return true;
       	}
       }
    
    @SuppressWarnings("finally")
	public static LinkedList<PostStore> getPostsForNews(Connection con, String follower){

		LinkedList<PostStore> postList =  new LinkedList<PostStore>();
		PostStore entry = null;
		ResultSet resultSet = null;
		Statement statement=null;

		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			int me = person.getIDbyUsername(con, follower);

			String sqlQuery="SELECT * FROM posts LEFT JOIN friendship ON posts.PostAuthor=friendship.Followee LEFT JOIN person ON posts.PostAuthor=person.personID WHERE friendship.Follower="+
			me+" ORDER BY posts.PostDate DESC";

			System.out.println("Friendship Query " + sqlQuery);

			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  	

			while (resultSet.next() ){
				entry= new PostStore();
				entry.setName(resultSet.getString("FirstName")+" " + resultSet.getString("LastName"));
				entry.setPostID(resultSet.getInt("PostID"));
				entry.setPostAuthor(resultSet.getInt("PersonID"));
				entry.setPostDate(resultSet.getLong("PostDate"));
				entry.setName(resultSet.getString("FirstName")+" "+resultSet.getString("LastName"));
				entry.setUsername(resultSet.getString("Username"));
				entry.setPostText(resultSet.getString("Bio"));
				
				postList.add(entry);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		finally{
			try{
				statement.close();
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
				return null;
			}
			return postList;
		}
	}

}

