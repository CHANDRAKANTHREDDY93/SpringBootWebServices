package com.chand.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chand.demo.data.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
