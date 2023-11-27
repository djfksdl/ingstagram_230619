package com.ingstagram.post.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ingstagram.post.entity.PostEntity;

@Repository
public interface PostRepository {
	public List<PostEntity> findAllByOrderByIdDesc();
}
