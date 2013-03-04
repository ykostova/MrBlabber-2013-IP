package uk.ac.dundee.computing.yek.model;

import java.util.Calendar;

public class PostStore {
	
	private int PostID;
	private long PostDate;
	private int PostAuthor;
	private String PostText;
	private String PostFile;
	private String Username;
	private String Name;
	
	public PostStore() {
		PostID = 0;
		PostDate = Calendar.getInstance().getTimeInMillis();
		PostAuthor = 0;
		PostText = "";
		PostFile = "";
	}

	public long getPostDate() {
		return PostDate;
	}

	public void setPostDate(long postDate) {
		PostDate = postDate;
	}

	public int getPostAuthor() {
		return PostAuthor;
	}

	public void setPostAuthor(int postAuthor) {
		PostAuthor = postAuthor;
	}

	public String getPostText() {
		return PostText;
	}

	public void setPostText(String postText) {
		PostText = postText;
	}

	public String getPostFile() {
		return PostFile;
	}

	public void setPostFile(String postFile) {
		PostFile = postFile;
	}

	public int getPostID() {
		return PostID;
	}

	public void setPostID(int postID) {
		PostID = postID;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
