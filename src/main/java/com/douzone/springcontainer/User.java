package com.douzone.springcontainer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class User {
	private Long no;
	private String name = "정우현";
	private Friend friend;
	private List<String> friends;

	public User() {
		// 밑의 User때문에 default가 안생겨서 만들어줌
	}

	public User(String name) {
		this.name = name;
	}

	public User(Long no, String name) {
		this.no = no;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + ", friends=" + friends + "]";
	}
	
	
}
