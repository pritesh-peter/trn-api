package com.trn.core.api.controllers;


import com.trn.core.api.config.AppConstants;
import com.trn.core.api.payloads.ApiResponse;
import com.trn.core.api.payloads.PostDto;
import com.trn.core.api.payloads.PostResponse;
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
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false)Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false)Integer pageSize,
            @RequestParam(value="sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
            @RequestParam(value="sortDir",defaultValue = AppConstants.SORT_DIR, required = false) String sortDir
    )
    {
        PostResponse postResponse = this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }

    //get post by Id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
    {
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    //delete post by id
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId)
    {
        this.postService.deletePost(postId);
        return new ApiResponse("Post successfully deleted",true);
    }

    //update post by id
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId)
    {
        PostDto updatePost = this.postService.updatePost(postDto,postId);
        return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
    }

    //search title by keyword

    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(
            @PathVariable String keywords){
        List<PostDto> result = this.postService.searchPosts(keywords);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
