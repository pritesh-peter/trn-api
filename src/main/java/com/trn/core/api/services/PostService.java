package com.trn.core.api.services;

import com.trn.core.api.entities.Post;
import com.trn.core.api.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update

    Post updatePost(PostDto postDto, Integer postId);

    //delete

    void deletePost(Integer postId);

    //get single post

    Post getPostById(Integer postId);

    //get all posts

    List<Post> getAllPost();

    //get all post by category

    List<PostDto> getPostByCategory(Integer categoryId);

    //get all posts by user

    List<PostDto> getPostByUser(Integer userId);

    //search posts
    List<Post> searchPosts(String keyword);



}
