package com.springboot.blog.service.impl;

import com.springboot.blog.entity.post;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override    //implement method
    public PostDto createPost(PostDto postDto) {

        //convert Dto to entity
        post post = mapToEntity(postDto);

        post newPost = postRepository.save(post);

        //convert entity to Dto\
        PostDto postResponse=mapToDTO(newPost);
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPost() {

        List<post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

    }


    //convert Entity to DTO
    private PostDto mapToDTO(post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    //convert Dto to Entity
    private post mapToEntity(PostDto postDto){
        post post = new post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
