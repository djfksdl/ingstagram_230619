package com.ingstagram.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingstagram.comment.domain.Comment;
import com.ingstagram.comment.domain.CommentView;
import com.ingstagram.comment.mapper.CommentMapper;
import com.ingstagram.user.bo.UserBO;
import com.ingstagram.user.entity.UserEntity;

@Service
public class CommentBO {
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private UserBO userBO;
	
	public void addComment(int postId, int userId, String content) {
		commentMapper.insertComment(postId, userId, content);
	}
	
	//input: 글번호  output:List<CommentView>
	public List<CommentView> generateCommentViewListByPostId(int postId){
		List<CommentView> commentViewList = new ArrayList<>();
		
		List<Comment> commentList = commentMapper.selectCommentListByPostId(postId);
		
		
		// 반복문 순회
		// List<Comment> => List<CommentView>
		for(Comment comment : commentList) {
			CommentView commentView = new CommentView();
			
			// 댓글 내용 담기
			commentView.setComment(comment);
			
			// 댓글쓴이 내용 담기
			UserEntity user = userBO.getUserEntityByLoginId(comment.getUserId());
			commentView.setUser(user);
			
			//리스트에 담는다.
			commentViewList.add(commentView);
		}
		return commentViewList;
	}
	
	//input: 삭제할 댓글 번호  output: x
	public void deleteCommentById(int id) {
		commentMapper.deleteCommentById(id);
	}
	
	public void deleteCommentsByPostId(int postId) {
		commentMapper.deleteCommentById(postId);
	}
}
