package com.ingstagram.post.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingstagram.post.entity.PostEntity;
import com.ingstagram.post.repository.PostRepository;

@Service
public class PostBO {
//	private Logger logger= LoggerFactory.getLogger(this.getClass());
//	
//	@Autowired
//	private PostRepository postRepository;
//	
//	@Autowired
//	private FileManagerService fileManager;
//	
//	@Autowired
//	private CommentBO commentBO;
//	
//	@Autowired
//	private LikeBO likeBO;
//	
//	// input: X  output: List<PostEntity>
//	public List<PostEntity> getPostList(){
//		return postRepository.findAllByOrderByIdDesc();
//	}
}
