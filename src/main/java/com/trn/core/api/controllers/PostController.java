package com.trn.core.api.controllers;


import com.trn.core.api.payloads.PostDto;
import com.trn.core.api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId
            )
    {
        PostDto createPost = this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    //get by user

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(
            @PathVariable Integer userId
            ){
        List<PostDto> posts = this.postService.getPostByUser(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //get by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(
            @PathVariable Integer categoryId
    ){
        List<PostDto> posts = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    //get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost()
    {
        List<PostDto> postDtos = this.postService.getAllPost();
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }

    //get post by Id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
    {
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

}
