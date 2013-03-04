package uk.ac.dundee.computing.yek.model;

import java.util.Calendar;

public class FriendshipStore {
	
	private int FriendshipID;
	private int Follower;
	private int Followee;
	private long StartDate;

	public FriendshipStore() {
		FriendshipID = 0;
		Followee = 0;
		Follower = 0;
		StartDate = Calendar.getInstance().getTimeInMillis();
	}

	public int getFollower() {
		return Follower;
	}

	public void setFollower(int follower) {
		Follower = follower;
	}

	public int getFollowee() {
		return Followee;
	}

	public void setFollowee(int followee) {
		Followee = followee;
	}

	public long getStartDate() {
		return StartDate;
	}

	public void setStartDate(long startDate) {
		StartDate = startDate;
	}

	public int getFriendshipID() {
		return FriendshipID;
	}

	public void setFriendshipID(int friendshipID) {
		FriendshipID = friendshipID;
	}

	
}
