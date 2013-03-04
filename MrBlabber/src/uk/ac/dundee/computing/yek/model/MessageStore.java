package uk.ac.dundee.computing.yek.model;

import java.sql.Timestamp;
import java.util.Calendar;

public class MessageStore {
	
	private int MessageID;
	private Timestamp MessageDate;
	private int MessageAuthor;
	private int MessageRecipient;
	private String MessageText;
	
	public MessageStore() {
		MessageID = 0;
		MessageAuthor = 0;
		MessageRecipient = 0;
		MessageText = "";
		MessageDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

	public Timestamp getMessageDate() {
		return MessageDate;
	}

	public void setMessageDate(Timestamp messageDate) {
		MessageDate = messageDate;
	}

	public int getMessageAuthor() {
		return MessageAuthor;
	}

	public void setMessageAuthor(int messageAuthor) {
		MessageAuthor = messageAuthor;
	}

	public String getMessageText() {
		return MessageText;
	}

	public void setMessageText(String messageText) {
		MessageText = messageText;
	}

	public int getMessageRecipient() {
		return MessageRecipient;
	}

	public void setMessageRecipient(int messageRecipient) {
		MessageRecipient = messageRecipient;
	}

	public int getMessageID() {
		return MessageID;
	}

	public void setMessageID(int messageID) {
		MessageID = messageID;
	}
}
