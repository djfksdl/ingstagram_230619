package com.ingstagram.comment.domain;

import com.ingstagram.user.entity.UserEntity;

import lombok.Data;

@Data
public class CommentView {
	private Comment comment;
	private UserEntity user;
}
