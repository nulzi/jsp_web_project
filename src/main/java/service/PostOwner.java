package service;

import domain.ForumVO;

public class PostOwner {
	public static boolean isOwner(ForumVO post, String user_id) {
		if(post.getUser_id().equals(user_id)) return true;
		return false;
	}
}
