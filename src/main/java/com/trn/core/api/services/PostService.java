package com.trn.core.api.services;

import com.trn.core.api.entities.Post;
import com.trn.core.api.payloads.PostDto;
import com.trn.core.api.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //create

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update

    PostDto updatePost(PostDto postDto, Integer postId);

    //delete

    void deletePost(Integer postId);

    //get single post

    PostDto getPostById(Integer postId);

    //get all posts

    PostResponse getAllPost(Integer pageNumber, Integer pageSize );

    //get all post by category

    List<PostDto> getPostByCategory(Integer categoryId);

    //get all posts by user

    List<PostDto> getPostByUser(Integer userId);

    //search posts
    List<Post> searchPosts(String keyword);



}
