package uk.ac.dundee.computing.yek.controller;

import java.sql.ResultSet;
import java.util.LinkedList;

import uk.ac.dundee.computing.yek.model.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class message {

	public message(){
	}


	@SuppressWarnings("finally")
	public LinkedList<MessageStore> getMessages(Connection con, int personID){
		LinkedList<MessageStore> messageList =  new LinkedList<MessageStore>();
		MessageStore message = null;
		ResultSet resultSet = null;

		Statement statement=null;
		String sqlQuery="SELECT * FROM messages WHERE MessageAuthor=" + personID + " OR MessageRecipient=" + personID + " ORDER BY MessageDate DESC;";
		System.out.println("message Query " + sqlQuery);
		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  		
			while (resultSet.next() ){
				message= new MessageStore();
				message.setMessageID(resultSet.getInt("MessageID"));
				message.setMessageDate(resultSet.getTimestamp("MessageDate"));
				message.setMessageAuthor(resultSet.getInt("MessageAuthor"));
				message.setMessageRecipient(resultSet.getInt("MessageRecipient"));
				message.setMessageText(resultSet.getString("MessageText"));

				messageList.add(message);
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
			return messageList;
		}
	}

	@SuppressWarnings("finally")
	public LinkedList<MessageStore> getAllMessages(Connection con, int sender, int recipient){
		LinkedList<MessageStore> messageList =  new LinkedList<MessageStore>();
		MessageStore message = null;
		ResultSet resultSet = null;

		Statement statement=null;
		String sqlQuery="SELECT * FROM messages WHERE MessageAuthor="+sender+" AND MessageRecipient="+recipient+" ORDER BY MessageDate DESC;";
		System.out.println("message Query " + sqlQuery);
		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  		
			while (resultSet.next() ){
				message= new MessageStore();
				message.setMessageID(resultSet.getInt("MessageID"));
				message.setMessageDate(resultSet.getTimestamp("MessageDate"));
				message.setMessageAuthor(resultSet.getInt("MessageAuthor"));
				message.setMessageRecipient(resultSet.getInt("MessageRecipient"));
				message.setMessageText(resultSet.getString("MessageText"));

				messageList.add(message);
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
			return messageList;
		}
	}

}

