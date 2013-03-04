package uk.ac.dundee.computing.yek.controller;

import java.sql.ResultSet;
import java.util.LinkedList;

import uk.ac.dundee.computing.yek.model.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class friendship {

	public friendship(){
	}

	@SuppressWarnings("finally")
	public LinkedList<FriendshipStore> getAllFriendships(Connection con, int followee, int follower){
		LinkedList<FriendshipStore> friendshipList =  new LinkedList<FriendshipStore>();
		FriendshipStore friendship = null;
		ResultSet resultSet = null;

		Statement statement=null;
		String sqlQuery="SELECT * FROM friendship WHERE Followee="+followee+" AND Follower="+follower+" ORDER BY StartDate DESC;";
		System.out.println("Friendship Query " + sqlQuery);
		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  		
			while (resultSet.next() ){
				friendship= new FriendshipStore();
				friendship.setFriendshipID(resultSet.getInt("FriendshipID"));
				friendship.setStartDate(resultSet.getLong("StartDate"));
				friendship.setFollowee(resultSet.getInt("Followee"));
				friendship.setFollower(resultSet.getInt("Follower"));

				friendshipList.add(friendship);
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
			return friendshipList;
		}
	}

	//Load friendships by followee, thus when FOLLOWERS in twitter
	@SuppressWarnings("finally")
	public static LinkedList<FriendshipStore> getFriendshipByFollowee(Connection con, String followee){

		LinkedList<FriendshipStore> friendshipList =  new LinkedList<FriendshipStore>();
		FriendshipStore friendship = null;
		ResultSet resultSet = null;
		Statement statement=null;

		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			int me = person.getIDbyUsername(con, followee);

			String sqlQuery="SELECT * FROM friendship WHERE Followee="+me+" ORDER BY StartDate DESC;";
			System.out.println("Friendship Query " + sqlQuery);

			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  	

			while (resultSet.next() ){
				friendship= new FriendshipStore();
				friendship.setFriendshipID(resultSet.getInt("FriendshipID"));
				friendship.setStartDate(resultSet.getLong("StartDate"));
				friendship.setFollowee(resultSet.getInt("Followee"));
				friendship.setFollower(resultSet.getInt("Follower"));

				friendshipList.add(friendship);
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
			return friendshipList;
		}
	}


	//Load friendships by followee, thus when FOLLOWERS in twitter
	@SuppressWarnings("finally")
	public static LinkedList<FriendshipStore> getFriendshipByFollowee(Connection con, int followee){
		LinkedList<FriendshipStore> friendshipList =  new LinkedList<FriendshipStore>();
		FriendshipStore friendship = null;
		ResultSet resultSet = null;

		Statement statement=null;
		String sqlQuery="SELECT * FROM friendship WHERE Followee="+followee+" ORDER BY StartDate DESC;";
		System.out.println("Friendship Query " + sqlQuery);
		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  	

			while (resultSet.next() ){
				friendship= new FriendshipStore();
				friendship.setFriendshipID(resultSet.getInt("FriendshipID"));
				friendship.setStartDate(resultSet.getLong("StartDate"));
				friendship.setFollowee(resultSet.getInt("Followee"));
				friendship.setFollower(resultSet.getInt("Follower"));

				friendshipList.add(friendship);
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
			return friendshipList;
		}
	}


	//Load friendships by follower, thus when FOLLOWING in twitter
	@SuppressWarnings("finally")
	public static LinkedList<FriendshipStore> getFriendshipsByFollower(Connection con, int follower){
		LinkedList<FriendshipStore> friendshipList =  new LinkedList<FriendshipStore>();
		FriendshipStore friendship = null;
		ResultSet resultSet = null;

		Statement statement=null;
		String sqlQuery="SELECT * FROM friendship WHERE Follower="+follower+" ORDER BY StartDate DESC;";
		System.out.println("Friendship Query " + sqlQuery);
		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  	

			while (resultSet.next() ){
				friendship= new FriendshipStore();
				friendship.setFriendshipID(resultSet.getInt("FriendshipID"));
				friendship.setStartDate(resultSet.getLong("StartDate"));
				friendship.setFollowee(resultSet.getInt("Followee"));
				friendship.setFollower(resultSet.getInt("Follower"));

				friendshipList.add(friendship);
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
			return friendshipList;
		}
	}

	//Load friendships by follower, thus when FOLLOWING in twitter
	@SuppressWarnings("finally")
	public static LinkedList<FriendshipStore> getFriendshipByFollower(Connection con, String follower){

		LinkedList<FriendshipStore> friendshipList =  new LinkedList<FriendshipStore>();
		FriendshipStore friendship = null;
		ResultSet resultSet = null;
		Statement statement=null;

		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			int me = person.getIDbyUsername(con, follower);

			String sqlQuery="SELECT * FROM friendship WHERE Follower="+me+" ORDER BY StartDate DESC;";
			System.out.println("Friendship Query " + sqlQuery);

			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  	

			while (resultSet.next() ){
				friendship= new FriendshipStore();
				friendship.setFriendshipID(resultSet.getInt("FriendshipID"));
				friendship.setStartDate(resultSet.getLong("StartDate"));
				friendship.setFollowee(resultSet.getInt("Followee"));
				friendship.setFollower(resultSet.getInt("Follower"));

				friendshipList.add(friendship);
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
			return friendshipList;
		}
	}
	
	@SuppressWarnings("finally")
	public static LinkedList<PersonStore> getPeopleByFollower(Connection con, String follower){

		LinkedList<PersonStore> personList =  new LinkedList<PersonStore>();
		PersonStore entry = null;
		ResultSet resultSet = null;
		Statement statement=null;

		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			int me = person.getIDbyUsername(con, follower);

			String sqlQuery="SELECT * FROM person LEFT JOIN friendship ON friendship.Followee=person.PersonID WHERE friendship.Follower="+me+" ORDER BY friendship.StartDate DESC;";
			System.out.println("Friendship Query " + sqlQuery);

			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  	

			while (resultSet.next() ){
				entry= new PersonStore();
				entry.setPersonID(resultSet.getInt("PersonID"));
				entry.setDate(resultSet.getLong("StartDate"));
				entry.setFirstName(resultSet.getString("FirstName"));
				entry.setLastName(resultSet.getString("LastName"));
				entry.setUsername(resultSet.getString("Username"));
				entry.setBio(resultSet.getString("Bio"));
				
				personList.add(entry);
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
			return personList;
		}
	}
	
	@SuppressWarnings("finally")
	public static LinkedList<PersonStore> getPeopleByFollowee(Connection con, String followee){

		LinkedList<PersonStore> personList =  new LinkedList<PersonStore>();
		PersonStore entry = null;
		ResultSet resultSet = null;
		Statement statement=null;

		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			int me = person.getIDbyUsername(con, followee);

			String sqlQuery="SELECT * FROM person LEFT JOIN friendship ON friendship.Follower=person.PersonID WHERE friendship.Followee="+me+" ORDER BY friendship.StartDate DESC;";
			System.out.println("Friendship Query " + sqlQuery);

			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  	

			while (resultSet.next() ){
				entry= new PersonStore();
				entry.setPersonID(resultSet.getInt("PersonID"));
				entry.setDate(resultSet.getLong("StartDate"));
				entry.setFirstName(resultSet.getString("FirstName"));
				entry.setLastName(resultSet.getString("LastName"));
				entry.setUsername(resultSet.getString("Username"));
				entry.setBio(resultSet.getString("Bio"));
				
				personList.add(entry);
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
			return personList;
		}
	}
	
	@SuppressWarnings("finally")
	public static boolean sendFriendship(Connection con, FriendshipStore store){
       	com.mysql.jdbc.Statement statement=null;
       	String sqlQuery="INSERT INTO friendship (Follower, Followee, StartDate) VALUES ("+store.getFollower()+", "+store.getFollowee()+", "+store.getStartDate()+");";
       	System.out.println("User Query " + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (com.mysql.jdbc.Statement)con.createStatement();
       		statement.execute(sqlQuery);
       	}catch(Exception ex){
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
}

