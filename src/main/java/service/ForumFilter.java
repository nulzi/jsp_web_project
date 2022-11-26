package service;

import java.util.ArrayList;

import domain.ForumVO;

public class ForumFilter {
	public static ArrayList<ForumVO> filterByCategory(ArrayList<ForumVO> forumList, String category) {
		ArrayList<ForumVO> filteredList = new ArrayList<ForumVO>();
		if(category.equals("전체")) return forumList;
		for(ForumVO post: forumList) {
//			System.out.println(post.getCategory());
			if(post.getCategory().equals(category)) {
				filteredList.add(post);
			}
		}
		return filteredList;
	}
}
