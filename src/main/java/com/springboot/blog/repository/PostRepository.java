package com.springboot.blog.repository;

import com.springboot.blog.entity.post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<post,Long> {


}
