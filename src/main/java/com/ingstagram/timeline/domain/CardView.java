package com.ingstagram.timeline.domain;

import java.util.List;

import com.ingstagram.comment.domain.CommentView;
import com.ingstagram.post.entity.PostEntity;
import com.ingstagram.user.entity.UserEntity;

import lombok.Data;

@Data
public class CardView {
	//글1개
	private PostEntity post;
	
	//글쓴이 정보
	private UserEntity user;
	
	//댓글들
	private List<CommentView> commentList;
	
	//좋아요 개수
	private int likeCount;
	
	//내가 좋아요를 눌렀는지 여부
	private boolean filledLike; // false:빈 하트, true:채워진 하트
	
}
